package net.mehvahdjukaar.complementaries.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.mehvahdjukaar.complementaries.Complementaries;
import net.mehvahdjukaar.complementaries.common.world.feature.PineTrunkPlacer;
import net.mehvahdjukaar.complementaries.mixin.TrunkPlacerTypeInvoker;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class ModTrunkPlacers {
    public static final ResourcefulRegistry<TrunkPlacerType<?>> TRUNK_PLACERS = ResourcefulRegistries.create(BuiltInRegistries.TRUNK_PLACER_TYPE, Complementaries.MOD_ID);

    public static final RegistryEntry<TrunkPlacerType<PineTrunkPlacer>> PINE_TRUNK_PLACER = TRUNK_PLACERS.register("pine_trunk_placer", () -> TrunkPlacerTypeInvoker.invokeTrunkPlacerType(PineTrunkPlacer.CODEC));

}