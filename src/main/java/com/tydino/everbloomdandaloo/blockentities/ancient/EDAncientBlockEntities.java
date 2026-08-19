package com.tydino.everbloomdandaloo.blockentities.ancient;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.blocks.ancient.EDAncientBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.core.Registry;

public class EDAncientBlockEntities {

    public static final BlockEntityType<FeederBlockEntity> Feeder =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "feeder_be"),
                    FabricBlockEntityTypeBuilder.create(FeederBlockEntity::new, EDAncientBlocks.Feeder).build());

    public static void OnInitialize(){

    }
}
