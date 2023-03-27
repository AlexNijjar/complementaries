package net.mehvahdjukaar.complementaries.common.data.worldgen;

import com.google.common.collect.ImmutableList;
import net.mehvahdjukaar.complementaries.Complementaries;
import net.mehvahdjukaar.complementaries.common.registry.ModBlocks;
import net.mehvahdjukaar.complementaries.common.world.feature.PineTrunkPlacer;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatureProvider {

    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_TREE = createKey("pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_BUSH = createKey("pine_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CARPETGRASS = createKey("carpetgrass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COARSE_DIRT_PATCH = createKey("coarse_dirt_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_FOREST_ROCK = createKey("forest_rock");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_LOG_Z = createKey("pine_log_z");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_LOG_X = createKey("pine_log_x");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_FLOWERS = createKey("pine_flowers");

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Complementaries.MOD_ID, name));
    }

    @SuppressWarnings("deprecation")
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        context.register(PINE_TREE, new ConfiguredFeature<>(
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.PINE_LOG.get()),
                        new PineTrunkPlacer(14, 2, 1),
                        BlockStateProvider.simple(ModBlocks.PINE_LEAVES.get()),
                        new MegaPineFoliagePlacer(
                                ConstantInt.of(1),
                                ConstantInt.of(2),
                                UniformInt.of(3, 5)),
                        new TwoLayersFeatureSize(1, 1, 2))
                        .decorators(ImmutableList.of())
                        .build()));

        context.register(PINE_BUSH, new ConfiguredFeature<>(
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.PINE_LOG.get()),
                        new StraightTrunkPlacer(1, 0, 0),
                        BlockStateProvider.simple(ModBlocks.PINE_LEAVES.get()),
                        new BushFoliagePlacer(
                                ConstantInt.of(2),
                                ConstantInt.of(1),
                                2),
                        new TwoLayersFeatureSize(0, 0, 0))
                        .decorators(ImmutableList.of())
                        .build()));

        context.register(CARPETGRASS, new ConfiguredFeature<>(
                Feature.MULTIFACE_GROWTH,
                new MultifaceGrowthConfiguration(
                        (MultifaceBlock) ModBlocks.CARPETGRASS.get(),
                        3,
                        true,
                        true,
                        true,
                        0.5F,
                        HolderSet.direct(Block::builtInRegistryHolder,
                                Blocks.STONE,
                                Blocks.DIRT,
                                Blocks.GRASS_BLOCK))));

        context.register(COARSE_DIRT_PATCH, new ConfiguredFeature<>(
                Feature.DISK,
                new DiskConfiguration(
                        RuleBasedBlockStateProvider.simple(Blocks.COARSE_DIRT),
                        BlockPredicate.matchesBlocks(List.of(
                                Blocks.DIRT,
                                Blocks.GRASS_BLOCK)),
                        UniformInt.of(2, 3), 1)));

        context.register(SMALL_FOREST_ROCK, new ConfiguredFeature<>(
                Feature.FOREST_ROCK,
                new BlockStateConfiguration(Blocks.MOSSY_COBBLESTONE.defaultBlockState())));

        registerLog(context, Direction.NORTH, PINE_LOG_Z);
        registerLog(context, Direction.EAST, PINE_LOG_X);

        context.register(PINE_FLOWERS, new ConfiguredFeature<>(
                Feature.FLOWER,
                FeatureUtils.simpleRandomPatchConfiguration(64,
                        PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.ULTRAVIOLET.get().defaultBlockState(), 2).add(Blocks.CORNFLOWER.defaultBlockState(), 1))
                        )))));
    }

    private static void registerLog(BootstapContext<ConfiguredFeature<?, ?>> context, Direction direction, ResourceKey<ConfiguredFeature<?, ?>> log) {
        context.register(log, new ConfiguredFeature<>(
                Feature.BLOCK_COLUMN,
                new BlockColumnConfiguration(
                        List.of(
                                BlockColumnConfiguration.layer(BiasedToBottomInt.of(3, 5),
                                        BlockStateProvider.simple(ModBlocks.PINE_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, direction.getAxis())))),
                        direction,
                        BlockPredicate.ONLY_IN_AIR_PREDICATE,
                        false
                )));
    }
}
