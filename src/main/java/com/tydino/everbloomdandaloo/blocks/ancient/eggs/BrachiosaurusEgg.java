package com.tydino.everbloomdandaloo.blocks.ancient.eggs;

import com.mojang.serialization.MapCodec;
import com.tydino.everbloomdandaloo.blocks.ancient.DinosaurEgg;
import com.tydino.everbloomdandaloo.entities.ancient.jurassic.BrachiosaurusEntity;
import com.tydino.everbloomdandaloo.entities.ancient.jurassic.JurassicEntityTypes;
import com.tydino.everbloomdandaloo.entities.entitybases.EDDinosaureEntityBase;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec3;

public class BrachiosaurusEgg extends DinosaurEgg {
    public static final MapCodec<BrachiosaurusEgg> CODEC = simpleCodec(BrachiosaurusEgg::new);

    @Override
    public void SetEntityData(ServerLevel level, EDDinosaureEntityBase entity, Vec3 spawnAt){

        /*if(entity instanceof BrachiosaurusEntity){
            ((BrachiosaurusEntity) entity).setVariant();
        }*/

        super.SetEntityData(level, entity, spawnAt);
    }

    public BrachiosaurusEgg(Properties properties) {
        super(properties, 4, 0, 4, 12, 6, 12, 30, JurassicEntityTypes.Brachiosaurus, CODEC);
    }
}
