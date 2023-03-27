package net.mehvahdjukaar.complementaries.common.data.worldgen;

import net.mehvahdjukaar.complementaries.Complementaries;
import net.mehvahdjukaar.complementaries.common.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

public class ModPlacedFeatureProvider {
    public static final ResourceKey<PlacedFeature> PINE_TREE = createKey("pine");
    public static final ResourceKey<PlacedFeature> PINE_BUSH = createKey("pine_bush");
    public static final ResourceKey<PlacedFeature> CARPETGRASS = createKey("carpetgrass");
    public static final ResourceKey<PlacedFeature> COARSE_DIRT_PATCH = createKey("coarse_dirt_patch");
    public static final ResourceKey<PlacedFeature> SMALL_FOREST_ROCK = createKey("small_forest_rock");
    public static final ResourceKey<PlacedFeature> PINE_LOG_Z = createKey("pine_log_z");
    public static final ResourceKey<PlacedFeature> PINE_LOG_X = createKey("pine_log_x");
    public static final ResourceKey<PlacedFeature> PINE_FLOWERS = createKey("pine_flowers");

    public static ResourceKey<PlacedFeature> createKey(String string) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Complementaries.MOD_ID, string));
    }

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        var holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        context.register(PINE_TREE, new PlacedFeature(
                holderGetter.getOrThrow(ModConfiguredFeatureProvider.PINE_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1f, 1), ModBlocks.PINE_SAPLING.get())
        ));

        context.register(PINE_BUSH, new PlacedFeature(
                holderGetter.getOrThrow(ModConfiguredFeatureProvider.PINE_BUSH),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 1), ModBlocks.PINE_SAPLING.get())
        ));

        context.register(
                CARPETGRASS, new PlacedFeature(
                        holderGetter.getOrThrow(ModConfiguredFeatureProvider.CARPETGRASS),
                        List.of(
                                CountPlacement.of(256),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                                BlockPredicateFilter.forPredicate(BlockPredicate.not(BlockPredicate.matchesFluids(Fluids.WATER))),
                                BiomeFilter.biome()
                        )));

        context.register(
                COARSE_DIRT_PATCH, new PlacedFeature(
                        holderGetter.getOrThrow(ModConfiguredFeatureProvider.COARSE_DIRT_PATCH),
                        List.of(
                                CountPlacement.of(3),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP,
                                RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
                                BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Blocks.GRASS_BLOCK)),
                                BiomeFilter.biome()
                        )));

        context.register(
                SMALL_FOREST_ROCK, new PlacedFeature(
                        holderGetter.getOrThrow(ModConfiguredFeatureProvider.SMALL_FOREST_ROCK),
                        List.of(
                                CountPlacement.of(1),
                                RarityFilter.onAverageOnceEvery(5),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP,
                                BiomeFilter.biome()
                        )));

        registerLog(context, holderGetter, PINE_LOG_Z, ModConfiguredFeatureProvider.PINE_LOG_Z, 10);
        registerLog(context, holderGetter, PINE_LOG_X, ModConfiguredFeatureProvider.PINE_LOG_X, 9);

        context.register(
                PINE_FLOWERS, new PlacedFeature(
                        holderGetter.getOrThrow(ModConfiguredFeatureProvider.PINE_FLOWERS),
                        List.of(
                                RarityFilter.onAverageOnceEvery(5),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP,
                                BiomeFilter.biome())
                ));
    }

    private static void registerLog(BootstapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> holderGetter, ResourceKey<PlacedFeature> log, ResourceKey<ConfiguredFeature<?, ?>> log1, int average) {
        context.register(
                log, new PlacedFeature(
                        holderGetter.getOrThrow(log1),
                        List.of(
                                CountPlacement.of(2),
                                RarityFilter.onAverageOnceEvery(average),
                                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                                BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(ModBlocks.PINE_SAPLING.get().defaultBlockState(), BlockPos.ZERO)),
                                BiomeFilter.biome()
                        )));
    }
}
