package com.tydino.everbloomdandaloo.creativemenu.menus;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.blocks.ancient.energy.EDAncientEnergyBlocks;
import com.tydino.everbloomdandaloo.items.ancient.EDCretaceousItems;
import com.tydino.everbloomdandaloo.items.ancient.EDJurassicItems;
import com.tydino.everbloomdandaloo.items.ancient.EDPaleozoicItems;
import com.tydino.everbloomdandaloo.items.ancient.EDTriassicItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class EDAncientItemGroup {

    public static final ResourceKey<CreativeModeTab> CreativeTab_key = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "ancient")
    );
    public static final CreativeModeTab CreativeTab = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(EDPaleozoicItems.PermianAnimalFossil))
            .title(Component.translatable("creativeTab.ancient"))
            .displayItems((params, output) -> {

                //fossils
                output.accept(EDPaleozoicItems.PermianAnimalFossil);
                output.accept(EDTriassicItems.TriassicAnimalFossil);
                output.accept(EDJurassicItems.JurassicAnimalFossil);
                output.accept(EDCretaceousItems.CretaceousAnimalFossil);
                //fossil fragments
                output.accept(EDPaleozoicItems.AnimalFossilFragments);
                output.accept(EDTriassicItems.AnimalFossilFragments);
                output.accept(EDJurassicItems.AnimalFossilFragments);
                output.accept(EDCretaceousItems.AnimalFossilFragments);

                //powered objects
                output.accept(EDAncientEnergyBlocks.FossilRecombiner);
            })
            .build();

    public static void onInitialize(){
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CreativeTab_key, CreativeTab);
    }
}
