package net.mehvahdjukaar.complementaries.client.util;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.NotImplementedException;

import java.util.function.Supplier;

public class ClientPlatformUtils {
    @ExpectPlatform
    public static void registerBlockRenderType(RenderType type, Supplier<Block> block) {
        throw new NotImplementedException();
    }

    @ExpectPlatform
    public static <T extends Entity> void registerEntityRenderer(Supplier<? extends EntityType<? extends T>> entity, EntityRendererProvider<T> rendererProvider) {
        throw new NotImplementedException();
    }
}
