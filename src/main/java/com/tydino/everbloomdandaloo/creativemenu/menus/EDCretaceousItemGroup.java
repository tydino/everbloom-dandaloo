package com.tydino.everbloomdandaloo.creativemenu.menus;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.items.ancient.EDCretaceousItems;
import com.tydino.everbloomdandaloo.items.ancient.EDJurassicItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class EDCretaceousItemGroup {

    public static final ResourceKey<CreativeModeTab> CreativeTab_key = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "cretaceous")
    );
    public static final CreativeModeTab CreativeTab = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(EDCretaceousItems.CretaceousAnimalFossil))
            .title(Component.translatable("creativeTab.cretaceous"))
            .displayItems((params, output) -> {

                output.accept(EDCretaceousItems.CretaceousAnimalFossil);
                output.accept(EDCretaceousItems.AnimalFossilFragments);
            })
            .build();

    public static void onInitialize(){
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CreativeTab_key, CreativeTab);
    }
}
