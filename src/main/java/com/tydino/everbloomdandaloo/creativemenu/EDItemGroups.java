package com.tydino.everbloomdandaloo.creativemenu;

import com.tydino.everbloomdandaloo.creativemenu.menus.EDAetherItemGroup;
import com.tydino.everbloomdandaloo.creativemenu.menus.EDAncientItemGroup;
import com.tydino.everbloomdandaloo.creativemenu.menus.EDPermianItemGroup;
import com.tydino.everbloomdandaloo.creativemenu.menus.EDTriassicItemGroup;

public class EDItemGroups {
    public static void onInitialize(){
        EDAetherItemGroup.onInitialize();
        EDAncientItemGroup.onInitialize();
        EDPermianItemGroup.onInitialize();
        EDTriassicItemGroup.onInitialize();
    }
}
