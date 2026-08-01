package com.tydino.everbloomdandaloo.client.entities.ancient;


import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class DinosaurRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState blinkAnimationState = new AnimationState();
    public final AnimationState eatAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
    public final AnimationState sitAnimationState = new AnimationState();
    public final AnimationState sittingdownAnimationState = new AnimationState();
    public final AnimationState standingupAnimationState = new AnimationState();

    public int Age;
}
