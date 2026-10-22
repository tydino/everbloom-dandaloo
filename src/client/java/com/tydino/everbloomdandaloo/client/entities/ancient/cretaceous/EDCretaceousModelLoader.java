package com.tydino.everbloomdandaloo.client.entities.ancient.cretaceous;

import com.tydino.everbloomdandaloo.client.entities.EDModelLoader;
import com.tydino.everbloomdandaloo.client.entities.ancient.cretaceous.hypsilophodon.HypsilophodonAdultModel;
import com.tydino.everbloomdandaloo.client.entities.ancient.cretaceous.hypsilophodon.HypsilophodonBabyModel;
import com.tydino.everbloomdandaloo.client.entities.ancient.cretaceous.hypsilophodon.HypsilophodonHatchlingModel;
import com.tydino.everbloomdandaloo.client.entities.ancient.cretaceous.hypsilophodon.HypsilophodonRenderer;
import com.tydino.everbloomdandaloo.entities.ancient.cretaceous.animalia.CretaceousEntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class EDCretaceousModelLoader {

    public static final ModelLayerLocation HypsilophodonAdult = EDModelLoader.createMain("hypsilophodon_adult");
    public static final ModelLayerLocation HypsilophodonBaby = EDModelLoader.createMain("hypsilophodon_baby");
    public static final ModelLayerLocation HypsilophodonHatchling = EDModelLoader.createMain("hypsilophodon_hatchling");

    public static void onInitialize(){
        //hypsilophodon
        ModelLayerRegistry.registerModelLayer(HypsilophodonAdult, HypsilophodonAdultModel::createBodyLayer);
        ModelLayerRegistry.registerModelLayer(HypsilophodonBaby, HypsilophodonBabyModel::createBodyLayer);
        ModelLayerRegistry.registerModelLayer(HypsilophodonHatchling, HypsilophodonHatchlingModel::createBodyLayer);
        EntityRenderers.register(CretaceousEntityTypes.Hypsilophodon, HypsilophodonRenderer::new);
    }
}
