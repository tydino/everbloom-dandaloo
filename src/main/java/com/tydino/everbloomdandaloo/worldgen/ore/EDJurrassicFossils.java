package com.tydino.everbloomdandaloo.worldgen.ore;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class EDJurrassicFossils {
    public static final ResourceKey<PlacedFeature> BrachiosaurusPlaced = EDAncientOres.placedFeatureKey("brachiosaurus_fossil");

    public static void onInitialize(){
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                BrachiosaurusPlaced
        );
    }
}
