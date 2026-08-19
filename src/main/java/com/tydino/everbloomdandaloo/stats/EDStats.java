package com.tydino.everbloomdandaloo.stats;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.stats.ancient.EDAncientStats;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.StatType;
import net.minecraft.stats.Stats;

public class EDStats {

    public static void OnInitialize(){
        EDAncientStats.onInitialize();
    }

    public static Identifier makeCustomStat(final String id, final StatFormatter formatter) {
        Identifier location = Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, id);
        Registry.register(BuiltInRegistries.CUSTOM_STAT, id, location);
        Stats.CUSTOM.get(location, formatter);//use Stats to check otehr stat types that can be made
        return location;
    }

    /*public static <T> StatType<T> makeRegistryStatType(final String name, final Registry<T> registry) {
        Component displayName = Component.translatable("stat_type.everbloomdandaloo." + name);
        return (StatType)Registry.register(BuiltInRegistries.STAT_TYPE, name, new StatType(registry, displayName));
    }*/
}
