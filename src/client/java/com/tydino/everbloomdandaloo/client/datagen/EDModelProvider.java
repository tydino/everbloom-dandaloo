package com.tydino.everbloomdandaloo.client.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;

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
        //itemModelGenerators
    }
}
