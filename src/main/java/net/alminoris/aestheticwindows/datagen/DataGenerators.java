package net.alminoris.aestheticwindows.datagen;

import net.alminoris.aestheticwindows.AestheticWindows;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

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

        packOutput.addProvider(new ModLootTableProvider(packOutput));
        packOutput.addProvider(new ModRecipeProvider(packOutput));

        packOutput.addProvider(new ModBlockStateProvider(packOutput, existingFileHelper));
        packOutput.addProvider(new ModItemModelProvider(packOutput, existingFileHelper));

        packOutput.addProvider(new ModLanguageProviderEnUs(packOutput));
        packOutput.addProvider(new ModLanguageProviderDeDe(packOutput));
        packOutput.addProvider(new ModLanguageProviderEsEs(packOutput));
        packOutput.addProvider(new ModLanguageProviderFrFr(packOutput));
        packOutput.addProvider(new ModLanguageProviderRuRu(packOutput));
        packOutput.addProvider(new ModLanguageProviderUkUa(packOutput));
    }
}