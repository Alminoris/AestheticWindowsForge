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
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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
        ModItemGroups.register(modEventBus);
        ModSounds.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

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