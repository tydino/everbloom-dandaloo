package com.tydino.everbloomdandaloo.client.screens;

import com.tydino.everbloomdandaloo.menus.EDMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;

public class EDScreenRegister {

    public static void onInitialize() {
        MenuScreens.register(EDMenuTypes.FossilRecombinator, FossilRecombinatorScreen::new);
    }
}
