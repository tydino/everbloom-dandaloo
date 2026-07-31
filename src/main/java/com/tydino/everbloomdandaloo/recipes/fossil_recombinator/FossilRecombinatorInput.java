package com.tydino.everbloomdandaloo.recipes.fossil_recombinator;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

import java.util.List;

public record FossilRecombinatorInput(ItemStack input) implements RecipeInput {
    @Override
    public ItemStack getItem(int index) {
        return switch(index){
            case 0 -> this.input;
            default -> ItemStack.EMPTY;
        };
    }

    @Override
    public int size() {
        return 1;
    }
}
