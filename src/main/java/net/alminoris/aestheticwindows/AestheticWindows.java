package net.alminoris.aestheticwindows;

import com.mojang.logging.LogUtils;
import net.alminoris.aestheticwindows.block.ModBlocks;
import net.alminoris.aestheticwindows.item.ModItemGroups;
import net.alminoris.aestheticwindows.item.ModItems;
import net.alminoris.aestheticwindows.sound.ModSounds;
import net.alminoris.aestheticwindows.util.helper.BlockSetsHelper;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(AestheticWindows.MOD_ID)
public class AestheticWindows
{
    public static final String MOD_ID = "aestheticwindows";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AestheticWindows(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSounds.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents entries)
    {
        if (entries.getTab() == ModItemGroups.AWS_TAB)
        {
            for(String name : BlockSetsHelper.WOODS)
            {
                entries.accept(ModBlocks.WINDOWS.get(name).get());
                entries.accept(ModBlocks.VERTICAL_WINDOWS.get(name).get());
                entries.accept(ModBlocks.FOURPANE_WINDOWS.get(name).get());
                entries.accept(ModBlocks.VERTICAL_FOURPANE_WINDOWS.get(name).get());
            }

            if (ModList.get().isLoaded("arborealnature"))
            {
                for(String name : BlockSetsHelper.EXTRA_WOODS_AN)
                {
                    entries.accept(ModBlocks.WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.FOURPANE_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_FOURPANE_WINDOWS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("wildfields"))
            {
                for(String name : BlockSetsHelper.EXTRA_WOODS_WF)
                {
                    entries.accept(ModBlocks.WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.FOURPANE_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_FOURPANE_WINDOWS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("whisperleaftrees"))
            {
                for(String name : BlockSetsHelper.WT_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.FOURPANE_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_FOURPANE_WINDOWS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("silverwoodtrees"))
            {
                for(String name : BlockSetsHelper.ST_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.FOURPANE_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_FOURPANE_WINDOWS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("missingtrees"))
            {
                for(String name : BlockSetsHelper.MT_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.FOURPANE_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_FOURPANE_WINDOWS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("natures_spirit"))
            {
                for(String name : BlockSetsHelper.NSS_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.FOURPANE_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_FOURPANE_WINDOWS.get(name).get());
                }
            }

            for(String name : BlockSetsHelper.STONES)
            {
                entries.accept(ModBlocks.WINDOWS.get(name).get());
                entries.accept(ModBlocks.VERTICAL_WINDOWS.get(name).get());
                entries.accept(ModBlocks.FOURPANE_WINDOWS.get(name).get());
                entries.accept(ModBlocks.VERTICAL_FOURPANE_WINDOWS.get(name).get());
            }

            if (ModList.get().isLoaded("wildfields"))
            {
                for(String name : BlockSetsHelper.EXTRA_STONES_WF)
                {
                    entries.accept(ModBlocks.WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.FOURPANE_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_FOURPANE_WINDOWS.get(name).get());
                }
            }

            for(String name : BlockSetsHelper.WOODS)
            {
                entries.accept(ModBlocks.EMPTY_WINDOWS.get(name).get());
                entries.accept(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get());
                entries.accept(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get());
                entries.accept(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get());
            }

            if (ModList.get().isLoaded("arborealnature"))
            {
                for(String name : BlockSetsHelper.EXTRA_WOODS_AN)
                {
                    entries.accept(ModBlocks.EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("wildfields"))
            {
                for(String name : BlockSetsHelper.EXTRA_WOODS_WF)
                {
                    entries.accept(ModBlocks.EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("whisperleaftrees"))
            {
                for(String name : BlockSetsHelper.WT_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("silverwoodtrees"))
            {
                for(String name : BlockSetsHelper.ST_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("missingtrees"))
            {
                for(String name : BlockSetsHelper.MT_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("natures_spirit"))
            {
                for(String name : BlockSetsHelper.NSS_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get());
                }
            }

            for(String name : BlockSetsHelper.STONES)
            {
                entries.accept(ModBlocks.EMPTY_WINDOWS.get(name).get());
                entries.accept(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get());
                entries.accept(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get());
                entries.accept(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get());
            }

            if (ModList.get().isLoaded("wildfields"))
            {
                for(String name : BlockSetsHelper.EXTRA_STONES_WF)
                {
                    entries.accept(ModBlocks.EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.FOURPANE_EMPTY_WINDOWS.get(name).get());
                    entries.accept(ModBlocks.VERTICAL_FOURPANE_EMPTY_WINDOWS.get(name).get());
                }
            }
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            for (String name : BlockSetsHelper.getWoodsNStones())
            {
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.WINDOWS.get(name).get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.VERTICAL_WINDOWS.get(name).get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.FOURPANE_WINDOWS.get(name).get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.VERTICAL_FOURPANE_WINDOWS.get(name).get(), RenderType.translucent());
            }
        }
    }
}