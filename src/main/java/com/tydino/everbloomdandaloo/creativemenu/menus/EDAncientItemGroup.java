package com.tydino.everbloomdandaloo.creativemenu.menus;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.blocks.ancient.EDAncientBlocks;
import com.tydino.everbloomdandaloo.blocks.ancient.EDJurassicBlocks;
import com.tydino.everbloomdandaloo.items.ancient.*;
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
                output.accept(EDAncientItems.GrowthSerum);
                //fossils
                output.accept(EDAncientBlocks.FossilOre);
                output.accept(EDAncientBlocks.DeepslateFossilOre);
                output.accept(EDPaleozoicItems.PermianAnimalFossil);
                output.accept(EDTriassicItems.TriassicAnimalFossil);
                output.accept(EDJurassicItems.JurassicAnimalFossil);
                output.accept(EDCretaceousItems.CretaceousAnimalFossil);
                //fossil fragments
                output.accept(EDPaleozoicItems.AnimalFossilFragments);
                output.accept(EDTriassicItems.AnimalFossilFragments);
                output.accept(EDJurassicItems.AnimalFossilFragments);
                output.accept(EDCretaceousItems.AnimalFossilFragments);
                //amber
                output.accept(EDAncientBlocks.AmberOre);
                output.accept(EDAncientBlocks.DeepslateAmberOre);
                output.accept(EDPaleozoicItems.BigBugAmber);
                output.accept(EDAncientItems.AmberMediumBug);
                output.accept(EDAncientItems.AmberBugs);
                output.accept(EDAncientItems.AmberWing);
                output.accept(EDAncientItems.AmberPlant);
                //scarabs
                output.accept(EDJurassicItems.BigScarab);
                output.accept(EDAncientItems.BreedingScarab);
                /// DINOSAURS
                output.accept(EDJurassicBlocks.BrachiosaurusEgg);
                output.accept(EDJurassicItems.HatchedBrachiosaurus);

                //powered objects
                output.accept(EDAncientBlocks.FossilRecombiner);
                output.accept(EDAncientBlocks.FossilAdapter);
            })
            .build();

    public static void onInitialize(){
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CreativeTab_key, CreativeTab);
    }
}
