package com.tydino.everbloomdandaloo.client.entities.aether.dagger_stabber;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class DaggerStabberRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimation = new AnimationState();
    public final AnimationState blinkAnimation = new AnimationState();
    public final AnimationState noStabAniamtion = new AnimationState();
    public final AnimationState StabAnimation = new AnimationState();
}
