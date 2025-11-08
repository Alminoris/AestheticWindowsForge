package net.alminoris.aestheticwindows.datagen;

import net.alminoris.aestheticwindows.block.ModBlocks;
import net.alminoris.aestheticwindows.util.helper.BlockSetsHelper;
import net.alminoris.aestheticwindows.util.helper.ModJsonHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public ModRecipeProvider(PackOutput pOutput)
    {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> recipeExporter)
    {
        for(String name : BlockSetsHelper.WOODS)
        {
            Block block = ForgeRegistries.BLOCKS.getValue(ResourceLocation.withDefaultNamespace(name+"_planks"));

            stonecutterResultFromBase(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMPTY_WINDOWS.get(name).get(), block, 1);
            stonecutterResultFromBase(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get(), block, 1);
            stonecutterResultFromBase(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get(), block, 1);
            stonecutterResultFromBase(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get(), block, 1);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WINDOWS.get(name).get())
                    .requires(ModBlocks.EMPTY_WINDOWS.get(name).get())
                    .requires(Blocks.GLASS_PANE)
                    .unlockedBy(getHasName(ModBlocks.EMPTY_WINDOWS.get(name).get()), has(ModBlocks.EMPTY_WINDOWS.get(name).get()))
                    .unlockedBy(getHasName(Blocks.GLASS_PANE), has(Blocks.GLASS_PANE))
                    .save(recipeExporter);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VERTICAL_WINDOWS.get(name).get())
                    .requires(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get())
                    .requires(Blocks.GLASS_PANE)
                    .unlockedBy(getHasName(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get()), has(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get()))
                    .unlockedBy(getHasName(Blocks.GLASS_PANE), has(Blocks.GLASS_PANE))
                    .save(recipeExporter);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FOURPANE_WINDOWS.get(name).get())
                    .requires(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get())
                    .requires(Blocks.GLASS_PANE)
                    .unlockedBy(getHasName(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get()), has(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get()))
                    .unlockedBy(getHasName(Blocks.GLASS_PANE), has(Blocks.GLASS_PANE))
                    .save(recipeExporter);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VERTICAL_FOURPANE_WINDOWS.get(name).get())
                    .requires(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get())
                    .requires(Blocks.GLASS_PANE)
                    .unlockedBy(getHasName(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get()), has(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get()))
                    .unlockedBy(getHasName(Blocks.GLASS_PANE), has(Blocks.GLASS_PANE))
                    .save(recipeExporter);
        }

        for(String name : BlockSetsHelper.STONES)
        {
            Block block = ForgeRegistries.BLOCKS.getValue(ResourceLocation.withDefaultNamespace(name.equals("basalt_side") ? "basalt" :
                    (name.equals("quartz_block_bottom") ? "quartz_block" : name)));

            stonecutterResultFromBase(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMPTY_WINDOWS.get(name).get(), block, 1);
            stonecutterResultFromBase(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get(), block, 1);
            stonecutterResultFromBase(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get(), block, 1);
            stonecutterResultFromBase(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get(), block, 1);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WINDOWS.get(name).get())
                    .requires(ModBlocks.EMPTY_WINDOWS.get(name).get())
                    .requires(Blocks.GLASS_PANE)
                    .unlockedBy(getHasName(ModBlocks.EMPTY_WINDOWS.get(name).get()), has(ModBlocks.EMPTY_WINDOWS.get(name).get()))
                    .unlockedBy(getHasName(Blocks.GLASS_PANE), has(Blocks.GLASS_PANE))
                    .save(recipeExporter);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VERTICAL_WINDOWS.get(name).get())
                    .requires(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get())
                    .requires(Blocks.GLASS_PANE)
                    .unlockedBy(getHasName(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get()), has(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get()))
                    .unlockedBy(getHasName(Blocks.GLASS_PANE), has(Blocks.GLASS_PANE))
                    .save(recipeExporter);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FOURPANE_WINDOWS.get(name).get())
                    .requires(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get())
                    .requires(Blocks.GLASS_PANE)
                    .unlockedBy(getHasName(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get()), has(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get()))
                    .unlockedBy(getHasName(Blocks.GLASS_PANE), has(Blocks.GLASS_PANE))
                    .save(recipeExporter);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VERTICAL_FOURPANE_WINDOWS.get(name).get())
                    .requires(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get())
                    .requires(Blocks.GLASS_PANE)
                    .unlockedBy(getHasName(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get()), has(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get()))
                    .unlockedBy(getHasName(Blocks.GLASS_PANE), has(Blocks.GLASS_PANE))
                    .save(recipeExporter);
        }

        for(String name : BlockSetsHelper.EXTRA_STONES_WF)
        {
            ModJsonHelper.createStonecuttingRecipe("wildfields:"+name,
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("wildfields:"+name,
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("wildfields:"+name,
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("wildfields:"+name,
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get()).getPath(), "1");
        }

        for(String name : BlockSetsHelper.EXTRA_WOODS_AN)
        {
            ModJsonHelper.createStonecuttingRecipe("arborealnature:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("arborealnature:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("arborealnature:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("arborealnature:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get()).getPath(), "1");
        }

        for(String name : BlockSetsHelper.EXTRA_WOODS_WF)
        {
            ModJsonHelper.createStonecuttingRecipe("wildfields:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("wildfields:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("wildfields:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("wildfields:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get()).getPath(), "1");
        }

        for(String name : BlockSetsHelper.WT_WOOD_NAMES)
        {
            ModJsonHelper.createStonecuttingRecipe("whisperleaftrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("whisperleaftrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("whisperleaftrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("whisperleaftrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get()).getPath(), "1");
        }

        for(String name : BlockSetsHelper.ST_WOOD_NAMES)
        {
            ModJsonHelper.createStonecuttingRecipe("silverwoodtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("silverwoodtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("silverwoodtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("silverwoodtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get()).getPath(), "1");
        }

        for(String name : BlockSetsHelper.MT_WOOD_NAMES)
        {
            ModJsonHelper.createStonecuttingRecipe("missingtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("missingtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("missingtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("missingtrees:"+name+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get()).getPath(), "1");
        }

        for(String name : BlockSetsHelper.NSS_WOOD_NAMES)
        {
            ModJsonHelper.createStonecuttingRecipe("natures_spirit:"+name.replace("_nss", "")+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("natures_spirit:"+name.replace("_nss", "")+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("natures_spirit:"+name.replace("_nss", "")+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get()).getPath(), "1");

            ModJsonHelper.createStonecuttingRecipe("natures_spirit:"+name.replace("_nss", "")+"_planks",
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get()).getPath(), "1");
        }

        for (String name: BlockSetsHelper.getWoodsNStones())
        {
            if (Arrays.asList(BlockSetsHelper.STONES).contains(name) || Arrays.asList(BlockSetsHelper.WOODS).contains(name))
                continue;

            ModJsonHelper.createShapelessRecipe("minecraft:glass_pane",
                    "aestheticwindows:"+ForgeRegistries.BLOCKS.getKey(ModBlocks.EMPTY_WINDOWS.get(name).get()).getPath(),
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.WINDOWS.get(name).get()).getPath());

            ModJsonHelper.createShapelessRecipe("minecraft:glass_pane",
                    "aestheticwindows:"+ForgeRegistries.BLOCKS.getKey(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get()).getPath(),
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.VERTICAL_WINDOWS.get(name).get()).getPath());

            ModJsonHelper.createShapelessRecipe("minecraft:glass_pane",
                    "aestheticwindows:"+ForgeRegistries.BLOCKS.getKey(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get()).getPath(),
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.FOURPANE_WINDOWS.get(name).get()).getPath());

            ModJsonHelper.createShapelessRecipe("minecraft:glass_pane",
                    "aestheticwindows:"+ForgeRegistries.BLOCKS.getKey(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get()).getPath(),
                    ForgeRegistries.BLOCKS.getKey(ModBlocks.VERTICAL_FOURPANE_WINDOWS.get(name).get()).getPath());
        }
    }
}