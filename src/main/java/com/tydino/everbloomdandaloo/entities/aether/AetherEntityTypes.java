package com.tydino.everbloomdandaloo.entities.aether;

import com.tydino.everbloomdandaloo.entities.EDEntityTypes;
import com.tydino.everbloomdandaloo.entities.aether.au_revoir.AuRevoirEntity;
import com.tydino.everbloomdandaloo.entities.aether.dagger_stabber.DaggerStabberEntity;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class AetherEntityTypes {
    public static final EntityType<DaggerStabberEntity> DaggerStabber = EDEntityTypes.register(
            "dagger_stabber",
            EntityType.Builder.of(DaggerStabberEntity::new, MobCategory.CREATURE)
                    .sized(0.625f, 1.75f)
    );

    public static final EntityType<AuRevoirEntity> AuRevoir = EDEntityTypes.register(
            "au_revoir",
            EntityType.Builder.of(AuRevoirEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.75f)
    );

    public static void onInitialize(){

    }

    public static void registerAttributes(){
        FabricDefaultAttributeRegistry.register(DaggerStabber, DaggerStabberEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AuRevoir, AuRevoirEntity.createAttributes());
    }
}
