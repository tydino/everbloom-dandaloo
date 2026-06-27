package com.tydino.everbloomdandaloo.entities.aether;

import com.tydino.everbloomdandaloo.EDSounds;
import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class EDAetherEntitySounds {
    /// AU REVOIR ///
    public static final Identifier AuRevoir_AMBIENT_ID = Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "mob.au_revoir.ambient");
    public static final Identifier AuRevoir_HURT_ID = Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "mob.au_revoir.hurt");
    public static final Identifier AuRevoir_DEATH_ID = Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "mob.au_revoir.death");
    public static final SoundEvent AuRevoir_AMBIENT = Registry.register(BuiltInRegistries.SOUND_EVENT, AuRevoir_AMBIENT_ID, SoundEvent.createVariableRangeEvent(AuRevoir_AMBIENT_ID));
    public static final SoundEvent AuRevoir_HURT = Registry.register(BuiltInRegistries.SOUND_EVENT, AuRevoir_HURT_ID, SoundEvent.createVariableRangeEvent(AuRevoir_HURT_ID));
    public static final SoundEvent AuRevoir_DEATH = Registry.register(BuiltInRegistries.SOUND_EVENT, AuRevoir_DEATH_ID, SoundEvent.createVariableRangeEvent(AuRevoir_DEATH_ID));
    public static void registerSounds()
    {
        //end but initializes data
    }
}
