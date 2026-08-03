package com.tydino.everbloomdandaloo.blocks.ancient;

import com.tydino.everbloomdandaloo.blocks.EDBlockRegistry;
import com.tydino.everbloomdandaloo.blocks.ancient.eggs.BrachiosaurusEgg;
import net.minecraft.world.level.block.Block;

public class EDJurassicBlocks {

    public static final Block BrachiosaurusEgg = EDBlockRegistry.registerBlock("brachiosaurus_egg",
            properties -> new BrachiosaurusEgg(properties.strength(10f)));

    public static void onInitialize(){}
}
