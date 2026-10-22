package com.tydino.everbloomdandaloo.entities.ancient;

import com.tydino.everbloomdandaloo.entities.ancient.cretaceous.animalia.CretaceousEntityTypes;
import com.tydino.everbloomdandaloo.entities.ancient.jurassic.JurassicEntityTypes;

public class AncientEntityTypes {
    public static void onInitialize(){
        CretaceousEntityTypes.onInitialize();
        CretaceousEntityTypes.registerAttributes();
        JurassicEntityTypes.onInitialize();
        JurassicEntityTypes.registerAttributes();
    }
}
