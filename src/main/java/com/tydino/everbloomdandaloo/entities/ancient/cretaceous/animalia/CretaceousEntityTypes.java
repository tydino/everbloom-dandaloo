package com.tydino.everbloomdandaloo.entities.ancient.cretaceous.animalia;

import com.tydino.everbloomdandaloo.entities.EDEntityTypes;
import com.tydino.everbloomdandaloo.entities.ancient.cretaceous.animalia.hypsilophodon.HypsilophodonEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class CretaceousEntityTypes {

    public static EntityType<HypsilophodonEntity> Hypsilophodon = EDEntityTypes.register(
            "hypsilophodon",
            EntityType.Builder.of(HypsilophodonEntity::new, MobCategory.CREATURE)
                    .sized(0.375f, 0.625f).eyeHeight(0.625f));

    public static void onInitialize(){

    }

    public static void registerAttributes(){
        FabricDefaultAttributeRegistry.register(Hypsilophodon, HypsilophodonEntity.createAttributes());
    }
}
