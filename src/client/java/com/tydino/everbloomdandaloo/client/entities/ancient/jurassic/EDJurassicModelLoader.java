package com.tydino.everbloomdandaloo.client.entities.ancient.jurassic;

import com.tydino.everbloomdandaloo.client.entities.EDModelLoader;
import com.tydino.everbloomdandaloo.client.entities.ancient.jurassic.brachiosaurus.*;
import com.tydino.everbloomdandaloo.entities.ancient.jurassic.JurassicEntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class EDJurassicModelLoader {

    public static final ModelLayerLocation BrachiosaurusFullyGrown = EDModelLoader.createMain("brachiosaurus_fully_grown");
    public static final ModelLayerLocation BrachiosaurusJuvenile = EDModelLoader.createMain("brachiosaurus_juvenile");
    public static final ModelLayerLocation BrachiosaurusHatchling = EDModelLoader.createMain("brachiosaurus_hatchling");
    public static final ModelLayerLocation BrachiosaurusBaby = EDModelLoader.createMain("brachiosaurus_baby");

    public static void onInitialize() {
        //brachiosaurus
        ModelLayerRegistry.registerModelLayer(BrachiosaurusFullyGrown, BrachiosaurusFullGrownAdultModel::createBodyLayer);
        ModelLayerRegistry.registerModelLayer(BrachiosaurusJuvenile, BrachiosaurusJuvenileModel::createBodyLayer);
        ModelLayerRegistry.registerModelLayer(BrachiosaurusHatchling, BrachiosaurusHatchlingModel::createBodyLayer);
        ModelLayerRegistry.registerModelLayer(BrachiosaurusBaby, BrachiosaurusBabyModel::createBodyLayer);
        EntityRenderers.register(JurassicEntityTypes.Brachiosaurus, BrachiosaurusRenderer::new);
    }
}
