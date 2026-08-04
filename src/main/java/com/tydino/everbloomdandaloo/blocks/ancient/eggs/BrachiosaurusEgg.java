package com.tydino.everbloomdandaloo.blocks.ancient.eggs;

import com.mojang.serialization.MapCodec;
import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.blocks.ancient.DinosaurEgg;
import com.tydino.everbloomdandaloo.entities.ancient.jurassic.BrachiosaurusEntity;
import com.tydino.everbloomdandaloo.entities.ancient.jurassic.BrachiosaurusVariant;
import com.tydino.everbloomdandaloo.entities.ancient.jurassic.JurassicEntityTypes;
import com.tydino.everbloomdandaloo.entities.entitybases.EDDinosaureEntityBase;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class BrachiosaurusEgg extends DinosaurEgg {
    public static final MapCodec<BrachiosaurusEgg> CODEC = simpleCodec(BrachiosaurusEgg::new);

    @Override
    public void SetEntityData(ServerLevel level, EDDinosaureEntityBase entity, Vec3 spawnAt) {

        Random random = new Random();

        if (HasParents.equals(true)) {
            int parentVariantToCheck = random.nextInt(2);
            int maleOrFemale = random.nextInt(2);// 0=female, 1=male
            if (parentVariantToCheck == 0) {///mother
                if (entity.variant == BrachiosaurusVariant.banana_female.getId()) {
                    if (entity instanceof BrachiosaurusEntity) {
                        if(maleOrFemale == 0) {
                            ((BrachiosaurusEntity) entity).setVariant(BrachiosaurusVariant.banana_female);
                            entity.setGender(EDDinosaureEntityBase.gender_female);
                            entity.variant = ((BrachiosaurusEntity) entity).getVariant().getId();
                        }else{
                            ((BrachiosaurusEntity) entity).setVariant(BrachiosaurusVariant.banana_male);
                            entity.setGender(EDDinosaureEntityBase.gender_male);
                            entity.variant = ((BrachiosaurusEntity) entity).getVariant().getId();
                        }
                    }
                }else if(entity.variant == BrachiosaurusVariant.movie_female.getId()){
                    if (entity instanceof BrachiosaurusEntity) {
                        if(maleOrFemale == 0) {
                            ((BrachiosaurusEntity) entity).setVariant(BrachiosaurusVariant.movie_female);
                            entity.setGender(EDDinosaureEntityBase.gender_female);
                            entity.variant = ((BrachiosaurusEntity) entity).getVariant().getId();
                        }else{
                            ((BrachiosaurusEntity) entity).setVariant(BrachiosaurusVariant.movie_male);
                            entity.setGender(EDDinosaureEntityBase.gender_male);
                            entity.variant = ((BrachiosaurusEntity) entity).getVariant().getId();
                        }
                    }
                }
            } else {///father
                if (entity.partnerVariant == BrachiosaurusVariant.banana_male.getId()) {
                    if (entity instanceof BrachiosaurusEntity) {
                        if (maleOrFemale == 0) {
                            ((BrachiosaurusEntity) entity).setVariant(BrachiosaurusVariant.banana_female);
                            entity.setGender(EDDinosaureEntityBase.gender_female);
                            entity.variant = ((BrachiosaurusEntity) entity).getVariant().getId();
                        } else {
                            ((BrachiosaurusEntity) entity).setVariant(BrachiosaurusVariant.banana_male);
                            entity.setGender(EDDinosaureEntityBase.gender_male);
                            entity.variant = ((BrachiosaurusEntity) entity).getVariant().getId();
                        }
                    }
                } else if (entity.partnerVariant == BrachiosaurusVariant.movie_male.getId()) {
                    if (entity instanceof BrachiosaurusEntity) {
                        if (maleOrFemale == 0) {
                            ((BrachiosaurusEntity) entity).setVariant(BrachiosaurusVariant.movie_female);
                            entity.setGender(EDDinosaureEntityBase.gender_female);
                        } else {
                            ((BrachiosaurusEntity) entity).setVariant(BrachiosaurusVariant.movie_male);
                            entity.setGender(EDDinosaureEntityBase.gender_male);
                        }
                    }
                }
            }
        }
        else{
            int variantToUseRandom = random.nextInt(4);

            if(variantToUseRandom == 0) {
                ((BrachiosaurusEntity) entity).setVariant(BrachiosaurusVariant.movie_male);
                entity.setGender(EDDinosaureEntityBase.gender_male);
                entity.variant = ((BrachiosaurusEntity) entity).getVariant().getId();
            }
            if(variantToUseRandom == 1) {
                ((BrachiosaurusEntity) entity).setVariant(BrachiosaurusVariant.banana_male);
                entity.setGender(EDDinosaureEntityBase.gender_male);
                entity.variant = ((BrachiosaurusEntity) entity).getVariant().getId();
            }
            if(variantToUseRandom == 2) {
                ((BrachiosaurusEntity) entity).setVariant(BrachiosaurusVariant.movie_female);
                entity.setGender(EDDinosaureEntityBase.gender_female);
                entity.variant = ((BrachiosaurusEntity) entity).getVariant().getId();
            }
            if(variantToUseRandom == 3) {
                ((BrachiosaurusEntity) entity).setVariant(BrachiosaurusVariant.banana_female);
                entity.setGender(EDDinosaureEntityBase.gender_female);
                entity.variant = ((BrachiosaurusEntity) entity).getVariant().getId();
            }
        }

        EverbloomDandaloo.LOGGER.info("should spawn as; gender: " + entity.getGender() + "variant" + entity.variant);

        super.SetEntityData(level, entity, spawnAt);
    }

    public BrachiosaurusEgg(Properties properties) {
        super(properties, 4, 0, 4, 12, 6, 12, 30, JurassicEntityTypes.Brachiosaurus, CODEC, 4);
    }
}
