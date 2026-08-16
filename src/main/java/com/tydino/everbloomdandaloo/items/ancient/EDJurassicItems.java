package com.tydino.everbloomdandaloo.items.ancient;

import com.tydino.everbloomdandaloo.entities.ancient.jurassic.JurassicEntityTypes;
import com.tydino.everbloomdandaloo.items.EDItemRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

public class EDJurassicItems {
    //fossils
    public static Item JurassicAnimalFossil = EDItemRegistry.register("jurassic_animal_fossil", Item::new, new Item.Properties());

    public static Item BrachiosaurusFossil = EDItemRegistry.register("brachiosaurus_fossil", Item::new, new Item.Properties());

    //fragments

    public static Item AnimalFossilFragments = EDItemRegistry.register("jurassic_animal_fossilfragments", Item::new, new Item.Properties());

    public static Item BrachiosaurusFragments = EDItemRegistry.register("brachiosaurus_fragments", Item::new, new Item.Properties());

    //scarabs

    public static Item BigScarab = EDItemRegistry.register("big_silver_scarab", Item::new, new Item.Properties());

    /// DINOSAURS ///

    //brachiosaurus
    public static Item HatchedBrachiosaurus = EDItemRegistry.register("hatched_brachiosaurus", SpawnEggItem::new,
            new Item.Properties().spawnEgg(JurassicEntityTypes.Brachiosaurus));

    public static Item BrachiosaurusLimb = EDItemRegistry.register("limb_brachiosaurus", Item::new, new Item.Properties());
    public static Item BrachiosaurusRibcage = EDItemRegistry.register("ribcage_brachiosaurus", Item::new, new Item.Properties());
    public static Item BrachiosaurusSkull = EDItemRegistry.register("skull_brachiosaurus", Item::new, new Item.Properties());

    public static void onInitialize(){}
}
