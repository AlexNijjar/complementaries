package net.mehvahdjukaar.complementaries.client.entity.weighter;

import net.mehvahdjukaar.complementaries.Complementaries;
import net.mehvahdjukaar.complementaries.client.entity.ModModelLayers;
import net.mehvahdjukaar.complementaries.common.entity.Weighter;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class WeighterRenderer extends MobRenderer<Weighter, WeighterModel<Weighter>> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Complementaries.MOD_ID, "textures/entity/weighter/weighter.png");

    public WeighterRenderer(EntityRendererProvider.Context context) {
		super(context, new WeighterModel<>(context.bakeLayer(ModModelLayers.WEIGHTER_LAYER)), 0.3F);
	}

    @Override
    public @NotNull ResourceLocation getTextureLocation(Weighter entity) {
        return TEXTURE;
    }
}
