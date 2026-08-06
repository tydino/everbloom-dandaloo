package com.tydino.everbloomdandaloo.items.ancient;

import com.tydino.everbloomdandaloo.entities.aether.AetherEntityTypes;
import com.tydino.everbloomdandaloo.entities.ancient.jurassic.JurassicEntityTypes;
import com.tydino.everbloomdandaloo.items.EDItemRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

public class EDJurassicItems {
    //fossils
    public static Item JurassicAnimalFossil = EDItemRegistry.register("jurassic_animal_fossil", Item::new, new Item.Properties());
    public static Item AnimalFossilFragments = EDItemRegistry.register("jurassic_animal_fossilfragments", Item::new, new Item.Properties());

    public static Item BigScarab = EDItemRegistry.register("big_silver_scarab", Item::new, new Item.Properties());

    /// DINOSAURS ///

    //brachiosaurus
    public static Item HatchedBrachiosaurus = EDItemRegistry.register("hatched_brachiosaurus", SpawnEggItem::new,
            new Item.Properties().spawnEgg(JurassicEntityTypes.Brachiosaurus));

    public static void onInitialize(){}
}
