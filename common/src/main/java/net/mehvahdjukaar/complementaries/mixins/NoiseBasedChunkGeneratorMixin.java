package net.mehvahdjukaar.complementaries.mixins;

import net.mehvahdjukaar.complementaries.common.worldgen.BeardifierAccess;
import net.mehvahdjukaar.complementaries.common.worldgen.NC;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.blending.Blender;
import org.apache.commons.lang3.mutable.MutableObject;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.OptionalInt;
import java.util.function.Predicate;

@Mixin(NoiseBasedChunkGenerator.class)
public class NoiseBasedChunkGeneratorMixin {

    @Inject(method = "iterateNoiseColumn",
            locals = LocalCapture.CAPTURE_FAILHARD,
            at = @At(value = "INVOKE",
            shift = At.Shift.BEFORE,
            target = "Lnet/minecraft/world/level/levelgen/NoiseChunk;getInterpolatedState()Lnet/minecraft/world/level/block/state/BlockState;"))
    public void passBiomeSource(LevelHeightAccessor level, RandomState random, int x, int z,
                   @Nullable MutableObject<NoiseColumn> column, @Nullable Predicate<BlockState> stoppingState,
                   CallbackInfoReturnable<OptionalInt> cir, NoiseSettings noiseSettings,
                   int i, int j, int k, int l, BlockState[] blockStates, int m, int n, int o, int p,
                   int q, int r, int s, double d, double e, NoiseChunk noiseChunk, int t, int u, int v, double f) {


      //   ((NC) noiseChunk).getSaltifer().setBiomeSource ((MultiNoiseBiomeSource) ((NoiseBasedChunkGenerator)(Object) this).getBiomeSource());
         var b = ((NC) noiseChunk).getBreadifier();
         if(b instanceof BeardifierAccess sb)sb.getInner().initialize((MultiNoiseBiomeSource) ((NoiseBasedChunkGenerator)(Object) this).getBiomeSource());
    }

    @Inject(method = "doFill",
            locals = LocalCapture.CAPTURE_FAILHARD,
            at = @At(value = "INVOKE",
                    shift = At.Shift.BEFORE,
                    target = "Lnet/minecraft/world/level/levelgen/NoiseChunk;getInterpolatedState()Lnet/minecraft/world/level/block/state/BlockState;"))
    public void passBiomeSource(Blender blender, StructureManager structureManager, RandomState random, ChunkAccess chunk, int minCellY, int cellCountY, CallbackInfoReturnable<ChunkAccess> cir, NoiseChunk noiseChunk, Heightmap heightmap, Heightmap heightmap2, ChunkPos chunkPos, int i, int j, Aquifer aquifer, BlockPos.MutableBlockPos mutableBlockPos, int k, int l, int m, int n, int o, int p, LevelChunkSection levelChunkSection, int q, int r, int s, int t, int u, double d, int v, int w, int x, double e, int y, int z, int aa, double f) {
     //   ((NC) noiseChunk).getSaltifer().setBiomeSource ((MultiNoiseBiomeSource) ((NoiseBasedChunkGenerator)(Object) this).getBiomeSource() );
        var b = ((NC) noiseChunk).getBreadifier();
        if(b instanceof BeardifierAccess sb)sb.getInner().initialize((MultiNoiseBiomeSource) ((NoiseBasedChunkGenerator)(Object) this).getBiomeSource());

    }
}
