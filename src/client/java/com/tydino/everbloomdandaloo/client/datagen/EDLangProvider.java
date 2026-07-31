package com.tydino.everbloomdandaloo.client.datagen;

import com.tydino.everbloomdandaloo.blocks.ancient.energy.EDAncientEnergyBlocks;
import com.tydino.everbloomdandaloo.blocks.cooking.EDCookingBlocks;
import com.tydino.everbloomdandaloo.entities.aether.AetherEntityTypes;
import com.tydino.everbloomdandaloo.items.aether.EDAetherItemRegistry;
import com.tydino.everbloomdandaloo.items.ancient.EDCretaceousItems;
import com.tydino.everbloomdandaloo.items.ancient.EDJurassicItems;
import com.tydino.everbloomdandaloo.items.ancient.EDPaleozoicItems;
import com.tydino.everbloomdandaloo.items.ancient.EDTriassicItems;
import com.tydino.everbloomdandaloo.items.cooking.EDCookingItemRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class EDLangProvider extends FabricLanguageProvider {
    public EDLangProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
        translationBuilder.add("creativeTab.ancient", "Ancient :: Everbloom Dandaloo");                                 /// ANCIENTS ///

        translationBuilder.add("creativeTab.paleozoic", "Paleozoic :: Everbloom Dandaloo"); /// PALEOZOIC ///
        translationBuilder.add(EDPaleozoicItems.PermianAnimalFossil, "Permian Animal Fossil");

        translationBuilder.add("creativeTab.triassic", "Triassic :: Everbloom Dandaloo"); /// TRIASSIC ///
        translationBuilder.add(EDTriassicItems.TriassicAnimalFossil, "Triassic Animal Fossil");

        translationBuilder.add("creativeTab.jurassic", "Jurassic :: Everbloom Dandaloo"); /// JURASSIC ///
        translationBuilder.add(EDJurassicItems.JurassicAnimalFossil, "Jurassic Animal Fossil");

        translationBuilder.add("creativeTab.cretaceous", "Cretaceous :: Everbloom Dandaloo"); /// cretaceous ///
        translationBuilder.add(EDCretaceousItems.CretaceousAnimalFossil, "Cretaceous Animal Fossil");


        translationBuilder.add("creativeTab.edcrafting", "Crafting :: Everbloom Dandaloo");                           /// CRAFTING ///
        translationBuilder.add(EDAncientEnergyBlocks.FossilRecombiner, "Fossil Recombiner");


        translationBuilder.add("creativeTab.aether", "Depricated Things :: Everbloom Dandaloo");                        /// DEPRICATED ///
        translationBuilder.add(EDCookingItemRegistry.Tomato, "Tomato");
        translationBuilder.add(EDCookingBlocks.TomatoBush, "Tomato Bush");

        translationBuilder.add(AetherEntityTypes.DaggerStabber, "Dagger Stabber");
        translationBuilder.add(EDAetherItemRegistry.SpawnDaggerStabber, "Spawn Dagger Stabber");
        translationBuilder.add(EDAetherItemRegistry.DaggerStabberMeat, "Dagger Stabber Meat");
        translationBuilder.add(EDAetherItemRegistry.DaggerStabberDagger, "Dagger Stabber Dagger");

        translationBuilder.add(AetherEntityTypes.AuRevoir, "Au Revoir");
        translationBuilder.add(EDAetherItemRegistry.SpawnAuRevoir, "Spawn Au Revoir");
        translationBuilder.add(EDAetherItemRegistry.AuRevoirTail, "Au Revoir tail");
    }
}
