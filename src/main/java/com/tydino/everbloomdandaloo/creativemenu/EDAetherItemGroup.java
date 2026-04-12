package com.tydino.everbloomdandaloo.creativemenu;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.items.aether.EDAetherItemRegistry;
import com.tydino.everbloomdandaloo.items.cooking.EDCookingItemRegistry;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class EDAetherItemGroup {
    public static final ResourceKey<CreativeModeTab> CreativeTab_key = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "aether")
    );
    public static final CreativeModeTab CreativeTab = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(EDCookingItemRegistry.Tomato))
            .title(Component.translatable("creativeTab.aether"))
            .displayItems((params, output) -> {

                //temp
                output.accept(EDAetherItemRegistry.SpawnDaggerStabber);
            })
            .build();

    public static void onInitialize(){
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CreativeTab_key, CreativeTab);
    }
}
