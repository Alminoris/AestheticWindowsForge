package net.alminoris.aestheticwindows.block;

import net.alminoris.aestheticwindows.AestheticWindows;
import net.alminoris.aestheticwindows.block.custom.*;
import net.alminoris.aestheticwindows.item.ModItemGroups;
import net.alminoris.aestheticwindows.item.ModItems;
import net.alminoris.aestheticwindows.util.helper.BlockSetsHelper;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AestheticWindows.MOD_ID);

    public static final Dictionary<String, RegistryObject<Block>> WINDOWS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoodsNStones())
        {
            put(name, registerBlock("window_"+name, () -> new WindowBlock(BlockBehaviour.Properties.copy(Blocks.GLASS_PANE))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> VERTICAL_WINDOWS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoodsNStones())
        {
            put(name, registerBlock("vertical_window_"+name, () -> new WindowVerticalBlock(BlockBehaviour.Properties.copy(Blocks.GLASS_PANE))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> FOURPANE_WINDOWS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoodsNStones())
        {
            put(name, registerBlock("fourpane_window_"+name, () -> new FourpaneWindowBlock(BlockBehaviour.Properties.copy(Blocks.GLASS_PANE))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> VERTICAL_FOURPANE_WINDOWS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoodsNStones())
        {
            put(name, registerBlock("vertical_fourpane_window_"+name, () -> new FourpaneWindowVerticalBlock(BlockBehaviour.Properties.copy(Blocks.GLASS_PANE))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> EMPTY_WINDOWS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("empty_window_"+name, () -> new EmptyWindowBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD))));
        }

        for(String name : BlockSetsHelper.getStones())
        {
            put(name, registerBlock("empty_window_"+name, () -> new EmptyWindowBlock(BlockBehaviour.Properties.copy(Blocks.STONE))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> VERTICAL_EMPTY_WINDOWS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("vertical_empty_window_"+name, () -> new EmptyWindowVerticalBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD))));
        }

        for(String name : BlockSetsHelper.getStones())
        {
            put(name, registerBlock("vertical_empty_window_"+name, () -> new EmptyWindowVerticalBlock(BlockBehaviour.Properties.copy(Blocks.STONE))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> FOURPANE_EMPTY_WINDOWS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("fourpane_empty_window_"+name, () -> new FourpaneEmptyWindowBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD))));
        }

        for(String name : BlockSetsHelper.getStones())
        {
            put(name, registerBlock("fourpane_empty_window_"+name, () -> new FourpaneEmptyWindowBlock(BlockBehaviour.Properties.copy(Blocks.STONE))));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> VERTICAL_FOURPANE_EMPTY_WINDOWS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("vertical_fourpane_empty_window_"+name, () -> new FourpaneEmptyWindowVerticalBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD))));
        }

        for(String name : BlockSetsHelper.getStones())
        {
            put(name, registerBlock("vertical_fourpane_empty_window_"+name, () -> new FourpaneEmptyWindowVerticalBlock(BlockBehaviour.Properties.copy(Blocks.STONE))));
        }
    }};

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModItemGroups.AWS_TAB)));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}