package com.tydino.everbloomdandaloo.client.entities.aether.manticore;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.client.entities.aether.EDAetherModelLoader;
import com.tydino.everbloomdandaloo.entities.aether.manticore.Manticore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class ManticoreEntityRenderer extends MobRenderer<Manticore, ManticoreRenderState, ManticoreModel> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/aether/manticore/male.png");

    public ManticoreEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new ManticoreModel(context.bakeLayer(EDAetherModelLoader.MANTICORE)), 0.5f);
    }

    @Override
    public Identifier getTextureLocation(ManticoreRenderState state) {
        return TEXTURE;
    }

    @Override
    public ManticoreRenderState createRenderState() {
        return new ManticoreRenderState();
    }

    @Override
    public void extractRenderState(Manticore entity, ManticoreRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.idleAnimation.copyFrom(entity.idleAnimation);
        state.blinkAnimation.copyFrom(entity.blinkAnimation);
        state.flyingAniamtion.copyFrom(entity.flyingAnimation);
        state.attackAnimation.copyFrom(entity.AttackAnimation);
    }
}
