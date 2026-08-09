package com.tydino.everbloomdandaloo.creativemenu.menus;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.blocks.ancient.EDJurassicBlocks;
import com.tydino.everbloomdandaloo.items.ancient.EDJurassicItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class EDJurassicItemGroup {

    public static final ResourceKey<CreativeModeTab> CreativeTab_key = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "jurassic")
    );
    public static final CreativeModeTab CreativeTab = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(EDJurassicItems.JurassicAnimalFossil))
            .title(Component.translatable("creativeTab.jurassic"))
            .displayItems((params, output) -> {

                /// FOSSILS
                output.accept(EDJurassicItems.JurassicAnimalFossil);
                output.accept(EDJurassicItems.AnimalFossilFragments);

                /// scarabs
                output.accept(EDJurassicItems.BigScarab);

                /// DINOSAURS
                output.accept(EDJurassicBlocks.BrachiosaurusEgg);
                output.accept(EDJurassicItems.HatchedBrachiosaurus);
                output.accept(EDJurassicItems.BrachiosaurusLimb);
                output.accept(EDJurassicItems.BrachiosaurusRibcage);
                output.accept(EDJurassicItems.BrachiosaurusSkull);
            })
            .build();

    public static void onInitialize(){
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CreativeTab_key, CreativeTab);
    }
}
