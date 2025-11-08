package net.alminoris.aestheticwindows.datagen.loot;

import net.alminoris.aestheticwindows.block.ModBlocks;
import net.alminoris.aestheticwindows.util.helper.BlockSetsHelper;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLoot
{
    @Override
    protected void addTables()
    {
        for(String name : BlockSetsHelper.getWoodsNStones())
        {
            dropSelf(ModBlocks.EMPTY_WINDOWS.get(name).get());
            dropSelf(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get());
            dropSelf(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get());
            dropSelf(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get());

            add(ModBlocks.WINDOWS.get(name).get(), block -> createSilkTouchDispatchTable(block,
                    LootItem.lootTableItem(Blocks.GLASS_PANE)));
            add(ModBlocks.VERTICAL_WINDOWS.get(name).get(), block -> createSilkTouchDispatchTable(block,
                    LootItem.lootTableItem(Blocks.GLASS_PANE)));
            add(ModBlocks.FOURPANE_WINDOWS.get(name).get(), block -> createSilkTouchDispatchTable(block,
                    LootItem.lootTableItem(Blocks.GLASS_PANE)));
            add(ModBlocks.VERTICAL_FOURPANE_WINDOWS.get(name).get(), block -> createSilkTouchDispatchTable(block,
                    LootItem.lootTableItem(Blocks.GLASS_PANE)));
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
