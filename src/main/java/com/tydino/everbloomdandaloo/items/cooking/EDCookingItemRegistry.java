package com.tydino.everbloomdandaloo.items.cooking;

import com.tydino.everbloomdandaloo.blocks.cooking.EDCookingBlocks;
import com.tydino.everbloomdandaloo.items.EDItemRegistry;
import net.fabricmc.fabric.api.registry.CompostableRegistry;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class EDCookingItemRegistry {

    //general craftables
    public static final Item CompostBall = EDItemRegistry.register("compost_ball", Item::new, new Item.Properties());
    public static final Item Syringe = EDItemRegistry.register("syringe", Item::new, new Item.Properties());
    public static final Item Vial = EDItemRegistry.register("vial", Item::new, new Item.Properties());

    //Foods
    public static final Item Tomato = EDItemRegistry.register("tomato", setting -> new BlockItem(EDCookingBlocks.TomatoBush, setting.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).build())), new Item.Properties());

    public static void onInitialize(){
        //Foods can be composted:
        CompostableRegistry.INSTANCE.add(Tomato, 0.3f);
        }
}
