package com.tydino.everbloomdandaloo.client.datagen;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.blocks.ancient.EDAncientBlocks;
import com.tydino.everbloomdandaloo.blocks.ancient.EDJurassicBlocks;
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
        EverbloomDandaloo.LOGGER.info("Making Block Loot for Everbloom Dandaloo");
        /// ANCIENT ///

        //machines
        dropSelf(EDAncientBlocks.FossilRecombiner);

        /// EGGS ///
        //jurassic
        dropSelf(EDJurassicBlocks.BrachiosaurusEgg);
    }
}
