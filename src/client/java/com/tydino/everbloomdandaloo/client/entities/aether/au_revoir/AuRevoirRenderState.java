package com.tydino.everbloomdandaloo.client.entities.aether.au_revoir;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class AuRevoirRenderState extends LivingEntityRenderState {
    public final AnimationState flappingAnimation = new AnimationState();
    public final AnimationState blinkAnimation = new AnimationState();
    public final AnimationState latchAnimation = new AnimationState();
}
