package com.tydino.everbloomdandaloo.client.entities.ancient.jurassic.brachiosaurus;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.client.entities.ancient.jurassic.EDJurassicModelLoader;
import com.tydino.everbloomdandaloo.entities.ancient.jurassic.BrachiosaurusEntity;
import com.tydino.everbloomdandaloo.entities.ancient.jurassic.BrachiosaurusVariant;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

/// INCOMPLETE
public class BrachiosaurusRenderer extends MobRenderer<BrachiosaurusEntity, BrachiosaurusRenderState, EntityModel<BrachiosaurusRenderState>> {

    static final Map<BrachiosaurusVariant, Identifier> TexturesForHatchling =
            Util.make(Maps.newEnumMap(BrachiosaurusVariant.class), map ->{
                map.put(BrachiosaurusVariant.movie_male,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/jurassic/brachiosaurus/hatchling_brachiosaurus_male.png"));
                map.put(BrachiosaurusVariant.movie_female,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/jurassic/brachiosaurus/hatchling_brachiosaurus_female.png"));
                map.put(BrachiosaurusVariant.banana_male,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/jurassic/brachiosaurus/hatchling_brachiosaurus_male_banana.png"));
                map.put(BrachiosaurusVariant.banana_female,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/jurassic/brachiosaurus/hatchling_brachiosaurus_female_banana.png"));
            });

    static final Map<BrachiosaurusVariant, Identifier> TexturesForBaby =
            Util.make(Maps.newEnumMap(BrachiosaurusVariant.class), map ->{
                map.put(BrachiosaurusVariant.movie_male,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/jurassic/brachiosaurus/baby_brachiosaurus_male.png"));
                map.put(BrachiosaurusVariant.movie_female,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/jurassic/brachiosaurus/baby_brachiosaurus_female.png"));
                map.put(BrachiosaurusVariant.banana_male,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/jurassic/brachiosaurus/baby_brachiosaurus_male_banana.png"));
                map.put(BrachiosaurusVariant.banana_female,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/jurassic/brachiosaurus/baby_brachiosaurus_female_banana.png"));
            });

    static final Map<BrachiosaurusVariant, Identifier> TexturesForJuvenile =
            Util.make(Maps.newEnumMap(BrachiosaurusVariant.class), map->{
                map.put(BrachiosaurusVariant.movie_male,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/jurassic/brachiosaurus/juvenile_brachiosaurus_male.png"));
                map.put(BrachiosaurusVariant.movie_female,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/jurassic/brachiosaurus/juvenile_brachiosaurus_female.png"));
                map.put(BrachiosaurusVariant.banana_male,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/jurassic/brachiosaurus/juvenile_brachiosaurus_male_banana.png"));
                map.put(BrachiosaurusVariant.banana_female,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/jurassic/brachiosaurus/juvenile_brachiosaurus_female_banana.png"));
            });

    static final Map<BrachiosaurusVariant, Identifier> TexturesForFullGrown =
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

    final BrachiosaurusFullGrownAdultModel FullGrownModel;
    final BrachiosaurusJuvenileModel JuvenileModel;
    final BrachiosaurusHatchlingModel HatchlingModel;
    final BrachiosaurusBabyModel BabyModel;

    public BrachiosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, new BrachiosaurusFullGrownAdultModel(context.bakeLayer(EDJurassicModelLoader.BrachiosaurusFullyGrown)), 1f);
        this.FullGrownModel = new BrachiosaurusFullGrownAdultModel(context.bakeLayer(EDJurassicModelLoader.BrachiosaurusFullyGrown));
        this.JuvenileModel = new BrachiosaurusJuvenileModel(context.bakeLayer(EDJurassicModelLoader.BrachiosaurusJuvenile));
        this.HatchlingModel =  new BrachiosaurusHatchlingModel(context.bakeLayer(EDJurassicModelLoader.BrachiosaurusHatchling));
        this.BabyModel = new BrachiosaurusBabyModel(context.bakeLayer(EDJurassicModelLoader.BrachiosaurusBaby));
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

        state.sittingdownAnimationState.copyFrom(entity.sittingDownAnimation);
        state.sitAnimationState.copyFrom(entity.sittingAnimation);
        state.standingupAnimationState.copyFrom(entity.standingUpAnimation);

        state.Age = entity.getAge();
    }

    @Override
    public Identifier getTextureLocation(BrachiosaurusRenderState state) {
        if(state.Age <= 0) {
            return TexturesForHatchling.get(state.variant);
        }
        else if(state.Age >= 1 && state.Age <= 3){
            return TexturesForBaby.get(state.variant);
        }else if(state.Age >= 4 && state.Age <= 9){
            return TexturesForJuvenile.get(state.variant);
        }
        return TexturesForFullGrown.get(state.variant);
    }

    @Override
    public void submit(BrachiosaurusRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        if(state.Age <= 0){
            this.model = this.HatchlingModel;
            poseStack.scale(1f, 1f, 1f);
        }else if(state.Age == 1){
            this.model = this.BabyModel;
            poseStack.scale(1f, 1f, 1f);
        }else if(state.Age == 2){
            this.model = this.BabyModel;
            poseStack.scale(1.2f, 1.2f, 1.2f);
        }else if(state.Age == 3){
            this.model = this.BabyModel;
            poseStack.scale(1.5f, 1.5f, 1.5f);
        }else if(state.Age == 4){
            this.model = this.JuvenileModel;
            poseStack.scale(0.3f, 0.3f, 0.3f);
        }else if(state.Age == 5){
            this.model = this.JuvenileModel;
            poseStack.scale(0.5f, 0.5f, 0.5f);
        }else if(state.Age == 6){
            this.model = this.JuvenileModel;
            poseStack.scale(0.75f, 0.75f, 0.75f);
        }else if(state.Age == 7){
            this.model = this.JuvenileModel;
            poseStack.scale(1f, 1f, 1f);
        }else if(state.Age == 8){
            this.model = this.JuvenileModel;
            poseStack.scale(1.25f, 1.25f, 1.25f);
        }else if(state.Age == 9){
            this.model = this.JuvenileModel;
            poseStack.scale(1.5f, 1.5f, 1.5f);
        }else if(state.Age == 10){
            this.model = this.FullGrownModel;
            poseStack.scale(0.75f, 0.75f, 0.75f);
        }else if(state.Age == 11){
            this.model = this.FullGrownModel;
            poseStack.scale(0.8f, 0.8f, 0.8f);
        }else if(state.Age == 12){
            this.model = this.FullGrownModel;
            poseStack.scale(0.85f, 0.85f, 0.85f);
        }else if(state.Age == 13){
            this.model = this.FullGrownModel;
            poseStack.scale(0.9f, 0.9f, 0.9f);
        }else if(state.Age == 14){
            this.model = this.FullGrownModel;
            poseStack.scale(1f, 1f, 1f);
        }

        super.submit(state, poseStack, submitNodeCollector, camera);
    }
}
