package com.tydino.everbloomdandaloo.worldgen.ore;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class EDAncientOres {

    public static final ResourceKey<PlacedFeature> Amber = placedFeatureKey("amber");

    public static void onInitialize(){
        EDJurrassicFossils.onInitialize();

        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                Amber
        );
    }

    public static ResourceKey<PlacedFeature> placedFeatureKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, name));
    }
}
