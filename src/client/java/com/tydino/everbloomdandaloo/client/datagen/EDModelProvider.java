package com.tydino.everbloomdandaloo.client.datagen;

import com.tydino.everbloomdandaloo.blocks.ancient.energy.EDAncientEnergyBlocks;
import com.tydino.everbloomdandaloo.items.ancient.EDCretaceousItems;
import com.tydino.everbloomdandaloo.items.ancient.EDJurassicItems;
import com.tydino.everbloomdandaloo.items.ancient.EDPaleozoicItems;
import com.tydino.everbloomdandaloo.items.ancient.EDTriassicItems;
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
        //permian
        itemModelGenerators.generateFlatItem(EDPaleozoicItems.PermianAnimalFossil, ModelTemplates.FLAT_ITEM);

        //triassic
        itemModelGenerators.generateFlatItem(EDTriassicItems.TriassicAnimalFossil, ModelTemplates.FLAT_ITEM);

        //jurassic
        itemModelGenerators.generateFlatItem(EDJurassicItems.JurassicAnimalFossil, ModelTemplates.FLAT_ITEM);

        //cretaceous
        itemModelGenerators.generateFlatItem(EDCretaceousItems.CretaceousAnimalFossil, ModelTemplates.FLAT_ITEM);
    }
}
