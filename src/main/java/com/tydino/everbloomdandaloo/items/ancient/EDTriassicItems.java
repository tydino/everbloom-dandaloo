package com.tydino.everbloomdandaloo.items.ancient;

import com.tydino.everbloomdandaloo.items.EDItemRegistry;
import net.minecraft.world.item.Item;

public class EDTriassicItems {

    //fossils
    public static Item TriassicAnimalFossil = EDItemRegistry.register("triassic_animal_fossil", Item::new, new Item.Properties());
    public static Item AnimalFossilFragments = EDItemRegistry.register("triassic_animal_fossilfragments", Item::new, new Item.Properties());

    public static void onInitialize(){}
}
