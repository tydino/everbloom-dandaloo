package com.tydino.everbloomdandaloo.client.entities.ancient.jurassic;

import com.tydino.everbloomdandaloo.client.entities.EDModelLoader;
import com.tydino.everbloomdandaloo.client.entities.ancient.jurassic.brachiosaurus.BrachiosaurusFullGrownAdultModel;
import com.tydino.everbloomdandaloo.client.entities.ancient.jurassic.brachiosaurus.BrachiosaurusRenderer;
import com.tydino.everbloomdandaloo.entities.ancient.jurassic.JurassicEntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class EDJurassicModelLoader {

    public static final ModelLayerLocation Brachiosaurus = EDModelLoader.createMain("brachiosaurus");

    public static void onInitialize() {
        //brachiosaurus
        ModelLayerRegistry.registerModelLayer(Brachiosaurus, BrachiosaurusFullGrownAdultModel::createBodyLayer);
        EntityRenderers.register(JurassicEntityTypes.Brachiosaurus, BrachiosaurusRenderer::new);
    }
}
