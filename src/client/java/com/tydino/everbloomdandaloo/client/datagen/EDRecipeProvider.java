package com.tydino.everbloomdandaloo.client.datagen;

import com.tydino.everbloomdandaloo.items.cooking.EDCookingItemRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class EDRecipeProvider extends FabricRecipeProvider {
    public EDRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {
                shapeless(RecipeCategory.FOOD, EDCookingItemRegistry.Tomato, 1)
                        .requires(Items.WOOL.red())
                        .unlockedBy(getHasName(Items.WOOL.red()), has(Items.WOOL.red()))
                        .group("ed-food")//puts all the food into a group labeled as such to become collapsable
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "Everbloom Dandaloo Recipes";
    }
}
