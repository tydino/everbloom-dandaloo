package com.tydino.everbloomdandaloo.client.entities.aether.au_revoir;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.client.entities.aether.EDAetherModelLoader;
import com.tydino.everbloomdandaloo.entities.aether.au_revoir.AuRevoirEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class AuRevoirEntityRenderer extends MobRenderer<AuRevoirEntity, AuRevoirRenderState, AuRevoirModel> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/aether/au_revoir.png");

    public AuRevoirEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new AuRevoirModel(context.bakeLayer(EDAetherModelLoader.AuRevoir)), 0.2f);
    }

    @Override
    public Identifier getTextureLocation(AuRevoirRenderState state) {
        return TEXTURE;
    }

    @Override
    public AuRevoirRenderState createRenderState() {
        return new AuRevoirRenderState();
    }

    @Override
    public void extractRenderState(AuRevoirEntity entity, AuRevoirRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.flappingAnimation.copyFrom(entity.flapAnimation);
        state.blinkAnimation.copyFrom(entity.blinkAnimation);
        state.latchAnimation.copyFrom(entity.latchAnimation);
    }
}
