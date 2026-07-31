package com.tydino.everbloomdandaloo.blocks.ancient.energy;

import com.tydino.everbloomdandaloo.blocks.EDBlockRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class EDAncientEnergyBlocks {

    // doesn't actually use power //
    public static final Block FossilRecombiner = EDBlockRegistry.registerBlock("fossil_recombiner", properties -> new FossilRecombinerBlock(properties.strength(2f)));

    // uses power //

    public static void onInitialize(){}
}
