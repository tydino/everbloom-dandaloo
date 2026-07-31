package com.tydino.everbloomdandaloo.client.datagen;

import com.tydino.everbloomdandaloo.blocks.ancient.energy.EDAncientEnergyBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class EDBlockLootTables extends FabricBlockLootSubProvider {
    public EDBlockLootTables(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        /// ANCIENT ///

        //machines
        dropSelf(EDAncientEnergyBlocks.FossilRecombiner);
    }
}
