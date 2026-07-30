package com.tydino.everbloomdandaloo.client.datagen;

import com.tydino.everbloomdandaloo.items.ancient.EDPermianItems;
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
        //blockModelGenerators
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        /// ancient ///
        //permian
        itemModelGenerators.generateFlatItem(EDPermianItems.PermianAnimalFossil, ModelTemplates.FLAT_ITEM);

        //triassic
        itemModelGenerators.generateFlatItem(EDTriassicItems.TriassicAnimalFossil, ModelTemplates.FLAT_ITEM);
    }
}
