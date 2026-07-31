package com.tydino.everbloomdandaloo.blocks.ancient.energy;

import com.tydino.everbloomdandaloo.blocks.EDBlockRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;

public class EDAncientEnergyBlocks {

    // doesn't actually use power //
    public static final Block FossilRecombiner = EDBlockRegistry.registerBlock("fossil_recombiner",
            properties -> new FossilRecombinerBlock(properties.strength(2f)),
            Component.translatable("tooltip.everbloomdandaloo.fossil_recombiner"));

    // uses power //

    public static void onInitialize(){}
}
