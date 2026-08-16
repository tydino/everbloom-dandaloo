package com.tydino.everbloomdandaloo.client.datagen;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.blocks.EDBlockRegistry;
import com.tydino.everbloomdandaloo.blocks.ancient.EDAncientBlocks;
import com.tydino.everbloomdandaloo.blocks.ancient.EDJurassicBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class EDBlockTagProvider extends FabricTagsProvider.BlockTagsProvider{
    public EDBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        EverbloomDandaloo.LOGGER.info("Making Block tags for Everbloom Dandaloo");
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(EDBlockRegistry.getRK(EDAncientBlocks.FossilOre))
                .add(EDBlockRegistry.getRK(EDAncientBlocks.DeepslateFossilOre))

                .add(EDBlockRegistry.getRK(EDJurassicBlocks.BrachiosaurusFossilOre))

                .add(EDBlockRegistry.getRK(EDAncientBlocks.AmberOre))
                .add(EDBlockRegistry.getRK(EDAncientBlocks.DeepslateAmberOre));

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(EDBlockRegistry.getRK(EDAncientBlocks.FossilOre))
                .add(EDBlockRegistry.getRK(EDAncientBlocks.DeepslateFossilOre))

                .add(EDBlockRegistry.getRK(EDJurassicBlocks.BrachiosaurusFossilOre))

                .add(EDBlockRegistry.getRK(EDAncientBlocks.AmberOre))
                .add(EDBlockRegistry.getRK(EDAncientBlocks.DeepslateAmberOre));
    }
}
