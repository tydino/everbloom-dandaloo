package com.tydino.everbloomdandaloo.client.entities.aether;

import com.tydino.everbloomdandaloo.client.entities.EDModelLoader;
import com.tydino.everbloomdandaloo.client.entities.aether.au_revoir.AuRevoirEntityRenderer;
import com.tydino.everbloomdandaloo.client.entities.aether.au_revoir.AuRevoirModel;
import com.tydino.everbloomdandaloo.client.entities.aether.dagger_stabber.DaggerStabberEntityRenderer;
import com.tydino.everbloomdandaloo.client.entities.aether.dagger_stabber.daggerStabberModel;
import com.tydino.everbloomdandaloo.client.entities.aether.manticore.ManticoreEntityRenderer;
import com.tydino.everbloomdandaloo.client.entities.aether.manticore.ManticoreModel;
import com.tydino.everbloomdandaloo.entities.aether.AetherEntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class EDAetherModelLoader {
    public static final ModelLayerLocation DaggerStabber = EDModelLoader.createMain("dagger_stabber");
    public static final ModelLayerLocation AuRevoir = EDModelLoader.createMain("au_revoir");
    public static final ModelLayerLocation MANTICORE = EDModelLoader.createMain("manticore");

    public static void onInitialize(){
        //dagger stabber
        ModelLayerRegistry.registerModelLayer(DaggerStabber, daggerStabberModel::createBodyLayer);
        EntityRenderers.register(AetherEntityTypes.DaggerStabber, DaggerStabberEntityRenderer::new);
        //au revoir
        ModelLayerRegistry.registerModelLayer(AuRevoir, AuRevoirModel::createBodyLayer);
        EntityRenderers.register(AetherEntityTypes.AuRevoir, AuRevoirEntityRenderer::new);
        //manticore
        ModelLayerRegistry.registerModelLayer(MANTICORE, ManticoreModel::createBodyLayer);
        EntityRenderers.register(AetherEntityTypes.MANTICORE, ManticoreEntityRenderer::new);
    }
}
