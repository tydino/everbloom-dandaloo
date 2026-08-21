package com.tydino.everbloomdandaloo.stats.ancient;

import com.tydino.everbloomdandaloo.stats.EDStats;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.StatFormatter;

public class EDAncientStats {

    //Machines
    public static Identifier InteractionsWithFossilRecombiner = EDStats.makeCustomStat("interactions_with_fossil_recombiner", StatFormatter.DEFAULT);

    public static Identifier InteractionsWithFossilAdapter = EDStats.makeCustomStat("interactions_with_fossil_adapter", StatFormatter.DEFAULT);

    public static Identifier InteractionsWithBoneAnalyzer = EDStats.makeCustomStat("interactions_with_bone_analyzer", StatFormatter.DEFAULT);

    public static Identifier InteractionsWithDNAReformer = EDStats.makeCustomStat("interactions_with_dna_reformer", StatFormatter.DEFAULT);

    //MISC
    public static Identifier InteractionsWithFeeder = EDStats.makeCustomStat("interactions_with_feeder", StatFormatter.DEFAULT);

    public static void onInitialize(){}
}
