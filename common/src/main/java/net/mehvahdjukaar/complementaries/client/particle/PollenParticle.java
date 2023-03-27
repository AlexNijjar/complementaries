package net.mehvahdjukaar.complementaries.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class PollenParticle extends TextureSheetParticle {
    PollenParticle(ClientLevel clientLevel, double d, double e, double f) {
        super(clientLevel, d, e, f, 0.0, 0.0, 0.0);
        this.gravity = 0.15F;
        this.friction = 0.999F;
        this.xd *= 0.6;
        this.yd *= 0.6;
        this.zd *= 0.6;
        this.yd = this.random.nextFloat() * 0.15F + 0.05F;
        this.quadSize *= this.random.nextFloat() + 0.2F;
        this.lifetime = (int) (32 / (Math.random() * 0.8 + 0.2));
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_LIT;
    }

    public int getLightColor(float partialTick) {
        int i = super.getLightColor(partialTick);
        int k = i >> 16 & 255;
        return 240 | k << 16;
    }

    public float getQuadSize(float scaleFactor) {
        float f = ((float) this.age + scaleFactor) / (float) this.lifetime;
        return this.quadSize * (1.0F - f * f);
    }

    @Environment(EnvType.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet spriteSet) {
            this.sprite = spriteSet;
        }

        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            PollenParticle particle = new PollenParticle(level, x, y, z);
            particle.pickSprite(this.sprite);
            return particle;
        }
    }
}

