package net.alminoris.aestheticwindows.datagen;

import net.alminoris.aestheticwindows.AestheticWindows;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = AestheticWindows.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator packOutput = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        packOutput.addProvider(event.includeServer(), new ModLootTableProvider(packOutput));
        packOutput.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));

        packOutput.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        packOutput.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));

        packOutput.addProvider(event.includeClient(), new ModLanguageProviderEnUs(packOutput));
        packOutput.addProvider(event.includeClient(), new ModLanguageProviderDeDe(packOutput));
        packOutput.addProvider(event.includeClient(), new ModLanguageProviderEsEs(packOutput));
        packOutput.addProvider(event.includeClient(), new ModLanguageProviderFrFr(packOutput));
        packOutput.addProvider(event.includeClient(), new ModLanguageProviderRuRu(packOutput));
        packOutput.addProvider(event.includeClient(), new ModLanguageProviderUkUa(packOutput));
    }
}