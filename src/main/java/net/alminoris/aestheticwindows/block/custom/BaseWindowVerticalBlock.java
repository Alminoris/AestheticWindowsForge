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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseWindowVerticalBlock extends YAxisRotatedBlock
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
        UP("up"),
        DOWN("down");

        private final String name;

        Variant(String name) { this.name = name; }

        @Override
        public String getSerializedName() { return this.name; }
    }

    public static final BooleanProperty OPEN = BooleanProperty.create("open");

    public static final BooleanProperty FLIPPED = BooleanProperty.create("flipped");

    public static final EnumProperty<Variant> VARIANT = EnumProperty.create("variant", Variant.class);

    public BaseWindowVerticalBlock(BlockBehaviour.Properties settings)
    {
        super(settings);
        this.registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(VARIANT, Variant.NORMAL).setValue(OPEN, false).setValue(FLIPPED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
        builder.add(VARIANT, OPEN, FLIPPED);
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
            switch(state.getValue(VARIANT))
            {
                case NORMAL:
                    boxes.add(UP.bounds());
                    boxes.add(DOWN.bounds());
                    break;
                case UP:
                    boxes.add(UP.bounds());
                    break;
                case DOWN:
                    boxes.add(DOWN.bounds());
                    break;
            }
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
        if (!player.getMainHandItem().isEmpty())
        {
            return InteractionResult.PASS;
        }

        if (world.isClientSide) return InteractionResult.SUCCESS;

        if (!state.getValue(OPEN))
            playSound(world, player, ModSounds.OPEN_WINDOW.get(), 1.0f, 1.0f);
        else
            playSound(world, player, ModSounds.CLOSE_WINDOW.get(), 1.0f, 1.0f);

        boolean newOpen = !state.getValue(OPEN);
        Direction facing = state.getValue(FACING);

        List<BlockPos> stack = new ArrayList<>();
        Set<BlockPos> visited = new HashSet<>();
        stack.add(pos);

        while (!stack.isEmpty())
        {
            BlockPos currentPos = stack.remove(stack.size() - 1);
            if (!visited.add(currentPos)) continue;

            BlockState currentState = world.getBlockState(currentPos);

            if (currentState.getBlock() instanceof BaseWindowVerticalBlock &&
                    currentState.getValue(FACING) == facing)
            {

                Variant currentVariant = currentState.getValue(VARIANT);

                if (currentVariant == Variant.UP || currentVariant == Variant.DOWN || currentVariant == Variant.CENTER)
                {
                    world.setBlock(currentPos, currentState.setValue(OPEN, newOpen), 3);

                    stack.add(currentPos.above());
                    stack.add(currentPos.below());
                }
                else if (currentVariant == Variant.NORMAL)
                {
                    world.setBlock(currentPos, currentState.setValue(OPEN, newOpen), 3);
                }
            }
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

        return updateVerticalWindowVariant(state, world, pos);
    }

    @Override
    protected void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean notify)
    {
        super.onPlace(state, world, pos, oldState, notify);
        updateSurroundingVerticalWindows(world, pos);
    }

    private void updateSurroundingVerticalWindows(Level world, BlockPos pos)
    {
        for (Direction direction : new Direction[]{Direction.UP, Direction.DOWN})
        {
            BlockPos neighborPos = pos.offset(direction.getNormal());
            BlockState neighborState = world.getBlockState(neighborPos);

            if (neighborState.getBlock() instanceof BaseWindowVerticalBlock)
                world.setBlock(neighborPos, updateVerticalWindowVariant(neighborState, world, neighborPos), 3);
        }
    }

    private BlockState updateVerticalWindowVariant(BlockState state, LevelAccessor world, BlockPos pos)
    {
        Direction facing = state.getValue(FACING);
        BlockPos upPos = pos.above();
        BlockPos downPos = pos.below();

        boolean upConnected = isWindow(world, upPos, facing);
        boolean downConnected = isWindow(world, downPos, facing);

        Variant variant = Variant.NORMAL;
        if (upConnected && downConnected)
            variant = Variant.CENTER;
        else if (upConnected)
            variant = Variant.DOWN;
        else if (downConnected)
            variant = Variant.UP;

        BlockPos leftPos = pos.offset(facing.getClockWise(Direction.Axis.Y).getNormal());
        boolean flipped = isWindow(world, leftPos, facing);

        return state.setValue(VARIANT, variant).setValue(FLIPPED, flipped);
    }

    private boolean isWindow(LevelAccessor world, BlockPos pos, Direction facing)
    {
        BlockState state = world.getBlockState(pos);
        return state.getBlock() instanceof BaseWindowVerticalBlock && state.getValue(FACING) == facing;
    }
}
