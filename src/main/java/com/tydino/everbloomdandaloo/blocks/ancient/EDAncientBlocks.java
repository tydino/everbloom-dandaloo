package com.tydino.everbloomdandaloo.blocks.ancient;

import com.tydino.everbloomdandaloo.blocks.EDBlockRegistry;
import com.tydino.everbloomdandaloo.blocks.ancient.energy.FossilAdapterBlock;
import com.tydino.everbloomdandaloo.blocks.ancient.energy.FossilRecombinerBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;

public class EDAncientBlocks {

    public static final float DinosaurEggBreakTime = 60000f;//is over 16 hours, most eggs should have hatched by the time the break time is barely started

    public static final Block AmberOre = EDBlockRegistry.registerBlock("amberore",
            properties -> new Block(properties.strength(4f).requiresCorrectToolForDrops()));
    public static final Block DeepslateAmberOre = EDBlockRegistry.registerBlock("deepslate_amberore",
            properties -> new Block(properties.strength(6f).requiresCorrectToolForDrops()));

    public static final Block FossilOre = EDBlockRegistry.registerBlock("fossilore",
            properties -> new Block(properties.strength(6f).requiresCorrectToolForDrops()));
    public static final Block DeepslateFossilOre = EDBlockRegistry.registerBlock("deepslate_fossilore",
            properties -> new Block(properties.strength(10f).requiresCorrectToolForDrops()));

    // doesn't actually use power Machines//
    public static final Block FossilRecombiner = EDBlockRegistry.registerBlock("fossil_recombiner",
            properties -> new FossilRecombinerBlock(properties.strength(2f).noOcclusion()),
            Component.translatable("tooltip.everbloomdandaloo.fossil_recombiner"));

    // uses power Machines//
    public  static final Block FossilAdapter = EDBlockRegistry.registerBlock("fossil_adapter",
            properties -> new FossilAdapterBlock(properties.strength(8f)),
            Component.translatable("tooltip.everbloomdandaloo.fossil_adapter"));

    public static void onInitialize(){
        EDPaleozoicBlocks.onInitialize();
        EDTriassicBlocks.onInitialize();
        EDJurassicBlocks.onInitialize();
        EDCretaceousBlocks.onInitialize();
    }
}
