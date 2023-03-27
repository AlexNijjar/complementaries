package net.mehvahdjukaar.complementaries.common.world.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.mehvahdjukaar.complementaries.common.registry.ModTrunkPlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.function.BiConsumer;
import java.util.function.Function;

public class PineTrunkPlacer extends FancyTrunkPlacer {
    public static final Codec<PineTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> trunkPlacerParts(instance).apply(instance, PineTrunkPlacer::new));

    public PineTrunkPlacer(int i, int j, int k) {
        super(i, j, k);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacers.PINE_TRUNK_PLACER.get();
    }

    @Override
    protected boolean placeLog(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, BlockPos pos, TreeConfiguration config, Function<BlockState, BlockState> propertySetter) {
//        BlockState state = config.trunkProvider.getState(random, pos);
//        if (state.getBlock() instanceof RotatedPillarBlock && state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y) {
//            return super.placeLog(level, blockSetter, random, pos, config, propertySetter);
//        }
//        blockSetter.accept(pos, propertySetter.apply(ModBlocks.PINE_WOOD.get().defaultBlockState()));
        return super.placeLog(level, blockSetter, random, pos, config, propertySetter);
    }
}
