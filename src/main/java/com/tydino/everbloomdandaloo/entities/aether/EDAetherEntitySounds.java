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
    public static final Identifier AuRevoir_LATCH_ID = Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "mob.au_revoir.latch");
    public static final SoundEvent AuRevoir_AMBIENT = Registry.register(BuiltInRegistries.SOUND_EVENT, AuRevoir_AMBIENT_ID, SoundEvent.createVariableRangeEvent(AuRevoir_AMBIENT_ID));
    public static final SoundEvent AuRevoir_HURT = Registry.register(BuiltInRegistries.SOUND_EVENT, AuRevoir_HURT_ID, SoundEvent.createVariableRangeEvent(AuRevoir_HURT_ID));
    public static final SoundEvent AuRevoir_DEATH = Registry.register(BuiltInRegistries.SOUND_EVENT, AuRevoir_DEATH_ID, SoundEvent.createVariableRangeEvent(AuRevoir_DEATH_ID));
    public static final SoundEvent AuRevoir_LATCH = Registry.register(BuiltInRegistries.SOUND_EVENT, AuRevoir_LATCH_ID, SoundEvent.createVariableRangeEvent(AuRevoir_LATCH_ID));
    /// DAGGER STABBER ///
    public static final Identifier DaggerStabber_AMBIENT_ID = Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "mob.dagger_stabber.ambient");
    public static final Identifier DaggerStabber_HURT_ID = Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "mob.dagger_stabber.hurt");
    public static final Identifier DaggerStabber_DEATH_ID = Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "mob.dagger_stabber.death");
    public static final Identifier DaggerStabber_ATTACk_ID = Identifier.fromNamespaceAndPath(EverbloomDandaloo.MOD_ID, "mob.dagger_stabber.attack");
    public static final SoundEvent DaggerStabber_AMBIENT = Registry.register(BuiltInRegistries.SOUND_EVENT, DaggerStabber_AMBIENT_ID, SoundEvent.createVariableRangeEvent(DaggerStabber_AMBIENT_ID));
    public static final SoundEvent DaggerStabber_HURT = Registry.register(BuiltInRegistries.SOUND_EVENT, DaggerStabber_HURT_ID, SoundEvent.createVariableRangeEvent(DaggerStabber_HURT_ID));
    public static final SoundEvent DaggerStabber_DEATH = Registry.register(BuiltInRegistries.SOUND_EVENT, DaggerStabber_DEATH_ID, SoundEvent.createVariableRangeEvent(DaggerStabber_DEATH_ID));
    public static final SoundEvent DaggerStabber_ATTACK = Registry.register(BuiltInRegistries.SOUND_EVENT, DaggerStabber_ATTACk_ID, SoundEvent.createVariableRangeEvent(DaggerStabber_ATTACk_ID));
    public static void registerSounds()
    {
        //end but initializes data
    }
}
