package net.mehvahdjukaar.complementaries.client.forge;

import net.mehvahdjukaar.complementaries.client.ComplementariesClient;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ComplementariesClientForge {
    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(ComplementariesClientForge::onClientSetup);
        bus.addListener(ComplementariesClientForge::onSetupItemColors);
        bus.addListener(ComplementariesClientForge::onSetupBlockColors);
        bus.addListener(ComplementariesClientForge::onRegisterLayerDefinitions);
        bus.addListener(ComplementariesClientForge::onRegisterParticles);
    }

    public static void onClientSetup(FMLClientSetupEvent event) {
    }

    public static void onSetupItemColors(RegisterColorHandlersEvent.Item event) {
        ComplementariesClient.onRegisterItemColors(event::register);
    }

    public static void onSetupBlockColors(RegisterColorHandlersEvent.Block event) {
        ComplementariesClient.onRegisterBlockColors(event::register);
    }

    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        ComplementariesClient.onRegisterEntityLayers(event::registerLayerDefinition);
    }

    private static void onRegisterParticles(RegisterParticleProvidersEvent event) {
        ComplementariesClient.onRegisterParticles((type, provider) -> event.register(type.get(), provider::create));
    }
}
