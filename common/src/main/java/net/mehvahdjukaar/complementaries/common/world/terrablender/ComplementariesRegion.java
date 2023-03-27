package net.mehvahdjukaar.complementaries.common.world.terrablender;

import com.mojang.datafixers.util.Pair;
import net.mehvahdjukaar.complementaries.Complementaries;
import net.mehvahdjukaar.complementaries.common.data.worldgen.ModBiomeProvider;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class ComplementariesRegion extends Region {
    public static final ResourceLocation LOCATION = new ResourceLocation(Complementaries.MOD_ID, "overworld");

    public ComplementariesRegion(int weight) {
        super(LOCATION, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        mapper.accept(Pair.of(new Climate.ParameterPoint(
                Climate.Parameter.span(-1, 1),
                Climate.Parameter.span(-1, 1),
                Climate.Parameter.span(-0.11f, 1),
                Climate.Parameter.span(-1, 1),
                Climate.Parameter.point(0),
                Climate.Parameter.span(-1, -0.16f),
                0
        ), ModBiomeProvider.PINE_FOREST));
    }
}
