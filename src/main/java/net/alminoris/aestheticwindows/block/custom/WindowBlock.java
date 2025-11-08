package net.alminoris.aestheticwindows.block.custom;

import net.alminoris.aestheticwindows.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;

import java.util.Hashtable;

import static net.alminoris.aestheticwindows.util.helper.BlockSetsHelper.getKeyByValue;

public class WindowBlock extends BaseWindowBlock
{
    public WindowBlock(Properties settings)
    {
        super(settings);
    }

    @Override
    public void destroy(LevelAccessor world, BlockPos pos, BlockState state)
    {
        super.destroy(world, pos, state);

        if (!world.isClientSide() && !getMaterialName().isEmpty())
        {
            world.setBlock(pos, ModBlocks.EMPTY_WINDOWS.get(getMaterialName()).get().defaultBlockState()
                    .setValue(FACING, state.getValue(FACING))
                    .setValue(VARIANT, state.getValue(VARIANT))
                    .setValue(OPEN, state.getValue(OPEN))
                    .setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 3);
        }
    }

    private String getMaterialName()
    {
        if (getKeyByValue((Hashtable<String, RegistryObject<Block>>)ModBlocks.WINDOWS, this) != null)
            return getKeyByValue((Hashtable<String, RegistryObject<Block>>)ModBlocks.WINDOWS, this);

        return "";
    }
}