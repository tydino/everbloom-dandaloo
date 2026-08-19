package com.tydino.everbloomdandaloo.stats.ancient;

import com.tydino.everbloomdandaloo.stats.EDStats;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.StatFormatter;

public class EDAncientStats {

    //Machines
    public static Identifier InteractionsWithFossilRecombiner = EDStats.makeCustomStat("interactions_with_fossil_recombiner", StatFormatter.DEFAULT);

    //MISC
    public static Identifier InteractionsWithFeeder = EDStats.makeCustomStat("interactions_with_feeder", StatFormatter.DEFAULT);

    public static void onInitialize(){}
}
