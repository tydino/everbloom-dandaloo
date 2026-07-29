package com.tydino.everbloomdandaloo.creativemenu;

import com.tydino.everbloomdandaloo.creativemenu.menus.EDAetherItemGroup;
import com.tydino.everbloomdandaloo.creativemenu.menus.EDCookingItemGroup;

public class EDItemGroups {
    public static void onInitialize(){
        EDCookingItemGroup.onInitialize();
        EDAetherItemGroup.onInitialize();
    }
}
