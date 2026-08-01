package com.tydino.everbloomdandaloo.entities.ancient;

import com.tydino.everbloomdandaloo.entities.ancient.jurassic.JurassicEntityTypes;

public class AncientEntityTypes {
    public static void onInitialize(){
        JurassicEntityTypes.onInitialize();
        JurassicEntityTypes.registerAttributes();
    }
}
