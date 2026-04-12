package com.tydino.everbloomdandaloo.client.entities.aether;

import com.tydino.everbloomdandaloo.client.entities.EDModelLoader;
import com.tydino.everbloomdandaloo.client.entities.aether.dagger_stabber.DaggerStabberEntityRenderer;
import com.tydino.everbloomdandaloo.client.entities.aether.dagger_stabber.daggerStabberModel;
import com.tydino.everbloomdandaloo.entities.aether.AetherEntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class EDAetherModelLoader {
    public static final ModelLayerLocation DaggerStabber = EDModelLoader.createMain("dagger_stabber");

    public static void onInitialize(){
        ModelLayerRegistry.registerModelLayer(DaggerStabber, daggerStabberModel::createBodyLayer);
        EntityRenderers.register(AetherEntityTypes.DaggerStabber, DaggerStabberEntityRenderer::new);
    }
}
