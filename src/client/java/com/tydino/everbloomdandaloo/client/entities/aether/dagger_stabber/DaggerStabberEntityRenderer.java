package com.tydino.everbloomdandaloo.client.entities.aether.dagger_stabber;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.client.entities.aether.EDAetherModelLoader;
import com.tydino.everbloomdandaloo.entities.aether.dagger_stabber.DaggerStabberEntity;
import net.fabricmc.fabric.api.util.EventResult;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class DaggerStabberEntityRenderer extends MobRenderer<DaggerStabberEntity, DaggerStabberRenderState, daggerStabberModel> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/dagger_stabber.png");

    public DaggerStabberEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new daggerStabberModel(context.bakeLayer(EDAetherModelLoader.DaggerStabber)), 0.4f); // 0.6 shadow radius
    }

    @Override
    public DaggerStabberRenderState createRenderState() {
        return new DaggerStabberRenderState();
    }

    @Override
    public void extractRenderState(DaggerStabberEntity entity, DaggerStabberRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.idleAnimation.copyFrom(entity.idleAnimation);
        state.blinkAnimation.copyFrom(entity.blinkAnimation);
        state.noStabAniamtion.copyFrom(entity.noStabAnimation);
        state.StabAnimation.copyFrom(entity.StabAnimation);
    }

    @Override
    public Identifier getTextureLocation(DaggerStabberRenderState state) {
        return TEXTURE;
    }
}
