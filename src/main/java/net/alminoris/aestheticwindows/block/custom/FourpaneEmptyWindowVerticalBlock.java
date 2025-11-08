package net.alminoris.aestheticwindows.block.custom;

import net.alminoris.aestheticwindows.block.ModBlocks;
import net.alminoris.aestheticwindows.util.helper.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import static net.alminoris.aestheticwindows.util.helper.BlockSetsHelper.getKeyByValue;

public class FourpaneEmptyWindowVerticalBlock extends BaseWindowVerticalBlock
{
    public FourpaneEmptyWindowVerticalBlock(Properties settings)
    {
        super(settings);
    }

    @Override
    protected VoxelShape getRotatedShape(BlockState state)
    {
        Direction direction = state.getValue(FACING);

        List<AABB> boxes = new ArrayList<>();
        boxes.add(UP.bounds());
        boxes.add(DOWN.bounds());
        boxes.add(LEFT.bounds());
        boxes.add(RIGHT.bounds());

        return VoxelShapeHelper.rotateShape(boxes, direction);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        ItemStack stack = player.getMainHandItem();
        if (!world.isClientSide && !getMaterialName().isEmpty() && stack.is(Blocks.GLASS_PANE.asItem()))
        {
            stack.shrink(1);

            world.setBlock(pos, ModBlocks.VERTICAL_FOURPANE_WINDOWS.get(getMaterialName()).get().defaultBlockState()
                    .setValue(FACING, state.getValue(FACING))
                    .setValue(VARIANT, state.getValue(VARIANT))
                    .setValue(OPEN, state.getValue(OPEN))
                    .setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);

            return InteractionResult.SUCCESS;
        }

        return super.use(state, world, pos, player, hand, hit);
    }

    private String getMaterialName()
    {
        if (getKeyByValue((Hashtable<String, RegistryObject<Block>>)ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS, this) != null)
            return getKeyByValue((Hashtable<String, RegistryObject<Block>>)ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS, this);

        return "";
    }
}