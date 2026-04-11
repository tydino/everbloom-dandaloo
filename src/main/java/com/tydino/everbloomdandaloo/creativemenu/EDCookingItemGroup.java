package com.tydino.everbloomdandaloo.creativemenu;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.items.cooking.EDCookingItemRegistry;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class EDCookingItemGroup {

    public static final ResourceKey<CreativeModeTab> CookingCreativeTab_key = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "creative_tab")
    );
    public static final CreativeModeTab CookingCreativeTab = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(EDCookingItemRegistry.Tomato))
            .title(Component.translatable("creativeTab.cooking"))
            .displayItems((params, output) -> {
                output.accept(EDCookingItemRegistry.Tomato);
            })
            .build();

    public static void onInitialize(){
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CookingCreativeTab_key, CookingCreativeTab);
    }
}
