package net.mehvahdjukaar.complementaries.common.entity;

import net.mehvahdjukaar.complementaries.common.registry.ModParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class Weighter extends Mob {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState openAnimationState = new AnimationState();
    public final AnimationState closeAnimationState = new AnimationState();

    public Weighter(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level.isClientSide()) {
            if (this.level.getGameTime() % 10 == 0) {
                List<Entity> entities = level.getEntitiesOfClass(Entity.class, new AABB(blockPosition()).inflate(4));
                boolean nearMob = false;
                for (Entity entity : entities) {
                    if (!(entity instanceof Weighter) && entity instanceof LivingEntity) {
                        nearMob = true;
                        spawnParticles();
                    }
                }
                openAnimationState.animateWhen(nearMob, this.tickCount);
                closeAnimationState.animateWhen(!nearMob, this.tickCount);
            }
            idleAnimationState.animateWhen(true, this.tickCount);
        } else {

            if (!level.getBlockState(this.blockPosition().below()).isFaceSturdy(level, this.blockPosition(), Direction.UP)) {
                this.kill();
            }
        }
        this.setPos(this.blockPosition().getX() + 0.5f, this.blockPosition().getY(), this.blockPosition().getZ() + 0.5f);

    }

    protected void spawnParticles() {
        for (int i = 0; i < 2; i++) {
            this.level.addParticle(ModParticleTypes.POLLEN.get(), this.getRandomX(0.5), this.getRandomY(), this.getRandomZ(0.5), 0.0, 1.0, 0.0);
        }
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    protected void doPush(Entity entity) {
    }

    @Override
    protected void pushEntities() {
    }

    @Override
    protected boolean isImmobile() {
        return true;
    }
}
