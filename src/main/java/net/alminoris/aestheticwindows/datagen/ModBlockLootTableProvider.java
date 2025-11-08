package net.alminoris.aestheticwindows.datagen;

import net.alminoris.aestheticwindows.block.ModBlocks;
import net.alminoris.aestheticwindows.util.helper.BlockSetsHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider
{
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries)
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate()
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