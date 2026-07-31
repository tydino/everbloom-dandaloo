package com.tydino.everbloomdandaloo.blocks.ancient;

import com.tydino.everbloomdandaloo.blocks.EDBlockRegistry;
import com.tydino.everbloomdandaloo.blocks.ancient.energy.FossilRecombinerBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;

public class EDAncientBlocks {

    public static final Block AmberOre = EDBlockRegistry.registerBlock("amberore",
            properties -> new Block(properties.strength(4f).requiresCorrectToolForDrops()));
    public static final Block DeepslateAmberOre = EDBlockRegistry.registerBlock("deepslate_amberore",
            properties -> new Block(properties.strength(6f).requiresCorrectToolForDrops()));

    // doesn't actually use power Machines//
    public static final Block FossilRecombiner = EDBlockRegistry.registerBlock("fossil_recombiner",
            properties -> new FossilRecombinerBlock(properties.strength(2f)),
            Component.translatable("tooltip.everbloomdandaloo.fossil_recombiner"));

    // uses power Machines//

    public static void onInitialize(){
        EDPaleozoicBlocks.onInitialize();
        EDTriassicBlocks.onInitialize();
        EDJurassicBlocks.onInitialize();
        EDCretaceousBlocks.onInitialize();
    }
}
