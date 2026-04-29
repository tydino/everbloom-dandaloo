package com.tydino.everbloomdandaloo.items.aether;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.entities.aether.AetherEntityTypes;
import com.tydino.everbloomdandaloo.items.EDItemRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.ToolMaterial;

import javax.swing.text.html.HTML;

public class EDAetherItemRegistry {

    public static final TagKey<Item> AetherItemsRepairItem = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "repairs_aether_items"));

    public static final ToolMaterial AetherItemsSetOne = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            500,
            2f,
            3f,
            20,
            AetherItemsRepairItem
    );

    public static final Item SpawnDaggerStabber = EDItemRegistry.register(
            "spawn_daggerstabber",
            SpawnEggItem::new,
            new Item.Properties().spawnEgg(AetherEntityTypes.DaggerStabber)
    );

    public static final Item DaggerStabberMeat = EDItemRegistry.register("dagger_stabber_meat", Item::new, new Item.Properties());

    public static final Item DaggerStabberDagger = EDItemRegistry.register("daggerstabber_dagger", Item::new, new Item.Properties().sword(AetherItemsSetOne, 4f, 2f));

    public static void onInitialize(){

    }
}
