package net.mehvahdjukaar.complementaries.client.entity;

import net.mehvahdjukaar.complementaries.Complementaries;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation WEIGHTER_LAYER = register("weighter");

    private static ModelLayerLocation register(String path) {
        return new ModelLayerLocation(new ResourceLocation(Complementaries.MOD_ID, path), "main");
    }
}
