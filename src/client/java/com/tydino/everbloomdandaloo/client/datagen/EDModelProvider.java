package com.tydino.everbloomdandaloo.client.datagen;

import com.tydino.everbloomdandaloo.blocks.ancient.energy.EDAncientEnergyBlocks;
import com.tydino.everbloomdandaloo.items.ancient.*;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class EDModelProvider extends FabricModelProvider {
    public EDModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        /// ANCIENT ///
        blockModelGenerators.createNonTemplateModelBlock(EDAncientEnergyBlocks.FossilRecombiner);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        /// ANCIENT ///
        //ambers//
        itemModelGenerators.generateFlatItem(EDPaleozoicItems.BigBugAmber, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(EDAncientItems.AmberBugs, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(EDAncientItems.AmberMediumBug, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(EDAncientItems.AmberPlant, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(EDAncientItems.AmberWing, ModelTemplates.FLAT_ITEM);

        /// permian ///
        itemModelGenerators.generateFlatItem(EDPaleozoicItems.PermianAnimalFossil, ModelTemplates.FLAT_ITEM);

        /// triassic ///
        itemModelGenerators.generateFlatItem(EDTriassicItems.TriassicAnimalFossil, ModelTemplates.FLAT_ITEM);

        /// jurassic ///
        itemModelGenerators.generateFlatItem(EDJurassicItems.JurassicAnimalFossil, ModelTemplates.FLAT_ITEM);

        /// cretaceous ///
        itemModelGenerators.generateFlatItem(EDCretaceousItems.CretaceousAnimalFossil, ModelTemplates.FLAT_ITEM);
    }
}
