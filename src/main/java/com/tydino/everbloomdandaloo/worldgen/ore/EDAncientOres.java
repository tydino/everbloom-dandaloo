package com.tydino.everbloomdandaloo.worldgen.ore;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class EDAncientOres {
    public static ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, name));
    }

    public static ResourceKey<PlacedFeature> placedFeatureKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, name));
    }

    public static void onInitialize(){
        EDJurrassicFossils.onInitialize();
    }
}
