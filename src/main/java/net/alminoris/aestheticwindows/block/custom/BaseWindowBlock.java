package net.alminoris.aestheticwindows.block.custom;

import net.alminoris.aestheticwindows.sound.ModSounds;
import net.alminoris.aestheticwindows.util.helper.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class BaseWindowBlock extends YAxisRotatedBlock
{
    protected static final VoxelShape SHAPE = box(
            0.0D, 0.0D, 6.5D,
            16.0D, 16.0D, 9.5D
    );

    protected static final VoxelShape UP = box(
            1.0D, 15.0D, 6.5D,
            15.0D, 16.0D, 9.5D
    );

    protected static final VoxelShape DOWN = box(
            1.0D, 0.0D, 6.5D,
            15.0D, 1.0D, 9.5D
    );

    protected static final VoxelShape LEFT = box(
            0.0D, 0.0D, 6.5D,
            1.0D, 16.0D, 9.5D
    );

    protected static final VoxelShape RIGHT = box(
            15.0D, 0.0D, 6.5D,
            16.0D, 16.0D, 9.5D
    );

    public enum Variant implements StringRepresentable
    {
        NORMAL("normal"),
        CENTER("center"),
        LEFT("left"),
        RIGHT("right");

        private final String name;

        Variant(String name) { this.name = name; }

        @Override
        public String getSerializedName() { return this.name; }
    }

    public static final BooleanProperty OPEN = BooleanProperty.create("open");

    public static final EnumProperty<Variant> VARIANT = EnumProperty.create("variant", Variant.class);

    public BaseWindowBlock(Properties settings)
    {
        super(settings);
        this.registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(VARIANT, Variant.NORMAL).setValue(OPEN, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
        builder.add(VARIANT, OPEN);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context)
    {
        return getRotatedShape(state);
    }

    protected VoxelShape getRotatedShape(BlockState state)
    {
        Direction direction = state.getValue(FACING);

        List<AABB> boxes = new ArrayList<>();
        if (state.getValue(OPEN))
        {
            boxes.add(UP.bounds());
            boxes.add(DOWN.bounds());
            boxes.add(LEFT.bounds());
            boxes.add(RIGHT.bounds());
        }
        else
        {
            boxes.add(SHAPE.bounds());
        }

        return VoxelShapeHelper.rotateShape(boxes, direction);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit)
    {
        if (!player.getMainHandItem().isEmpty() || state.getValue(VARIANT) == Variant.CENTER)
        {
            return InteractionResult.PASS;
        }

        Variant currentVariant = state.getValue(VARIANT);
        boolean currentOpen = state.getValue(OPEN);

        if (!world.isClientSide)
        {
            if (!currentOpen)
                playSound(world, player, ModSounds.OPEN_WINDOW.get(), 1.0f, 1.0f);
            else
                playSound(world, player, ModSounds.CLOSE_WINDOW.get(), 1.0f, 1.0f);

            currentOpen = !currentOpen;
            Direction currentFacing = state.getValue(FACING);
            world.setBlock(pos, state
                    .setValue(FACING, currentFacing)
                    .setValue(VARIANT, currentVariant)
                    .setValue(OPEN, currentOpen), 3);

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.SUCCESS;
    }

    private void playSound(Level world, Player player, SoundEvent sound, float volume, float pitch)
    {
        world.playSound(null, player.getX(), player.getY(), player.getZ(),
                sound, player.getSoundSource(), volume, pitch);
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos)
    {
        super.updateShape(state, direction, neighborState, world, pos, neighborPos);

        return updateGardenWindowVariant(state, world, pos);
    }

    @Override
    protected void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean notify)
    {
        super.onPlace(state, world, pos, oldState, notify);
        updateSurroundingGardenWindows(world, pos);
    }

    private void updateSurroundingGardenWindows(Level world, BlockPos pos)
    {
        for (Direction direction : Direction.Plane.HORIZONTAL)
        {
            BlockPos neighborPos = pos.offset(direction.getNormal());
            BlockState neighborState = world.getBlockState(neighborPos);

            if (neighborState.getBlock() instanceof BaseWindowBlock)
                world.setBlock(neighborPos, updateGardenWindowVariant(neighborState, world, neighborPos), 3);
        }
    }

    private BlockState updateGardenWindowVariant(BlockState state, LevelAccessor world, BlockPos pos)
    {
        Direction facing = state.getValue(FACING);

        BlockPos leftPos = pos.offset(facing.getCounterClockWise(Direction.Axis.Y).getNormal());
        BlockPos rightPos = pos.offset(facing.getClockWise(Direction.Axis.Y).getNormal());

        boolean leftConnected = isWindow(world, leftPos, facing);
        boolean rightConnected = isWindow(world, rightPos, facing);

        if (leftConnected && rightConnected)
            return state.setValue(VARIANT, Variant.CENTER);
        else if (leftConnected)
            return state.setValue(VARIANT, Variant.RIGHT);
        else if (rightConnected)
            return state.setValue(VARIANT, Variant.LEFT);
        else
            return state.setValue(VARIANT, Variant.NORMAL);
    }

    private boolean isWindow(LevelAccessor world, BlockPos pos, Direction facing)
    {
        BlockState state = world.getBlockState(pos);
        return state.getBlock() instanceof BaseWindowBlock && state.getValue(FACING) == facing;
    }
}