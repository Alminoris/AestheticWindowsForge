package net.alminoris.aestheticwindows.item;

import net.alminoris.aestheticwindows.AestheticWindows;
import net.alminoris.aestheticwindows.block.ModBlocks;
import net.alminoris.aestheticwindows.util.helper.BlockSetsHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.alminoris.aestheticwindows.util.helper.BlockSetsHelper.*;
import static net.alminoris.aestheticwindows.util.helper.BlockSetsHelper.NSS_WOOD_NAMES;

@Mod.EventBusSubscriber(modid = AestheticWindows.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItemGroups
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AestheticWindows.MOD_ID);

    public static final RegistryObject<CreativeModeTab> AWS_TAB = CREATIVE_MODE_TABS.register("awstab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(ModBlocks.WINDOWS.get("oak").get().asItem()::getDefaultInstance)
            .title(Component.translatable("itemgroup.awstab"))
            .displayItems((parameters, entries) ->
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
            }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}