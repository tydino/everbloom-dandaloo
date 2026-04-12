package com.tydino.everbloomdandaloo.items.aether;

import com.tydino.everbloomdandaloo.entities.aether.AetherEntityTypes;
import com.tydino.everbloomdandaloo.items.EDItemRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

public class EDAetherItemRegistry {
    public static final Item SpawnDaggerStabber = EDItemRegistry.register(
            "spawn_daggerstabber",
            SpawnEggItem::new,
            new Item.Properties().spawnEgg(AetherEntityTypes.DaggerStabber)
    );

    public static void onInitialize(){

    }
}
