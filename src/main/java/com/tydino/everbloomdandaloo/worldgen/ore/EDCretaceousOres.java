package com.tydino.everbloomdandaloo.worldgen.ore;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class EDCretaceousOres {
    public static final ResourceKey<PlacedFeature> HypsilophodonPlaced = EDAncientOres.placedFeatureKey("hypsilophodon_fossil");

    public static void onInitialize(){
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                HypsilophodonPlaced
        );
    }
}
