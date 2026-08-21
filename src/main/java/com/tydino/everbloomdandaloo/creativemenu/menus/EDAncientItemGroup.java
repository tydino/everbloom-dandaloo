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
            .icon(() -> new ItemStack(EDJurassicItems.BrachiosaurusFossil))
            .title(Component.translatable("creativeTab.ancient"))
            .displayItems((params, output) -> {
                output.accept(EDAncientBlocks.Feeder);
                output.accept(EDAncientItems.GrowthSerum);
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

                /// DINOSAURS ///
                output.accept(EDJurassicBlocks.BrachiosaurusEgg);                               //BRACHIOSUARUS//
                output.accept(EDJurassicItems.HatchedBrachiosaurus);
                output.accept(EDJurassicBlocks.BrachiosaurusFossilOre);
                output.accept(EDJurassicItems.BrachiosaurusFossil);
                output.accept(EDJurassicItems.BrachiosaurusFragments);
                output.accept(EDJurassicItems.BrachiosaurusLimb);
                output.accept(EDJurassicItems.BrachiosaurusRibcage);
                output.accept(EDJurassicItems.BrachiosaurusSkull);


                //powered objects
                output.accept(EDAncientBlocks.FossilRecombiner);
                output.accept(EDAncientBlocks.FossilAdapter);
                output.accept(EDAncientBlocks.BoneAnalyzer);
                output.accept(EDAncientBlocks.DNAReformer);
            })
            .build();

    public static void onInitialize(){
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CreativeTab_key, CreativeTab);
    }
}
