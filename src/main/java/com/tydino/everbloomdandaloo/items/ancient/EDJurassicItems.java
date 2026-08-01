package com.tydino.everbloomdandaloo.items.ancient;

import com.tydino.everbloomdandaloo.items.EDItemRegistry;
import net.minecraft.world.item.Item;

public class EDJurassicItems {
    //fossils
    public static Item JurassicAnimalFossil = EDItemRegistry.register("jurassic_animal_fossil", Item::new, new Item.Properties());
    public static Item AnimalFossilFragments = EDItemRegistry.register("jurassic_animal_fossilfragments", Item::new, new Item.Properties());

    public static Item BigScarab = EDItemRegistry.register("big_silver_scarab", Item::new, new Item.Properties());

    public static void onInitialize(){}
}
