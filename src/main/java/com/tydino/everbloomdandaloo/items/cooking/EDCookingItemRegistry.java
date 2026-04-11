package com.tydino.everbloomdandaloo.items.cooking;

import com.tydino.everbloomdandaloo.items.EDItemRegistry;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.registry.CompostableRegistry;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class EDCookingItemRegistry {

    //Foods
    public static final Item Tomato = EDItemRegistry.register("tomato", Item::new, new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).build()));

    public static void onInitialize(){
        //Foods can be composted:
        CompostableRegistry.INSTANCE.add(Tomato, 0.3f);
        }
}
