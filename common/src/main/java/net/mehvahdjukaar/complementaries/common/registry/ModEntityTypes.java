package net.mehvahdjukaar.complementaries.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.mehvahdjukaar.complementaries.Complementaries;
import net.mehvahdjukaar.complementaries.common.entity.Weighter;
import net.mehvahdjukaar.complementaries.common.util.PlatformUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class ModEntityTypes {
    public static final ResourcefulRegistry<EntityType<?>> ENTITY_TYPES = ResourcefulRegistries.create(BuiltInRegistries.ENTITY_TYPE, Complementaries.MOD_ID);

    public static final RegistryEntry<EntityType<Weighter>> WEIGHTER = ENTITY_TYPES.register("weighter", () -> EntityType.Builder.of(Weighter::new, MobCategory.CREATURE).sized(0.4f, 0.7f).build(Complementaries.MOD_ID));

    public static void onRegisterAttributes(BiConsumer<Supplier<? extends EntityType<? extends LivingEntity>>, Supplier<AttributeSupplier.Builder>> consumer) {
        consumer.accept(WEIGHTER, Weighter::createAttributes);
    }

    public static void registerSpawnPlacements() {
        PlatformUtils.registerSpawnPlacement(WEIGHTER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Weighter::checkMobSpawnRules);
    }
}