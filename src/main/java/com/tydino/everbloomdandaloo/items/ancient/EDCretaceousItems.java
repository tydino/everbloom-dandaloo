package com.tydino.everbloomdandaloo.items.ancient;

import com.tydino.everbloomdandaloo.entities.ancient.cretaceous.animalia.CretaceousEntityTypes;
import com.tydino.everbloomdandaloo.items.EDItemRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

public class EDCretaceousItems {
    //fossils
    public static Item CretaceousAnimalFossil = EDItemRegistry.register("cretaceous_animal_fossil", Item::new, new Item.Properties());

    //scarabs
    public static Item SmallScarab = EDItemRegistry.register("small_gold_scarab", Item::new, new Item.Properties());

    /// DINOSAURS ///
    //hypsilophodon
    public static Item HatchedHypsilophodon = EDItemRegistry.register("hatched_hypsilophodon",SpawnEggItem::new,
            new Item.Properties().spawnEgg(CretaceousEntityTypes.Hypsilophodon));

    public static void onInitialize(){}
}
