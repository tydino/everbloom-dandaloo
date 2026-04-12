package com.tydino.everbloomdandaloo.client.entities;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.client.entities.aether.EDAetherModelLoader;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

public class EDModelLoader {

    public static void onInitialize(){
        EDAetherModelLoader.onInitialize();
    }

    public static ModelLayerLocation createMain(String name) {
        return new ModelLayerLocation(Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, name), "main");
    }
}
