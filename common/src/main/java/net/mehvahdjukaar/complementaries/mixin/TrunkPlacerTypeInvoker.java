package net.mehvahdjukaar.complementaries.mixin;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(TrunkPlacerType.class)
public interface TrunkPlacerTypeInvoker {
    @Invoker("<init>")
    static <T extends TrunkPlacer> TrunkPlacerType<T> invokeTrunkPlacerType(Codec<T> codec) {
        throw new UnsupportedOperationException();
    }
}
