package net.mehvahdjukaar.complementaries.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.mehvahdjukaar.complementaries.Complementaries;
import net.mehvahdjukaar.complementaries.common.registry.ModEntityTypes;

public class ComplementariesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Complementaries.init();
        ModEntityTypes.onRegisterAttributes((type, builder) -> FabricDefaultAttributeRegistry.register(type.get(), builder.get()));
    }
}
