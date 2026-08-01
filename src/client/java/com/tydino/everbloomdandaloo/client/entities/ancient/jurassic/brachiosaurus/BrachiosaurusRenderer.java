package com.tydino.everbloomdandaloo.client.entities.ancient.jurassic.brachiosaurus;

import com.google.common.collect.Maps;
import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.client.entities.ancient.jurassic.EDJurassicModelLoader;
import com.tydino.everbloomdandaloo.entities.ancient.jurassic.BrachiosaurusEntity;
import com.tydino.everbloomdandaloo.entities.ancient.jurassic.BrachiosaurusVariant;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
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
    }
}
