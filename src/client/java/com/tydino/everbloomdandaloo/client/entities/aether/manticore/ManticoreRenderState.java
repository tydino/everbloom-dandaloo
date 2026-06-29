package com.tydino.everbloomdandaloo.client.entities.aether.manticore;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class ManticoreRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimation = new AnimationState();
    public final AnimationState blinkAnimation = new AnimationState();
    public final AnimationState FlyingAniamtion = new AnimationState();
    public final AnimationState AttackAnimation = new AnimationState();
}
