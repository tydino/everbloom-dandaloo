package com.tydino.everbloomdandaloo.recipes.fossil_recombinator;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.tydino.everbloomdandaloo.recipes.EDRecipes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class FossilRecombinatorRecipe implements Recipe<FossilRecombinatorInput> {
    final ItemStackTemplate result;
    final Ingredient baseItem;

    public static final MapCodec<FossilRecombinatorRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    ItemStackTemplate.CODEC.fieldOf("result").forGetter(FossilRecombinatorRecipe::getResult),
                    Ingredient.CODEC.fieldOf("baseItem").forGetter(FossilRecombinatorRecipe::getBaseItem),
                    Ingredient.CODEC.fieldOf("upgradeItem").forGetter(FossilRecombinatorRecipe::getUpgradeItem)
                    ).apply(instance, FossilRecombinatorRecipe::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, FossilRecombinatorRecipe> STREAM_CODEC = StreamCodec.composite(
            ItemStackTemplate.STREAM_CODEC,
            FossilRecombinatorRecipe::getResult,
            Ingredient.CONTENTS_STREAM_CODEC,
            FossilRecombinatorRecipe::getBaseItem,
            Ingredient.CONTENTS_STREAM_CODEC,
            FossilRecombinatorRecipe::getUpgradeItem,
            FossilRecombinatorRecipe::new
    );

    public FossilRecombinatorRecipe(ItemStackTemplate result, Ingredient baseItem, Ingredient upgradeItem) {
        this.baseItem = baseItem;
        this.result = result;
    }

    public ItemStackTemplate getResult() {
        return this.result;
    }

    public Ingredient getBaseItem() {
        return this.baseItem;
    }

    public Ingredient getUpgradeItem(){
        return null;
    }

    @Override
    public boolean matches(FossilRecombinatorInput recipeInput, Level level) {
        return this.baseItem.test(recipeInput.input());
    }

    @Override
    public ItemStack assemble(FossilRecombinatorInput recipeInput) {
        return this.result.create();

    }

    @Override
    public RecipeSerializer<? extends Recipe<FossilRecombinatorInput>> getSerializer() {
        return EDRecipes.FossilRecombinatorRECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<FossilRecombinatorInput>> getType() {
        return EDRecipes.FossilRecombinatorRECIPE_TYPE;
    }

    @Override
    public @Nullable RecipeBookCategory recipeBookCategory() {
        return null;
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean showNotification() {
        return true;
    }

    @Override
    public String group() {
        return "fossil_combinator";
    }

}
