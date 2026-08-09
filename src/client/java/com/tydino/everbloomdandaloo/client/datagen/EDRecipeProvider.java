package com.tydino.everbloomdandaloo.client.datagen;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.blocks.ancient.EDAncientBlocks;
import com.tydino.everbloomdandaloo.items.cooking.EDCookingItemRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import techreborn.init.TRContent;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class EDRecipeProvider extends FabricRecipeProvider {
    public EDRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        EverbloomDandaloo.LOGGER.info("Making Recipes for Everbloom Dandaloo");
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {

                /// Vanilla Tweaks ///
                List<ItemLike> CobbleStone = List.of(Items.COBBLESTONE);
                oreBlasting(CobbleStone, RecipeCategory.MISC, CookingBookCategory.BLOCKS, Items.GRAVEL, 0.25f, 100, "gravel");
                List<ItemLike> Gravel = List.of(Items.GRAVEL);
                oreBlasting(Gravel, RecipeCategory.MISC, CookingBookCategory.BLOCKS, Items.SAND, 0.25f, 100, "sand");

                shapeless(RecipeCategory.MISC, Items.STONE, 4)
                        .requires(Items.COBBLESTONE, 4)
                                .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                                        .group("stone")
                                                .save(output);

                ///  JOKE  ///
                shapeless(RecipeCategory.FOOD, EDCookingItemRegistry.Tomato, 1)
                        .requires(Items.WOOL.red())
                        .unlockedBy(getHasName(Items.WOOL.red()), has(Items.WOOL.red()))
                        .group("ed-food")//puts all the food into a group labeled as such to become collapsable
                        .save(output);

                /// ANCIENT ///
                //blocks
                shaped(RecipeCategory.REDSTONE, EDAncientBlocks.FossilRecombiner)
                        .pattern(" s ")
                        .pattern("scs")
                        .pattern(" s ")
                        .define('s', Blocks.SANDSTONE_SLAB)
                        .define('c', Blocks.CRAFTING_TABLE)
                        .unlockedBy(getHasName(Blocks.CRAFTING_TABLE), has(Blocks.CRAFTING_TABLE))
                        .save(output);
                //powered blocks
                shaped(RecipeCategory.REDSTONE, EDAncientBlocks.FossilAdapter)
                        .pattern("rcr")
                        .pattern("cwc")
                        .pattern("cbc")
                        .define('c', TRContent.Plates.IRON)
                        .define('w', TRContent.Plates.WOOD)
                        .define('r', TRContent.Parts.RUBBER)
                        .define('b', TRContent.Parts.ELECTRONIC_CIRCUIT)
                        .unlockedBy(getHasName(TRContent.Parts.ELECTRONIC_CIRCUIT), has(TRContent.Parts.ELECTRONIC_CIRCUIT))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "Everbloom Dandaloo Recipes";
    }
}
