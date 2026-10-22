package com.tydino.everbloomdandaloo.blocks.ancient.eggs;

import com.mojang.serialization.MapCodec;
import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.blocks.ancient.DinosaurEgg;
import com.tydino.everbloomdandaloo.entities.ancient.cretaceous.animalia.CretaceousEntityTypes;
import com.tydino.everbloomdandaloo.entities.ancient.cretaceous.animalia.hypsilophodon.HypsilophodonEntity;
import com.tydino.everbloomdandaloo.entities.ancient.cretaceous.animalia.hypsilophodon.HypsilophodonVariant;
import com.tydino.everbloomdandaloo.entities.entitybases.EDDinosaureEntityBase;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class HypsilophodonEgg extends DinosaurEgg {
    public static final MapCodec<HypsilophodonEgg> CODEC = simpleCodec(HypsilophodonEgg::new);

    @Override
    public void SetEntityData(ServerLevel level, EDDinosaureEntityBase entity, Vec3 spawnAt) {

        Random random = new Random();

        if (HasParents.equals(true)) {
            int parentVariantToCheck = random.nextInt(2);
            int maleOrFemale = random.nextInt(2);// 0=female, 1=male
            if (parentVariantToCheck == 0) {///mother
                if (entity.variant == HypsilophodonVariant.groomed_female.getId()) {
                    if (entity instanceof HypsilophodonEntity) {
                        if(maleOrFemale == 0) {
                            ((HypsilophodonEntity) entity).setVariant(HypsilophodonVariant.groomed_female);
                            entity.setGender(EDDinosaureEntityBase.gender_female);
                            entity.variant = ((HypsilophodonEntity) entity).getVariant().getId();
                        }else{
                            ((HypsilophodonEntity) entity).setVariant(HypsilophodonVariant.groomed_male);
                            entity.setGender(EDDinosaureEntityBase.gender_male);
                            entity.variant = ((HypsilophodonEntity) entity).getVariant().getId();
                        }
                    }
                }else if(entity.variant == HypsilophodonVariant.mud_female.getId()){
                    if (entity instanceof HypsilophodonEntity) {
                        if(maleOrFemale == 0) {
                            ((HypsilophodonEntity) entity).setVariant(HypsilophodonVariant.mud_female);
                            entity.setGender(EDDinosaureEntityBase.gender_female);
                            entity.variant = ((HypsilophodonEntity) entity).getVariant().getId();
                        }else{
                            ((HypsilophodonEntity) entity).setVariant(HypsilophodonVariant.mud_male);
                            entity.setGender(EDDinosaureEntityBase.gender_male);
                            entity.variant = ((HypsilophodonEntity) entity).getVariant().getId();
                        }
                    }
                }else if(entity.variant == HypsilophodonVariant.nerd_female.getId()) {
                    if (entity instanceof HypsilophodonEntity) {
                        if (maleOrFemale == 0) {
                            ((HypsilophodonEntity) entity).setVariant(HypsilophodonVariant.nerd_female);
                            entity.setGender(EDDinosaureEntityBase.gender_female);
                            entity.variant = ((HypsilophodonEntity) entity).getVariant().getId();
                        } else {
                            ((HypsilophodonEntity) entity).setVariant(HypsilophodonVariant.nerd_male);
                            entity.setGender(EDDinosaureEntityBase.gender_male);
                            entity.variant = ((HypsilophodonEntity) entity).getVariant().getId();
                        }
                    }
                }
            } else {///father
                if (entity.partnerVariant == HypsilophodonVariant.groomed_male.getId()) {
                    if (entity instanceof HypsilophodonEntity) {
                        if (maleOrFemale == 0) {
                            ((HypsilophodonEntity) entity).setVariant(HypsilophodonVariant.groomed_female);
                            entity.setGender(EDDinosaureEntityBase.gender_female);
                            entity.variant = ((HypsilophodonEntity) entity).getVariant().getId();
                        } else {
                            ((HypsilophodonEntity) entity).setVariant(HypsilophodonVariant.groomed_male);
                            entity.setGender(EDDinosaureEntityBase.gender_male);
                            entity.variant = ((HypsilophodonEntity) entity).getVariant().getId();
                        }
                    }
                } else if (entity.partnerVariant == HypsilophodonVariant.mud_male.getId()) {
                    if (entity instanceof HypsilophodonEntity) {
                        if (maleOrFemale == 0) {
                            ((HypsilophodonEntity) entity).setVariant(HypsilophodonVariant.mud_female);
                            entity.setGender(EDDinosaureEntityBase.gender_female);
                        } else {
                            ((HypsilophodonEntity) entity).setVariant(HypsilophodonVariant.mud_male);
                            entity.setGender(EDDinosaureEntityBase.gender_male);
                        }
                    }
                }else if (entity.partnerVariant == HypsilophodonVariant.nerd_male.getId()) {
                    if (entity instanceof HypsilophodonEntity) {
                        if (maleOrFemale == 0) {
                            ((HypsilophodonEntity) entity).setVariant(HypsilophodonVariant.nerd_female);
                            entity.setGender(EDDinosaureEntityBase.gender_female);
                        } else {
                            ((HypsilophodonEntity) entity).setVariant(HypsilophodonVariant.nerd_male);
                            entity.setGender(EDDinosaureEntityBase.gender_male);
                        }
                    }
                }
            }
        }
        else{
            int variantToUseRandom = random.nextInt(6);

            if(variantToUseRandom == 0) {
                ((HypsilophodonEntity) entity).setVariant(HypsilophodonVariant.mud_male);
                entity.setGender(EDDinosaureEntityBase.gender_male);
                entity.variant = ((HypsilophodonEntity) entity).getVariant().getId();
            }
            if(variantToUseRandom == 1) {
                ((HypsilophodonEntity) entity).setVariant(HypsilophodonVariant.groomed_male);
                entity.setGender(EDDinosaureEntityBase.gender_male);
                entity.variant = ((HypsilophodonEntity) entity).getVariant().getId();
            }
            if(variantToUseRandom == 2) {
                ((HypsilophodonEntity) entity).setVariant(HypsilophodonVariant.mud_female);
                entity.setGender(EDDinosaureEntityBase.gender_female);
                entity.variant = ((HypsilophodonEntity) entity).getVariant().getId();
            }
            if(variantToUseRandom == 3) {
                ((HypsilophodonEntity) entity).setVariant(HypsilophodonVariant.groomed_female);
                entity.setGender(EDDinosaureEntityBase.gender_female);
                entity.variant = ((HypsilophodonEntity) entity).getVariant().getId();
            }
            if(variantToUseRandom == 4) {
                ((HypsilophodonEntity) entity).setVariant(HypsilophodonVariant.nerd_male);
                entity.setGender(EDDinosaureEntityBase.gender_male);
                entity.variant = ((HypsilophodonEntity) entity).getVariant().getId();
            }
            if(variantToUseRandom == 5) {
                ((HypsilophodonEntity) entity).setVariant(HypsilophodonVariant.nerd_female);
                entity.setGender(EDDinosaureEntityBase.gender_female);
                entity.variant = ((HypsilophodonEntity) entity).getVariant().getId();
            }
        }

        EverbloomDandaloo.LOGGER.info("should spawn as; gender: " + entity.getGender() + "variant" + entity.variant);

        super.SetEntityData(level, entity, spawnAt);
    }

    public HypsilophodonEgg(Properties properties){
        super(properties, 6,0,6, 10, 5, 10, 30, CretaceousEntityTypes.Hypsilophodon, CODEC);
    }
}
