package net.mehvahdjukaar.complementaries.datagen.provider.base;

import net.mehvahdjukaar.complementaries.Complementaries;
import net.mehvahdjukaar.complementaries.common.data.worldgen.ModBiomeProvider;
import net.mehvahdjukaar.complementaries.common.data.worldgen.ModConfiguredFeatureProvider;
import net.mehvahdjukaar.complementaries.common.data.worldgen.ModPlacedFeatureProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldgenProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatureProvider::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatureProvider::bootstrap)
            .add(Registries.BIOME, ModBiomeProvider::bootstrap);

    public ModWorldgenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Complementaries.MOD_ID));
    }
}
