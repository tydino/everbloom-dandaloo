package com.tydino.everbloomdandaloo.client.entities.ancient.cretaceous.hypsilophodon;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.client.entities.ancient.cretaceous.EDCretaceousModelLoader;
import com.tydino.everbloomdandaloo.entities.ancient.cretaceous.animalia.hypsilophodon.HypsilophodonEntity;
import com.tydino.everbloomdandaloo.entities.ancient.cretaceous.animalia.hypsilophodon.HypsilophodonVariant;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

/// INCOMPLETE
public class HypsilophodonRenderer extends MobRenderer<HypsilophodonEntity, HypsilophodonRenderState, EntityModel<HypsilophodonRenderState>> {

    static final Map<HypsilophodonVariant, Identifier> TexturesForHatchling =
            Util.make(Maps.newEnumMap(HypsilophodonVariant.class), map ->{
                map.put(HypsilophodonVariant.mud_male,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/cretaceous/hypsilophodon/hypsilophodon_hatchling_male_mud.png"));
                map.put(HypsilophodonVariant.mud_female,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/cretaceous/hypsilophodon/hypsilophodon_hatchling_female_mud.png"));
                map.put(HypsilophodonVariant.groomed_male,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/cretaceous/hypsilophodon/hypsilophodon_hatchling_male_groomed.png"));
                map.put(HypsilophodonVariant.groomed_female,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/cretaceous/hypsilophodon/hypsilophodon_hatchling_female_groomed.png"));
                map.put(HypsilophodonVariant.nerd_male,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/cretaceous/hypsilophodon/hypsilophodon_hatchling_male_nerd.png"));
                map.put(HypsilophodonVariant.nerd_female,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/cretaceous/hypsilophodon/hypsilophodon_hatchling_female_nerd.png"));
            });

    static final Map<HypsilophodonVariant, Identifier> TexturesForBaby =
            Util.make(Maps.newEnumMap(HypsilophodonVariant.class), map ->{
                map.put(HypsilophodonVariant.mud_male,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/cretaceous/hypsilophodon/hypsilophodon_baby_male_mud.png"));
                map.put(HypsilophodonVariant.mud_female,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/cretaceous/hypsilophodon/hypsilophodon_baby_female_mud.png"));
                map.put(HypsilophodonVariant.groomed_male,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/cretaceous/hypsilophodon/hypsilophodon_baby_male_groomed.png"));
                map.put(HypsilophodonVariant.groomed_female,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/cretaceous/hypsilophodon/hypsilophodon_baby_female_groomed.png"));
                map.put(HypsilophodonVariant.nerd_male,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/cretaceous/hypsilophodon/hypsilophodon_baby_male_nerd.png"));
                map.put(HypsilophodonVariant.nerd_female,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/cretaceous/hypsilophodon/hypsilophodon_baby_female_nerd.png"));
            });

    static final Map<HypsilophodonVariant, Identifier> TexturesForAdult =
            Util.make(Maps.newEnumMap(HypsilophodonVariant.class), map ->{
                map.put(HypsilophodonVariant.mud_male,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/cretaceous/hypsilophodon/hypsilophodon_adult_male_mud.png"));
                map.put(HypsilophodonVariant.mud_female,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/cretaceous/hypsilophodon/hypsilophodon_adult_female_mud.png"));
                map.put(HypsilophodonVariant.groomed_male,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/cretaceous/hypsilophodon/hypsilophodon_adult_male_groomed.png"));
                map.put(HypsilophodonVariant.groomed_female,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/cretaceous/hypsilophodon/hypsilophodon_adult_female_groomed.png"));
                map.put(HypsilophodonVariant.nerd_male,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/cretaceous/hypsilophodon/hypsilophodon_adult_male_nerd.png"));
                map.put(HypsilophodonVariant.nerd_female,
                        Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "textures/entity/ancient/cretaceous/hypsilophodon/hypsilophodon_adult_female_nerd.png"));
            });

    final HypsilophodonHatchlingModel hatchlingModel;
    final HypsilophodonBabyModel babyModel;
    final HypsilophodonAdultModel adultModel;

    public HypsilophodonRenderer(EntityRendererProvider.Context context){
        super(context, new HypsilophodonAdultModel(context.bakeLayer(EDCretaceousModelLoader.HypsilophodonAdult)), 0.5f);
        this.hatchlingModel = new HypsilophodonHatchlingModel(context.bakeLayer(EDCretaceousModelLoader.HypsilophodonHatchling));
        this.babyModel = new HypsilophodonBabyModel(context.bakeLayer(EDCretaceousModelLoader.HypsilophodonBaby));
        this.adultModel = new HypsilophodonAdultModel(context.bakeLayer(EDCretaceousModelLoader.HypsilophodonAdult));
    }

    @Override
    public HypsilophodonRenderState createRenderState() {
        return new HypsilophodonRenderState();
    }

    @Override
    public void extractRenderState(HypsilophodonEntity entity, HypsilophodonRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.variant = entity.getVariant();
        state.idleAnimationState.copyFrom(entity.idleAnimation);
        state.blinkAnimationState.copyFrom(entity.blinkAnimation);
        state.eatAnimationState.copyFrom(entity.eatAnimation);
        //state.scritchAnimationState.copyFrom(entity.scritchAnimation);

        state.sittingdownAnimationState.copyFrom(entity.sittingDownAnimation);
        state.sitAnimationState.copyFrom(entity.sittingAnimation);
        state.standingupAnimationState.copyFrom(entity.standingUpAnimation);

        state.Age = entity.getAge();
    }

    @Override
    public Identifier getTextureLocation(HypsilophodonRenderState state) {
        if(state.Age <= 0) {
            return TexturesForHatchling.get(state.variant);
        }
        else if(state.Age ==1 || state.Age ==2){
            return TexturesForBaby.get(state.variant);
        }
        return TexturesForAdult.get(state.variant);
    }

    @Override
    public void submit(HypsilophodonRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        if(state.Age == 0){
            this.model = hatchlingModel;
            poseStack.scale(1f, 1f, 1f);
        }else if(state.Age == 1){
            this.model = babyModel;
            poseStack.scale(1f, 1f, 1f);
        }else if(state.Age == 2){
            this.model = babyModel;
            poseStack.scale(1.25f, 1.25f, 1.25f);
        }else if(state.Age == 3){
            this.model = adultModel;
            poseStack.scale(0.75f, 0.75f, 0.75f);
        }else if(state.Age == 4){
            this.model = adultModel;
            poseStack.scale(0.85f, 0.85f, 0.85f);
        }else if(state.Age == 5){
            this.model = adultModel;
            poseStack.scale(0.9f, 0.9f, 0.9f);
        }else if(state.Age == 6){
            this.model = adultModel;
            poseStack.scale(1f, 1f, 1f);
        }

        super.submit(state, poseStack, submitNodeCollector, camera);
    }
}
