package com.tydino.everbloomdandaloo.blocks.ancient;

import com.tydino.everbloomdandaloo.blocks.EDBlockRegistry;
import com.tydino.everbloomdandaloo.blocks.ancient.eggs.HypsilophodonEgg;
import net.minecraft.world.level.block.Block;

public class EDCretaceousBlocks {

    /// HYPSILOPHODON
    public static final Block HypsilophodonEgg = EDBlockRegistry.registerBlock("hypsilophodon_egg",
            properties -> new HypsilophodonEgg(properties.strength(EDAncientBlocks.DinosaurEggBreakTime)));

    public static void onInitialize(){}
}
