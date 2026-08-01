package com.tydino.everbloomdandaloo.client.entities.ancient.jurassic.brachiosaurus;

import com.tydino.everbloomdandaloo.client.entities.ancient.DinosaurRenderState;
import com.tydino.everbloomdandaloo.entities.ancient.jurassic.BrachiosaurusVariant;
import net.minecraft.world.entity.AnimationState;

public class BrachiosaurusRenderState extends DinosaurRenderState {
    public final AnimationState leanDownAnimationState = new AnimationState();

    public BrachiosaurusVariant variant;
}
