package com.tydino.everbloomdandaloo.blocks.cooking;

import com.tydino.everbloomdandaloo.blocks.EDBlockRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class EDCookingBlocks {

    public static final Block TomatoBush = EDBlockRegistry.register(
        "tomato_bush",
            properties -> new TomatoBushBlock(properties.mapColor(MapColor.TERRACOTTA_GREEN)
                    .noCollision().sound(SoundType.SWEET_BERRY_BUSH)),
            BlockBehaviour.Properties.of().sound(SoundType.GRASS),
            true
    );

    public static void onInitialize(){

    }
}
