package net.mehvahdjukaar.complementaries.common.data.worldgen;

import net.mehvahdjukaar.complementaries.Complementaries;
import net.mehvahdjukaar.complementaries.common.registry.ModEntityTypes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModBiomeProvider {

    public static final ResourceKey<Biome> PINE_FOREST = createKey("pine_forest");

    public static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(Complementaries.MOD_ID, name));
    }

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<PlacedFeature> holderGetter = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> holderGetter2 = context.lookup(Registries.CONFIGURED_CARVER);

        context.register(PINE_FOREST, pineForest(holderGetter, holderGetter2));
    }

    public static Biome pineForest(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder builder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.farmAnimals(builder);
        builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 6, 4, 4));
        builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 16, 2, 4));
        builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 6, 2, 4));
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntityTypes.WEIGHTER.get(), 8, 1, 3));
        BiomeDefaultFeatures.commonSpawns(builder);

        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        globalOverworldGeneration(settings);
        BiomeDefaultFeatures.addDefaultOres(settings);
        BiomeDefaultFeatures.addDefaultSoftDisks(settings);
        BiomeDefaultFeatures.addDefaultMushrooms(settings);
        settings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatureProvider.SMALL_FOREST_ROCK);
        settings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatureProvider.COARSE_DIRT_PATCH);
        settings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureProvider.PINE_TREE);
        settings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureProvider.PINE_BUSH);
        settings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureProvider.PINE_FLOWERS);
        settings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureProvider.CARPETGRASS);
        settings.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, ModPlacedFeatureProvider.PINE_LOG_X);
        settings.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, ModPlacedFeatureProvider.PINE_LOG_Z);

        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_OLD_GROWTH_TAIGA);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.25f)
                .downfall(0.8f)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x237996)
                        .waterFogColor(0x0090ff)
                        .skyColor(0x76b3fd)
                        .fogColor(0xc0d8ff)
                        .grassColorOverride(0xab8f46)
                        .foliageColorOverride(0xa4a55e)
                        .backgroundMusic(music).build())
                .mobSpawnSettings(builder.build())
                .generationSettings(settings.build())
                .build();
    }

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder arg) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(arg);
        BiomeDefaultFeatures.addDefaultCrystalFormations(arg);
        BiomeDefaultFeatures.addDefaultMonsterRoom(arg);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(arg);
        BiomeDefaultFeatures.addDefaultSprings(arg);
        BiomeDefaultFeatures.addSurfaceFreezing(arg);
    }
}
