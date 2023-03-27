package net.mehvahdjukaar.complementaries.common.world.grower;

import net.mehvahdjukaar.complementaries.common.data.worldgen.ModConfiguredFeatureProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class PineTreeGrower extends AbstractTreeGrower {
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean hasFlowers) {
        return ModConfiguredFeatureProvider.PINE_TREE;
    }
}
