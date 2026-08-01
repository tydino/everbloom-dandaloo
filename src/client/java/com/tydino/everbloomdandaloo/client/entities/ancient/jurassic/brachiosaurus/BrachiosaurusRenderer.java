package com.tydino.everbloomdandaloo.client.entities.ancient.jurassic.brachiosaurus;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.client.entities.ancient.jurassic.EDJurassicModelLoader;
import com.tydino.everbloomdandaloo.entities.ancient.jurassic.BrachiosaurusEntity;
import com.tydino.everbloomdandaloo.entities.ancient.jurassic.BrachiosaurusVariant;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.ChickenRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

/// INCOMPLETE
public class BrachiosaurusRenderer extends MobRenderer<BrachiosaurusEntity, BrachiosaurusRenderState, BrachiosaurusFullGrownAdultModel> {
    static final Map<BrachiosaurusVariant, Identifier> Textures =
            Util.make(Maps.newEnumMap(BrachiosaurusVariant.class), map ->{
                map.put(BrachiosaurusVariant.movie_male,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/jurassic/brachiosaurus/fullgrownadult_brachiosaurus_male.png"));
                map.put(BrachiosaurusVariant.movie_female,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/jurassic/brachiosaurus/fullgrownadult_brachiosaurus_female.png"));
                map.put(BrachiosaurusVariant.banana_male,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/jurassic/brachiosaurus/fullgrownadult_brachiosaurus_male_banana.png"));
                map.put(BrachiosaurusVariant.banana_female,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/jurassic/brachiosaurus/fullgrownadult_brachiosaurus_female_banana.png"));
            });

    public BrachiosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, new BrachiosaurusFullGrownAdultModel(context.bakeLayer(EDJurassicModelLoader.Brachiosaurus)), 2.5f);
    }

    @Override
    public Identifier getTextureLocation(BrachiosaurusRenderState state) {
        return Textures.get(state.variant);
    }

    @Override
    public BrachiosaurusRenderState createRenderState() {
        return new BrachiosaurusRenderState();
    }

    @Override
    public void extractRenderState(BrachiosaurusEntity entity, BrachiosaurusRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.variant = entity.getVariant();
        state.idleAnimationState.copyFrom(entity.idleAnimation);
        state.blinkAnimationState.copyFrom(entity.blinkAnimation);
        state.eatAnimationState.copyFrom(entity.eatAnimation);
        state.leanDownAnimationState.copyFrom(entity.eatAnimation);
        state.Age = entity.getAge();
    }

    @Override
    public void submit(BrachiosaurusRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        if(state.Age <= 0){
            poseStack.scale(0.1f, 0.1f, 0.1f);
        }else if(state.Age == 1){
            poseStack.scale(0.2f, 0.2f, 0.2f);
        }else if(state.Age == 2){
            poseStack.scale(0.3f, 0.3f, 0.3f);
        }else if(state.Age == 3){
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }else if(state.Age == 4){
            poseStack.scale(0.5f, 0.5f, 0.5f);
        }else if(state.Age == 5){
            poseStack.scale(0.6f, 0.6f, 0.6f);
        }else if(state.Age == 6){
            poseStack.scale(0.7f, 0.7f, 0.7f);
        }else if(state.Age == 7){
            poseStack.scale(0.8f, 0.8f, 0.8f);
        }else if(state.Age == 8){
            poseStack.scale(0.9f, 0.9f, 0.9f);
        }else if(state.Age == 9){
            poseStack.scale(1f, 1f, 1f);
        }

        super.submit(state, poseStack, submitNodeCollector, camera);
    }
}
