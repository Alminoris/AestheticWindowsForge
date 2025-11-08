package net.alminoris.aestheticwindows.datagen;

import net.alminoris.aestheticwindows.AestheticWindows;
import net.alminoris.aestheticwindows.block.ModBlocks;
import net.alminoris.aestheticwindows.util.helper.BlockSetsHelper;
import net.alminoris.aestheticwindows.util.helper.ModJsonHelper;
import net.alminoris.aestheticwindows.util.helper.ModJsonTemplates;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;

public class ModBlockStateProvider extends BlockStateProvider
{
    public ModBlockStateProvider(DataGenerator output, ExistingFileHelper exFileHelper)
    {
        super(output, AestheticWindows.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        for(String name : BlockSetsHelper.getWoods())
        {
            String modId = Arrays.asList(BlockSetsHelper.WOODS).contains(name) ? "minecraft" : "aestheticwindows";

            registerWindow(
                    ModJsonTemplates.WINDOW, ModJsonTemplates.WINDOW_CENTER,
                    ModJsonTemplates.WINDOW_LEFT, ModJsonTemplates.WINDOW_RIGHT,
                    ModJsonTemplates.WINDOW_OPEN, ModJsonTemplates.WINDOW_OPEN_CENTER,
                    ModJsonTemplates.WINDOW_OPEN_LEFT, ModJsonTemplates.WINDOW_OPEN_RIGHT,
                    ModBlocks.WINDOWS.get(name), name, modId);

            registerVerticalWindow(
                    ModJsonTemplates.VERTICAL_WINDOW, ModJsonTemplates.VERTICAL_WINDOW_CENTER,
                    ModJsonTemplates.VERTICAL_WINDOW_UP, ModJsonTemplates.VERTICAL_WINDOW_DOWN,
                    ModJsonTemplates.VERTICAL_WINDOW_OPEN, ModJsonTemplates.VERTICAL_WINDOW_OPEN_CENTER,
                    ModJsonTemplates.VERTICAL_WINDOW_OPEN_UP, ModJsonTemplates.VERTICAL_WINDOW_OPEN_DOWN,
                    ModJsonTemplates.VERTICAL_WINDOW_FLIPPED, ModJsonTemplates.VERTICAL_WINDOW_CENTER_FLIPPED,
                    ModJsonTemplates.VERTICAL_WINDOW_UP_FLIPPED, ModJsonTemplates.VERTICAL_WINDOW_DOWN_FLIPPED,
                    ModJsonTemplates.VERTICAL_WINDOW_OPEN_FLIPPED, ModJsonTemplates.VERTICAL_WINDOW_CENTER_OPEN_FLIPPED,
                    ModJsonTemplates.VERTICAL_WINDOW_UP_OPEN_FLIPPED, ModJsonTemplates.VERTICAL_WINDOW_DOWN_OPEN_FLIPPED,
                    ModBlocks.VERTICAL_WINDOWS.get(name), name, modId);

            registerWindow(
                    ModJsonTemplates.FOURPANE_WINDOW, ModJsonTemplates.FOURPANE_WINDOW_CENTER,
                    ModJsonTemplates.FOURPANE_WINDOW_LEFT, ModJsonTemplates.FOURPANE_WINDOW_RIGHT,
                    ModJsonTemplates.FOURPANE_WINDOW_OPEN, ModJsonTemplates.FOURPANE_WINDOW_CENTER_OPEN,
                    ModJsonTemplates.FOURPANE_WINDOW_LEFT_OPEN, ModJsonTemplates.FOURPANE_WINDOW_RIGHT_OPEN,
                    ModBlocks.FOURPANE_WINDOWS.get(name), name, modId);

            registerVerticalWindow(
                    ModJsonTemplates.FOURPANE_VERTICAL_WINDOW, ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_CENTER,
                    ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_UP, ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_DOWN,
                    ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_OPEN, ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_CENTER_OPEN,
                    ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_UP_OPEN, ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_DOWN_OPEN,
                    ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_FLIPPED, ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_CENTER_FLIPPED,
                    ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_UP_FLIPPED, ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_DOWN_FLIPPED,
                    ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_OPEN_FLIPPED, ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_CENTER_OPEN_FLIPPED,
                    ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_UP_OPEN_FLIPPED, ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_DOWN_OPEN_FLIPPED,
                    ModBlocks.VERTICAL_FOURPANE_WINDOWS.get(name), name, modId);


            registerWindow(
                    ModJsonTemplates.EMPTY_WINDOW, ModJsonTemplates.EMPTY_WINDOW_CENTER,
                    ModJsonTemplates.EMPTY_WINDOW_LEFT, ModJsonTemplates.EMPTY_WINDOW_RIGHT,
                    ModJsonTemplates.EMPTY_WINDOW_OPEN, ModJsonTemplates.EMPTY_WINDOW_OPEN_CENTER,
                    ModJsonTemplates.EMPTY_WINDOW_OPEN_LEFT, ModJsonTemplates.EMPTY_WINDOW_OPEN_RIGHT,
                    ModBlocks.EMPTY_WINDOWS.get(name), name, modId);

            registerVerticalWindow(
                    ModJsonTemplates.VERTICAL_EMPTY_WINDOW, ModJsonTemplates.VERTICAL_EMPTY_WINDOW_CENTER,
                    ModJsonTemplates.VERTICAL_EMPTY_WINDOW_UP, ModJsonTemplates.VERTICAL_EMPTY_WINDOW_DOWN,
                    ModJsonTemplates.VERTICAL_EMPTY_WINDOW_OPEN, ModJsonTemplates.VERTICAL_EMPTY_WINDOW_OPEN_CENTER,
                    ModJsonTemplates.VERTICAL_EMPTY_WINDOW_OPEN_UP, ModJsonTemplates.VERTICAL_EMPTY_WINDOW_OPEN_DOWN,
                    ModJsonTemplates.VERTICAL_EMPTY_WINDOW_FLIPPED, ModJsonTemplates.VERTICAL_EMPTY_WINDOW_CENTER_FLIPPED,
                    ModJsonTemplates.VERTICAL_EMPTY_WINDOW_UP_FLIPPED, ModJsonTemplates.VERTICAL_EMPTY_WINDOW_DOWN_FLIPPED,
                    ModJsonTemplates.VERTICAL_EMPTY_WINDOW_OPEN_FLIPPED, ModJsonTemplates.VERTICAL_EMPTY_WINDOW_CENTER_OPEN_FLIPPED,
                    ModJsonTemplates.VERTICAL_EMPTY_WINDOW_UP_OPEN_FLIPPED, ModJsonTemplates.VERTICAL_EMPTY_WINDOW_DOWN_OPEN_FLIPPED,
                    ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name), name, modId);

            registerWindow(
                    ModJsonTemplates.FOURPANE_EMPTY_WINDOW, ModJsonTemplates.FOURPANE_EMPTY_WINDOW_CENTER,
                    ModJsonTemplates.FOURPANE_EMPTY_WINDOW_LEFT, ModJsonTemplates.FOURPANE_EMPTY_WINDOW_RIGHT,
                    ModJsonTemplates.FOURPANE_EMPTY_WINDOW_OPEN, ModJsonTemplates.FOURPANE_EMPTY_WINDOW_CENTER_OPEN,
                    ModJsonTemplates.FOURPANE_EMPTY_WINDOW_LEFT_OPEN, ModJsonTemplates.FOURPANE_EMPTY_WINDOW_RIGHT_OPEN,
                    ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name), name, modId);

            registerVerticalWindow(
                    ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW, ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_CENTER,
                    ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_UP, ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_DOWN,
                    ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_OPEN, ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_CENTER_OPEN,
                    ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_UP_OPEN, ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_DOWN_OPEN,
                    ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_FLIPPED, ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_CENTER_FLIPPED,
                    ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_UP_FLIPPED, ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_DOWN_FLIPPED,
                    ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_OPEN_FLIPPED, ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_CENTER_OPEN_FLIPPED,
                    ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_UP_OPEN_FLIPPED, ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_DOWN_OPEN_FLIPPED,
                    ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name), name, modId);
        }

        for(String name : BlockSetsHelper.getStones())
        {
            String modId = Arrays.asList(BlockSetsHelper.STONES).contains(name) ? "minecraft" : "aestheticwindows";

            registerStoneWindow(
                    ModJsonTemplates.WINDOW, ModJsonTemplates.WINDOW_CENTER,
                    ModJsonTemplates.WINDOW_LEFT, ModJsonTemplates.WINDOW_RIGHT,
                    ModJsonTemplates.WINDOW_OPEN, ModJsonTemplates.WINDOW_OPEN_CENTER,
                    ModJsonTemplates.WINDOW_OPEN_LEFT, ModJsonTemplates.WINDOW_OPEN_RIGHT,
                    ModBlocks.WINDOWS.get(name), name, modId);

            registerStoneVerticalWindow(
                    ModJsonTemplates.VERTICAL_WINDOW, ModJsonTemplates.VERTICAL_WINDOW_CENTER,
                    ModJsonTemplates.VERTICAL_WINDOW_UP, ModJsonTemplates.VERTICAL_WINDOW_DOWN,
                    ModJsonTemplates.VERTICAL_WINDOW_OPEN, ModJsonTemplates.VERTICAL_WINDOW_OPEN_CENTER,
                    ModJsonTemplates.VERTICAL_WINDOW_OPEN_UP, ModJsonTemplates.VERTICAL_WINDOW_OPEN_DOWN,
                    ModJsonTemplates.VERTICAL_WINDOW_FLIPPED, ModJsonTemplates.VERTICAL_WINDOW_CENTER_FLIPPED,
                    ModJsonTemplates.VERTICAL_WINDOW_UP_FLIPPED, ModJsonTemplates.VERTICAL_WINDOW_DOWN_FLIPPED,
                    ModJsonTemplates.VERTICAL_WINDOW_OPEN_FLIPPED, ModJsonTemplates.VERTICAL_WINDOW_CENTER_OPEN_FLIPPED,
                    ModJsonTemplates.VERTICAL_WINDOW_UP_OPEN_FLIPPED, ModJsonTemplates.VERTICAL_WINDOW_DOWN_OPEN_FLIPPED,
                    ModBlocks.VERTICAL_WINDOWS.get(name), name, modId);

            registerStoneWindow(
                    ModJsonTemplates.FOURPANE_WINDOW, ModJsonTemplates.FOURPANE_WINDOW_CENTER,
                    ModJsonTemplates.FOURPANE_WINDOW_LEFT, ModJsonTemplates.FOURPANE_WINDOW_RIGHT,
                    ModJsonTemplates.FOURPANE_WINDOW_OPEN, ModJsonTemplates.FOURPANE_WINDOW_CENTER_OPEN,
                    ModJsonTemplates.FOURPANE_WINDOW_LEFT_OPEN, ModJsonTemplates.FOURPANE_WINDOW_RIGHT_OPEN,
                    ModBlocks.FOURPANE_WINDOWS.get(name), name, modId);

            registerStoneVerticalWindow(
                    ModJsonTemplates.FOURPANE_VERTICAL_WINDOW, ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_CENTER,
                    ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_UP, ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_DOWN,
                    ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_OPEN, ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_CENTER_OPEN,
                    ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_UP_OPEN, ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_DOWN_OPEN,
                    ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_FLIPPED, ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_CENTER_FLIPPED,
                    ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_UP_FLIPPED, ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_DOWN_FLIPPED,
                    ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_OPEN_FLIPPED, ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_CENTER_OPEN_FLIPPED,
                    ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_UP_OPEN_FLIPPED, ModJsonTemplates.FOURPANE_VERTICAL_WINDOW_DOWN_OPEN_FLIPPED,
                    ModBlocks.VERTICAL_FOURPANE_WINDOWS.get(name), name, modId);

            registerStoneWindow(
                    ModJsonTemplates.EMPTY_WINDOW, ModJsonTemplates.EMPTY_WINDOW_CENTER,
                    ModJsonTemplates.EMPTY_WINDOW_LEFT, ModJsonTemplates.EMPTY_WINDOW_RIGHT,
                    ModJsonTemplates.EMPTY_WINDOW_OPEN, ModJsonTemplates.EMPTY_WINDOW_OPEN_CENTER,
                    ModJsonTemplates.EMPTY_WINDOW_OPEN_LEFT, ModJsonTemplates.EMPTY_WINDOW_OPEN_RIGHT,
                    ModBlocks.EMPTY_WINDOWS.get(name), name, modId);

            registerStoneVerticalWindow(
                    ModJsonTemplates.VERTICAL_EMPTY_WINDOW, ModJsonTemplates.VERTICAL_EMPTY_WINDOW_CENTER,
                    ModJsonTemplates.VERTICAL_EMPTY_WINDOW_UP, ModJsonTemplates.VERTICAL_EMPTY_WINDOW_DOWN,
                    ModJsonTemplates.VERTICAL_EMPTY_WINDOW_OPEN, ModJsonTemplates.VERTICAL_EMPTY_WINDOW_OPEN_CENTER,
                    ModJsonTemplates.VERTICAL_EMPTY_WINDOW_OPEN_UP, ModJsonTemplates.VERTICAL_EMPTY_WINDOW_OPEN_DOWN,
                    ModJsonTemplates.VERTICAL_EMPTY_WINDOW_FLIPPED, ModJsonTemplates.VERTICAL_EMPTY_WINDOW_CENTER_FLIPPED,
                    ModJsonTemplates.VERTICAL_EMPTY_WINDOW_UP_FLIPPED, ModJsonTemplates.VERTICAL_EMPTY_WINDOW_DOWN_FLIPPED,
                    ModJsonTemplates.VERTICAL_EMPTY_WINDOW_OPEN_FLIPPED, ModJsonTemplates.VERTICAL_EMPTY_WINDOW_CENTER_OPEN_FLIPPED,
                    ModJsonTemplates.VERTICAL_EMPTY_WINDOW_UP_OPEN_FLIPPED, ModJsonTemplates.VERTICAL_EMPTY_WINDOW_DOWN_OPEN_FLIPPED,
                    ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name), name, modId);

            registerStoneWindow(
                    ModJsonTemplates.FOURPANE_EMPTY_WINDOW, ModJsonTemplates.FOURPANE_EMPTY_WINDOW_CENTER,
                    ModJsonTemplates.FOURPANE_EMPTY_WINDOW_LEFT, ModJsonTemplates.FOURPANE_EMPTY_WINDOW_RIGHT,
                    ModJsonTemplates.FOURPANE_EMPTY_WINDOW_OPEN, ModJsonTemplates.FOURPANE_EMPTY_WINDOW_CENTER_OPEN,
                    ModJsonTemplates.FOURPANE_EMPTY_WINDOW_LEFT_OPEN, ModJsonTemplates.FOURPANE_EMPTY_WINDOW_RIGHT_OPEN,
                    ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name), name, modId);

            registerStoneVerticalWindow(
                    ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW, ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_CENTER,
                    ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_UP, ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_DOWN,
                    ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_OPEN, ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_CENTER_OPEN,
                    ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_UP_OPEN, ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_DOWN_OPEN,
                    ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_FLIPPED, ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_CENTER_FLIPPED,
                    ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_UP_FLIPPED, ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_DOWN_FLIPPED,
                    ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_OPEN_FLIPPED, ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_CENTER_OPEN_FLIPPED,
                    ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_UP_OPEN_FLIPPED, ModJsonTemplates.FOURPANE_VERTICAL_EMPTY_WINDOW_DOWN_OPEN_FLIPPED,
                    ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name), name, modId);
        }
    }

    public final void registerWindow( String normal,
                                     String center, String left, String right,
                                     String normalOpen, String centerOpen, String leftOpen, String rightOpen, RegistryObject<Block> window, String name, String modId)
    {
        String logName = (name.equals("crimson") || name.equals("warped")) ? "stem" : (name.equals("bamboo") ? "block" : "log");

        ModJsonHelper.registerWindowBlockModel(normal, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "normal", false);
        ModJsonHelper.registerWindowBlockModel(center, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "center", false);
        ModJsonHelper.registerWindowBlockModel(left, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "left", false);
        ModJsonHelper.registerWindowBlockModel(right, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "right", false);

        ModJsonHelper.registerWindowBlockModel(normalOpen, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "normal", true);
        ModJsonHelper.registerWindowBlockModel(centerOpen, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "center", true);
        ModJsonHelper.registerWindowBlockModel(leftOpen, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "left", true);
        ModJsonHelper.registerWindowBlockModel(rightOpen, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "right", true);

        ModJsonHelper.createBlockstate(ModJsonTemplates.SIMPLE_WINDOW_BLOCKSTATE_TEMPLATE, ForgeRegistries.BLOCKS.getKey(window.get()).getPath());
        blockItem(window, "block/"+ForgeRegistries.BLOCKS.getKey(window.get()).getPath());
    }

    public final void registerStoneWindow( String normal,
                                          String center, String left, String right,
                                          String normalOpen, String centerOpen, String leftOpen, String rightOpen, RegistryObject<Block> window, String name, String modId)
    {
        ModJsonHelper.registerWindowBlockModel(normal, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "normal", false);
        ModJsonHelper.registerWindowBlockModel(center, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "center", false);
        ModJsonHelper.registerWindowBlockModel(left, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "left", false);
        ModJsonHelper.registerWindowBlockModel(right, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "right", false);

        ModJsonHelper.registerWindowBlockModel(normalOpen, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "normal", true);
        ModJsonHelper.registerWindowBlockModel(centerOpen, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "center", true);
        ModJsonHelper.registerWindowBlockModel(leftOpen, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "left", true);
        ModJsonHelper.registerWindowBlockModel(rightOpen, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "right", true);


        ModJsonHelper.createBlockstate(ModJsonTemplates.SIMPLE_WINDOW_BLOCKSTATE_TEMPLATE, ForgeRegistries.BLOCKS.getKey(window.get()).getPath());
        blockItem(window, "block/"+ForgeRegistries.BLOCKS.getKey(window.get()).getPath());
    }

    public final void registerVerticalWindow(
                                             String normal, String center, String up, String down,
                                             String normalOpen, String centerOpen, String upOpen, String downOpen,
                                             String normalFlipped, String centerFlipped, String upFlipped, String downFlipped,
                                             String normalOpenFlipped, String centerOpenFlipped, String upOpenFlipped, String downOpenFlipped,
                                             RegistryObject<Block> window, String name, String modId)
    {
        String logName = (name.equals("crimson") || name.equals("warped")) ? "stem" : (name.equals("bamboo") ? "block" : "log");

        ModJsonHelper.registerWindowBlockModel(normal, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "normal", false, false);
        ModJsonHelper.registerWindowBlockModel(center, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "center", false, false);
        ModJsonHelper.registerWindowBlockModel(up, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "up", false, false);
        ModJsonHelper.registerWindowBlockModel(down, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "down", false, false);

        ModJsonHelper.registerWindowBlockModel(normalOpen, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "normal", true, false);
        ModJsonHelper.registerWindowBlockModel(centerOpen, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "center", true, false);
        ModJsonHelper.registerWindowBlockModel(upOpen, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "up", true, false);
        ModJsonHelper.registerWindowBlockModel(downOpen, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "down", true, false);

        ModJsonHelper.registerWindowBlockModel(normalFlipped, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "normal", false, true);
        ModJsonHelper.registerWindowBlockModel(centerFlipped, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "center", false, true);
        ModJsonHelper.registerWindowBlockModel(upFlipped, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "up", false, true);
        ModJsonHelper.registerWindowBlockModel(downFlipped, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "down", false, true);

        ModJsonHelper.registerWindowBlockModel(normalOpenFlipped, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "normal", true, true);
        ModJsonHelper.registerWindowBlockModel(centerOpenFlipped, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "center", true, true);
        ModJsonHelper.registerWindowBlockModel(upOpenFlipped, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "up", true, true);
        ModJsonHelper.registerWindowBlockModel(downOpenFlipped, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/stripped_"+name+"_"+logName,
                "minecraft:block/glass",
                modId+":block/"+name+"_"+logName,
                "down", true, true);

        ModJsonHelper.createBlockstate(ModJsonTemplates.VERTICAL_WINDOW_BLOCKSTATE_TEMPLATE, ForgeRegistries.BLOCKS.getKey(window.get()).getPath());
        blockItem(window, "block/"+ForgeRegistries.BLOCKS.getKey(window.get()).getPath());
    }

    public final void registerStoneVerticalWindow(
                                                  String normal, String center, String up, String down,
                                                  String normalOpen, String centerOpen, String upOpen, String downOpen,
                                                  String normalFlipped, String centerFlipped, String upFlipped, String downFlipped,
                                                  String normalOpenFlipped, String centerOpenFlipped, String upOpenFlipped, String downOpenFlipped,
                                                  RegistryObject<Block> window, String name, String modId)
    {
        ModJsonHelper.registerWindowBlockModel(normal, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "normal", false, false);
        ModJsonHelper.registerWindowBlockModel(center, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "center", false, false);
        ModJsonHelper.registerWindowBlockModel(up, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "up", false, false);
        ModJsonHelper.registerWindowBlockModel(down, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "down", false, false);

        ModJsonHelper.registerWindowBlockModel(normalOpen, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "normal", true, false);
        ModJsonHelper.registerWindowBlockModel(centerOpen, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "center", true, false);
        ModJsonHelper.registerWindowBlockModel(upOpen, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "up", true, false);
        ModJsonHelper.registerWindowBlockModel(downOpen, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "down", true, false);

        ModJsonHelper.registerWindowBlockModel(normalFlipped, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "normal", false, true);
        ModJsonHelper.registerWindowBlockModel(centerFlipped, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "center", false, true);
        ModJsonHelper.registerWindowBlockModel(upFlipped, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "up", false, true);
        ModJsonHelper.registerWindowBlockModel(downFlipped, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "down", false, true);

        ModJsonHelper.registerWindowBlockModel(normalOpenFlipped, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "normal", true, true);
        ModJsonHelper.registerWindowBlockModel(centerOpenFlipped, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "center", true, true);
        ModJsonHelper.registerWindowBlockModel(upOpenFlipped, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "up", true, true);
        ModJsonHelper.registerWindowBlockModel(downOpenFlipped, ForgeRegistries.BLOCKS.getKey(window.get()).getPath(),
                modId+":block/"+name,
                "minecraft:block/glass",
                modId+":block/"+name,
                "down", true, true);

        ModJsonHelper.createBlockstate(ModJsonTemplates.VERTICAL_WINDOW_BLOCKSTATE_TEMPLATE, ForgeRegistries.BLOCKS.getKey(window.get()).getPath());
        blockItem(window, "block/"+ForgeRegistries.BLOCKS.getKey(window.get()).getPath());
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String name)
    {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("aestheticwindows:" + name));
    }
}