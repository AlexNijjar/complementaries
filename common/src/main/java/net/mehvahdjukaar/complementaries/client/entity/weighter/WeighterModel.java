package net.mehvahdjukaar.complementaries.client.entity.weighter;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mehvahdjukaar.complementaries.common.entity.Weighter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.NotNull;

public class WeighterModel<T extends Weighter> extends HierarchicalModel<T> {
    private final ModelPart root;

    public WeighterModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    @SuppressWarnings("unused")
    public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition jaw01 = root.addOrReplaceChild("jaw01", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -4.0F));

		PartDefinition jaw01_r1 = jaw01.addOrReplaceChild("jaw01_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -16.0F, 0.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition jaw02 = root.addOrReplaceChild("jaw02", CubeListBuilder.create(), PartPose.offset(4.0F, 0.0F, 0.0F));

		PartDefinition jaw02_r1 = jaw02.addOrReplaceChild("jaw02_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -16.0F, 0.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, -0.1309F));

		PartDefinition jaw03 = root.addOrReplaceChild("jaw03", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 4.0F));

		PartDefinition jaw03_r1 = jaw03.addOrReplaceChild("jaw03_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -16.0F, 0.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.0107F, 0.0F, 3.1416F));

		PartDefinition jaw04 = root.addOrReplaceChild("jaw04", CubeListBuilder.create(), PartPose.offset(-4.0F, 0.0F, 0.0F));

		PartDefinition jaw04_r1 = jaw04.addOrReplaceChild("jaw04_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -16.0F, 0.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.1309F));

		PartDefinition foliage = root.addOrReplaceChild("foliage", CubeListBuilder.create().texOffs(-6, 16).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leaves01_r1 = foliage.addOrReplaceChild("leaves01_r1", CubeListBuilder.create().texOffs(0, 26).addBox(-10.0F, -6.0F, 0.0F, 20.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition leaves02_r1 = foliage.addOrReplaceChild("leaves02_r1", CubeListBuilder.create().texOffs(0, 26).addBox(-10.0F, -6.0F, 0.0F, 20.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animate(entity.idleAnimationState, WeighterAnimation.WEIGHTER_IDLE, ageInTicks);
        this.animate(entity.closeAnimationState, WeighterAnimation.WEIGHTER_CLOSE, ageInTicks);
        this.animate(entity.openAnimationState, WeighterAnimation.WEIGHTER_OPEN, ageInTicks);
    }

    @Override
    public @NotNull ModelPart root() {
        return this.root;
    }

    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int j, float f, float g, float h, float k) {
        MultiBufferSource provider = Minecraft.getInstance().renderBuffers().bufferSource();
        this.root().render(poseStack, provider.getBuffer(RenderType.entityCutout(WeighterRenderer.TEXTURE)), i, j, f, g, h, k);
    }
}
