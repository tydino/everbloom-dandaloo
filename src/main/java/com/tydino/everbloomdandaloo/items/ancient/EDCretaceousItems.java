package com.tydino.everbloomdandaloo.items.ancient;

import com.tydino.everbloomdandaloo.items.EDItemRegistry;
import net.minecraft.world.item.Item;

public class EDCretaceousItems {
    //fossils
    public static Item CretaceousAnimalFossil = EDItemRegistry.register("cretaceous_animal_fossil", Item::new, new Item.Properties());
    public static Item AnimalFossilFragments = EDItemRegistry.register("cretaceous_animal_fossilfragments", Item::new, new Item.Properties());

    public static void onInitialize(){}
}
