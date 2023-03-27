package net.mehvahdjukaar.complementaries.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.mehvahdjukaar.complementaries.Complementaries;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;

public class ModParticleTypes {
    public static final ResourcefulRegistry<ParticleType<?>> PARTICLE_TYPES = ResourcefulRegistries.create(BuiltInRegistries.PARTICLE_TYPE, Complementaries.MOD_ID);

    public static final RegistryEntry<SimpleParticleType> POLLEN = PARTICLE_TYPES.register("pollen", () -> new SimpleParticleType(false) {
    });
}