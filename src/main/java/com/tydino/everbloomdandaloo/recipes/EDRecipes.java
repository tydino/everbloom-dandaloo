package com.tydino.everbloomdandaloo.recipes;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.recipes.fossil_recombinator.FossilRecombinatorRecipe;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

/// https://docs.fabricmc.net/develop/recipes/custom-recipe-types ///
public class EDRecipes {

    public static final RecipeSerializer<FossilRecombinatorRecipe> FossilRecombinatorRECIPE_SERIALIZER = Registry.register(
            BuiltInRegistries.RECIPE_SERIALIZER,
            Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "fossil_combinator"),
            new RecipeSerializer<>(FossilRecombinatorRecipe.CODEC, FossilRecombinatorRecipe.STREAM_CODEC)
    );
    public static final RecipeType<FossilRecombinatorRecipe> FossilRecombinatorRECIPE_TYPE = Registry.register(
            BuiltInRegistries.RECIPE_TYPE,
            Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "fossil_combinator"),
            new RecipeType<FossilRecombinatorRecipe>() { }
    );

    public static void onInitialize(){

    }
}
