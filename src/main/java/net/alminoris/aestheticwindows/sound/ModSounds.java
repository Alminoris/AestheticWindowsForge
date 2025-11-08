package net.alminoris.aestheticwindows.sound;

import net.alminoris.aestheticwindows.AestheticWindows;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds
{
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AestheticWindows.MOD_ID);

    public static final RegistryObject<SoundEvent> OPEN_WINDOW = registerSound("open_window");
    public static final RegistryObject<SoundEvent> CLOSE_WINDOW = registerSound("close_window");


    private static RegistryObject<SoundEvent> registerSound(String name) {
        return SOUND_EVENTS.register(name,
                () -> new SoundEvent(ResourceLocation.fromNamespaceAndPath(AestheticWindows.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus)
    {
        SOUND_EVENTS.register(eventBus);
    }
}