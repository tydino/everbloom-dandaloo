package com.tydino.everbloomdandaloo.client.entities.aether.dagger_stabber;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.geom.PartNames;

public class DaggerStabberAnimations {
    public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(1)
            .looping()
            .addAnimation("neck", new AnimationChannel(
                    AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0,0,0), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.17f, KeyframeAnimations.degreeVec(-3,0,0), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.38f, KeyframeAnimations.degreeVec(-5,0,0), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(-3,0,0), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.63f, KeyframeAnimations.degreeVec(0,0,0), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(2,0,0), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.88f, KeyframeAnimations.degreeVec(2.5f,0,0), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.92f, KeyframeAnimations.degreeVec(2.25f,0,0), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.96f, KeyframeAnimations.degreeVec(1.5f,0,0), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0,0,0), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("neck", new AnimationChannel(
                    AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0,0,0),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.13f, KeyframeAnimations.degreeVec(0,-0.75f,0),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(0,-1,0),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.38f, KeyframeAnimations.degreeVec(0,-0.75f,0),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0,0,0),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.63f, KeyframeAnimations.degreeVec(0,0.75f,0),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(0,1,0),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.88f, KeyframeAnimations.degreeVec(0,0.75f,0),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0,0,0),AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("head", new AnimationChannel(
                    AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0,0,0),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.13f, KeyframeAnimations.degreeVec(0,2.5f,0),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(0,7.5f,0),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0,6.5f,0),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.63f, KeyframeAnimations.degreeVec(0,2.5f,0),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(0,0,0),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0,0,0),AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("head", new AnimationChannel(
                    AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f,0f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(0,-0.75f,0),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0,-1f,0),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.63f, KeyframeAnimations.degreeVec(0,-0.75f,0),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(0,0.5f,0),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.88f, KeyframeAnimations.degreeVec(0,0.4f,0),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0,0,0),AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("rightear", new AnimationChannel(
                    AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f,0f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.04f, KeyframeAnimations.degreeVec(3f,0f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.08f, KeyframeAnimations.degreeVec(4.5f,0f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.13f, KeyframeAnimations.degreeVec(5f,0f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.38f, KeyframeAnimations.degreeVec(3f,0f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.68f, KeyframeAnimations.degreeVec(-10f,0f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.88f, KeyframeAnimations.degreeVec(-8f,0f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f,0f,0f),AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("rightear", new AnimationChannel(
                    AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f,0f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f,-0.75f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f,-1f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.88f, KeyframeAnimations.degreeVec(0f,-0.75f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f,0f,0f),AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("leftear", new AnimationChannel(
                    AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f,0f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.04f, KeyframeAnimations.degreeVec(3f,0f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.08f, KeyframeAnimations.degreeVec(4.5f,0f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.13f, KeyframeAnimations.degreeVec(5f,0f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.38f, KeyframeAnimations.degreeVec(3f,0f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.68f, KeyframeAnimations.degreeVec(-10f,0f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.88f, KeyframeAnimations.degreeVec(-8f,0f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f,0f,0f),AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("leftear", new AnimationChannel(
                    AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f,0f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f,-0.75f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f,-1f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.88f, KeyframeAnimations.degreeVec(0f,-0.75f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(0f,0f,0f),AnimationChannel.Interpolations.LINEAR)
            )).build();
    public static final AnimationDefinition BLINK = AnimationDefinition.Builder.withLength(0.75f)
            .addAnimation("eyelids", new AnimationChannel(
                    AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f,0f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f,-2f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f,-2f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f,0f,0f),AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("eyelids", new AnimationChannel(
                    AnimationChannel.Targets.SCALE,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f,0f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f,2f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f,2f,0f),AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f,0f,0f),AnimationChannel.Interpolations.LINEAR)
            )).build();
}
