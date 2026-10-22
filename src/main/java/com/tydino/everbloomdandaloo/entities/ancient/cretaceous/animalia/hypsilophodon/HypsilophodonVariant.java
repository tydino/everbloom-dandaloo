package com.tydino.everbloomdandaloo.entities.ancient.cretaceous.animalia.hypsilophodon;

import java.util.Arrays;
import java.util.Comparator;

public enum HypsilophodonVariant {

    mud_male(0),
    mud_female(1),
    groomed_male(2),
    groomed_female(3),
    nerd_male(4),
    nerd_female(5);

    private static final HypsilophodonVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(HypsilophodonVariant::getId)).toArray(HypsilophodonVariant[]::new);
    private final int id;

    HypsilophodonVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static HypsilophodonVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
