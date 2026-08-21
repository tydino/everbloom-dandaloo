package com.tydino.everbloomdandaloo.client.datagen;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.blocks.ancient.EDAncientBlocks;
import com.tydino.everbloomdandaloo.blocks.ancient.EDJurassicBlocks;
import com.tydino.everbloomdandaloo.blocks.cooking.EDCookingBlocks;
import com.tydino.everbloomdandaloo.entities.aether.AetherEntityTypes;
import com.tydino.everbloomdandaloo.entities.ancient.jurassic.JurassicEntityTypes;
import com.tydino.everbloomdandaloo.items.aether.EDAetherItemRegistry;
import com.tydino.everbloomdandaloo.items.ancient.*;
import com.tydino.everbloomdandaloo.items.cooking.EDCookingItemRegistry;
import com.tydino.everbloomdandaloo.stats.ancient.EDAncientStats;
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
        translationBuilder.add("tooltip.everbloomdandaloo.depricated", "This has been depricated as a feature. This and its accompanying items are not used.");

        EverbloomDandaloo.LOGGER.info("Making The Names for Everbloom Dandaloo");
        translationBuilder.add("creativeTab.ancient", "Ancient :: Everbloom Dandaloo");                                 /// ANCIENTS ///

        translationBuilder.add("container.feeder", "Feeder");
        translationBuilder.add("stat."+EDAncientStats.InteractionsWithFeeder, "Interactions With Feeder");
        translationBuilder.add(EDAncientBlocks.Feeder, "Feeder");

        translationBuilder.add(EDAncientBlocks.AmberOre, "Amber Ore");
        translationBuilder.add(EDAncientBlocks.DeepslateAmberOre, "Deepslate Amber Ore");

        translationBuilder.add(EDAncientItems.AmberBugs, "Amber with Bugs");
        translationBuilder.add(EDAncientItems.AmberMediumBug, "Amber with a Bug");
        translationBuilder.add(EDAncientItems.AmberPlant, "Amber with a Broken Plant");
        translationBuilder.add(EDAncientItems.AmberWing, "Amber with a Wing");

        translationBuilder.add("creativeTab.paleozoic", "Paleozoic :: Everbloom Dandaloo"); /// PALEOZOIC ///
        translationBuilder.add(EDPaleozoicItems.BigBugAmber, "Amber with a Rather large Bug");

        translationBuilder.add("creativeTab.triassic", "Triassic :: Everbloom Dandaloo"); /// TRIASSIC ///
        translationBuilder.add(EDTriassicItems.TriassicAnimalFossil, "Triassic Animal Fossil");
        translationBuilder.add(EDTriassicItems.AnimalFossilFragments, "Triassic Animal Fossil Fragments");

        translationBuilder.add("creativeTab.jurassic", "Jurassic :: Everbloom Dandaloo"); /// JURASSIC ///
        translationBuilder.add(EDJurassicItems.BrachiosaurusFossil, "Brachiosaurus Fossil");
        translationBuilder.add(EDJurassicItems.BrachiosaurusFragments, "Brachiosaurus Fossil Fragments");

        translationBuilder.add(JurassicEntityTypes.Brachiosaurus, "Brachiosaurus");
        translationBuilder.add(EDJurassicBlocks.BrachiosaurusEgg, "Brachiosaurus Egg");
        translationBuilder.add(EDJurassicItems.HatchedBrachiosaurus, "Hatched Brachiosaurus");
        translationBuilder.add(EDJurassicBlocks.BrachiosaurusFossilOre, "Brachiosaurus Fossil Ore");
        translationBuilder.add(EDJurassicItems.BrachiosaurusLimb, "Brachiosaurus Limb");
        translationBuilder.add(EDJurassicItems.BrachiosaurusRibcage, "Brachiosaurus Ribcage");
        translationBuilder.add(EDJurassicItems.BrachiosaurusSkull, "Brachiosaurus Skull");

        translationBuilder.add("creativeTab.cretaceous", "Cretaceous :: Everbloom Dandaloo"); /// cretaceous ///
        translationBuilder.add(EDCretaceousItems.CretaceousAnimalFossil, "Cretaceous Animal Fossil");
        translationBuilder.add(EDCretaceousItems.AnimalFossilFragments, "Cretaceous Animal Fossil Fragments");

        translationBuilder.add("creativeTab.edcrafting", "Crafting :: Everbloom Dandaloo");                             /// CRAFTING ///

        translationBuilder.add(EDAncientBlocks.FossilRecombiner, "Fossil Recombiner");
        translationBuilder.add("stat."+EDAncientStats.InteractionsWithFossilRecombiner, "Interactions With Fossil Recombiner");
        translationBuilder.add("tooltip.everbloomdandaloo.fossil_recombiner", "You use this when you have fossil fragments to reform a fossil.");

        translationBuilder.add(EDAncientBlocks.FossilAdapter, "Fossil Adapter");
        translationBuilder.add("stat."+EDAncientStats.InteractionsWithFossilAdapter, "Interactions With Fossil Adapter");
        translationBuilder.add("tooltip.everbloomdandaloo.fossil_adapter", "With a full fossil, and a bone, you can reform the bone to a fossil.");

        translationBuilder.add(EDAncientBlocks.BoneAnalyzer, "Bone Analyzer");
        translationBuilder.add("stat."+EDAncientStats.InteractionsWithBoneAnalyzer, "Interactions With Bone Analyzer");
        translationBuilder.add("tooltip.everbloomdandaloo.bone_analyzer", "You use this with either a complete skeleton or a refined bone to get a DNA vial.");

        translationBuilder.add(EDAncientBlocks.DNAReformer, "DNA Reformer");
        translationBuilder.add("stat."+EDAncientStats.InteractionsWithDNAReformer, "Interactions With DNA Reformer");
        translationBuilder.add("tooltip.everbloomdandaloo.dna_reformer", "You use this with DNA vial(s) to form an embryo.");


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
