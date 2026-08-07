package com.tydino.everbloomdandaloo.items.ancient;

import com.tydino.everbloomdandaloo.items.EDItemRegistry;
import net.minecraft.world.item.Item;

public class EDAncientItems {

    public static final Item AmberBugs = EDItemRegistry.register("amber_bugs", Item::new, new Item.Properties());
    public static final Item AmberMediumBug = EDItemRegistry.register("amber_mediumbug", Item::new, new Item.Properties());
    public static final Item AmberPlant = EDItemRegistry.register("amber_plant", Item::new, new Item.Properties());
    public static final Item AmberWing = EDItemRegistry.register("amber_wing", Item::new, new Item.Properties());

    public static final Item BreedingScarab = EDItemRegistry.register("breeding_scarab", Item::new, new Item.Properties());

    public static final Item GrowthSerum = EDItemRegistry.register("growth_serum", Item::new, new Item.Properties());

    public static void onInitialize(){}
}
