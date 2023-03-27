package net.mehvahdjukaar.complementaries.client;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.mehvahdjukaar.complementaries.client.entity.ModModelLayers;
import net.mehvahdjukaar.complementaries.client.entity.weighter.WeighterModel;
import net.mehvahdjukaar.complementaries.client.entity.weighter.WeighterRenderer;
import net.mehvahdjukaar.complementaries.client.particle.PollenParticle;
import net.mehvahdjukaar.complementaries.client.util.ClientPlatformUtils;
import net.mehvahdjukaar.complementaries.common.registry.ModBlocks;
import net.mehvahdjukaar.complementaries.common.registry.ModEntityTypes;
import net.mehvahdjukaar.complementaries.common.registry.ModParticleTypes;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public class ComplementariesClient {
    public static void init() {
        registerRenderTypes();
        registerEntityRenderers();
    }

    public static void registerRenderTypes() {
        ClientPlatformUtils.registerBlockRenderType(RenderType.cutout(), ModBlocks.PINE_LEAVES);
        ClientPlatformUtils.registerBlockRenderType(RenderType.cutout(), ModBlocks.PINE_DOOR);
        ClientPlatformUtils.registerBlockRenderType(RenderType.cutout(), ModBlocks.PINE_TRAPDOOR);
        ClientPlatformUtils.registerBlockRenderType(RenderType.cutout(), ModBlocks.PINE_SAPLING);
        ClientPlatformUtils.registerBlockRenderType(RenderType.cutout(), ModBlocks.CARPETGRASS);
        ClientPlatformUtils.registerBlockRenderType(RenderType.cutout(), ModBlocks.ULTRAVIOLET);
    }

    public static void registerEntityRenderers() {
        ClientPlatformUtils.registerEntityRenderer(ModEntityTypes.WEIGHTER, WeighterRenderer::new);
    }

    public static void onRegisterItemColors(BiConsumer<ItemColor, ItemLike[]> consumer) {
        consumer.accept((itemStack, i) -> FoliageColor.getDefaultColor(), new ItemLike[]{
        });
        consumer.accept((itemStack, i) -> 0xa4a55e, new ItemLike[]{
                ModBlocks.PINE_LEAVES.get(),
                ModBlocks.CARPETGRASS.get()
        });
    }

    public static void onRegisterBlockColors(BiConsumer<BlockColor, Block[]> consumer) {
        consumer.accept((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? BiomeColors.getAverageFoliageColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(), new Block[]{
                ModBlocks.PINE_LEAVES.get(),
                ModBlocks.CARPETGRASS.get()
        });
    }

    public static void onRegisterEntityLayers(BiConsumer<ModelLayerLocation, Supplier<LayerDefinition>> consumer) {
        consumer.accept(ModModelLayers.WEIGHTER_LAYER, WeighterModel::createBodyLayer);
    }

    public static void onRegisterParticles(BiConsumer<RegistryEntry<SimpleParticleType>, SpriteParticleRegistration<SimpleParticleType>> consumer) {
        consumer.accept(ModParticleTypes.POLLEN, PollenParticle.Provider::new);
    }

    @FunctionalInterface
    public interface SpriteParticleRegistration<T extends ParticleOptions> {
        ParticleProvider<T> create(SpriteSet spriteSet);
    }
}
