package com.tydino.everbloomdandaloo.entities;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.entities.aether.AetherEntityTypes;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.biome.Biome;

public class EDEntitySpawn {
    /// AETHER BIOMES ///
    public static final ResourceKey<Biome>  Aether_Plains = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "aether_plains"));
    public static final ResourceKey<Biome>  Aether_JUNGLE = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "aether_jungle"));

    public static void onInitialize(){
        /// AETHER ENTITIES///
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(Aether_Plains),
                MobCategory.CREATURE,
                AetherEntityTypes.DaggerStabber,
                2,
                1,
                4
                );
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(Aether_JUNGLE),
                MobCategory.CREATURE,
                AetherEntityTypes.DaggerStabber,
                2,
                1,
                4
        );
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(Aether_JUNGLE),
                MobCategory.CREATURE,
                AetherEntityTypes.AuRevoir,
                1,
                1,
                1
        );
    }
}
