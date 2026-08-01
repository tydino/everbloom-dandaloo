package com.tydino.everbloomdandaloo.entities.ancient.jurassic;

import com.tydino.everbloomdandaloo.entities.EDEntityTypes;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class JurassicEntityTypes {

    public static final EntityType<BrachiosaurusEntity> Brachiosaurus = EDEntityTypes.register(
            "brachiosaurus",
            EntityType.Builder.of(BrachiosaurusEntity::new, MobCategory.CREATURE)
                    .sized(2.5f, 7f)
    );

    public static void onInitialize(){

    }

    public static void registerAttributes(){
        FabricDefaultAttributeRegistry.register(Brachiosaurus, BrachiosaurusEntity.createAttributes());
    }
}
