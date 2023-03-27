package net.mehvahdjukaar.complementaries.client.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.mehvahdjukaar.complementaries.client.ComplementariesClient;

public class ComplementariesClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ComplementariesClient.init();
        ComplementariesClient.onRegisterItemColors(ColorProviderRegistry.ITEM::register);
        ComplementariesClient.onRegisterBlockColors(ColorProviderRegistry.BLOCK::register);
        ComplementariesClient.onRegisterEntityLayers((location, definition) -> EntityModelLayerRegistry.registerModelLayer(location, definition::get));

        ComplementariesClient.onRegisterParticles((type, provider) -> ParticleFactoryRegistry.getInstance().register(type.get(), provider::create));
    }
}
