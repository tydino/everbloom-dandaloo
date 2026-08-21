package com.tydino.everbloomdandaloo.menus;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.menus.fossil_recombinator.FossilRecombinatorMenu;
import net.fabricmc.fabric.api.menu.v1.ExtendedMenuType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public class EDMenuTypes {

    public static final MenuType<FossilRecombinatorMenu> FossilRecombinator = registerForNonInventoryBlockMenu("fossil_recombinator", FossilRecombinatorMenu::new);

    public static MenuType<FeederMenu> Feeder =
            Registry.register(BuiltInRegistries.MENU, Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "feeder"),
                    new ExtendedMenuType<>(FeederMenu::new, BlockPos.STREAM_CODEC));

    public static void onInitialize(){}

    public static <T extends AbstractContainerMenu> MenuType<T> registerForNonInventoryBlockMenu(String name, MenuType.MenuSupplier<T> constructor) {
        return Registry.register(BuiltInRegistries.MENU, Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, name), new MenuType<>(constructor, FeatureFlagSet.of()));
    }
}
