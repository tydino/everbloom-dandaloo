package com.tydino.everbloomdandaloo.blocks.ancient;

import com.tydino.everbloomdandaloo.blocks.EDBlockRegistry;
import com.tydino.everbloomdandaloo.blocks.ancient.eggs.BrachiosaurusEgg;
import net.minecraft.world.level.block.Block;

public class EDJurassicBlocks {

    public static final Block BrachiosaurusFossilOre = EDBlockRegistry.registerBlock("brachiosaurus_fossilore",
            properties -> new Block(properties.strength(EDAncientBlocks.OreBreakTime).requiresCorrectToolForDrops()));

    public static final Block BrachiosaurusEgg = EDBlockRegistry.registerBlock("brachiosaurus_egg",
            properties -> new BrachiosaurusEgg(properties.strength(EDAncientBlocks.DinosaurEggBreakTime)));

    public static void onInitialize(){}
}
