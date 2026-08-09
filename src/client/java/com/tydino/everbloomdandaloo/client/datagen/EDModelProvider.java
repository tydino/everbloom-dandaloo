package com.tydino.everbloomdandaloo.client.datagen;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.blocks.ancient.EDAncientBlocks;
import com.tydino.everbloomdandaloo.blocks.ancient.EDJurassicBlocks;
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
        EverbloomDandaloo.LOGGER.info("Making Block Models for Everbloom Dandaloo");
        /// ANCIENT ///
        blockModelGenerators.createTrivialCube(EDAncientBlocks.AmberOre);
        blockModelGenerators.createTrivialCube(EDAncientBlocks.DeepslateAmberOre);

        blockModelGenerators.createTrivialCube(EDAncientBlocks.FossilOre);
        blockModelGenerators.createTrivialCube(EDAncientBlocks.DeepslateFossilOre);

        blockModelGenerators.createNonTemplateHorizontalBlock(EDAncientBlocks.FossilRecombiner);
        blockModelGenerators.createNonTemplateHorizontalBlock(EDAncientBlocks.FossilAdapter);

        /// EGGS ///
        //jurassic
        blockModelGenerators.createNonTemplateModelBlock(EDJurassicBlocks.BrachiosaurusEgg);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        EverbloomDandaloo.LOGGER.info("Making Item Models for Everbloom Dandaloo");
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
