package com.tydino.everbloomdandaloo.items.ancient;

import com.tydino.everbloomdandaloo.items.EDItemRegistry;
import net.minecraft.world.item.Item;

public class EDPermianItems {
    //fossils
    public static Item PermianAnimalFossil = EDItemRegistry.register("permian_animal_fossil", Item::new, new Item.Properties());

    public static void onInitialize(){}
}
