package com.tydino.everbloomdandaloo.entities.ancient.jurassic;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.entities.entitybases.EDDinosaureEntityBase;
import com.tydino.everbloomdandaloo.items.ancient.EDJurassicItems;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Util;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;

public class BrachiosaurusEntity extends EDDinosaureEntityBase {

    public static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(BrachiosaurusEntity.class, EntityDataSerializers.INT);
    public BrachiosaurusVariant getVariant(){
        return BrachiosaurusVariant.byId(this.getTypeVariant() & 255);
    }
    int getTypeVariant(){
        return this.entityData.get(VARIANT);
    }
    public void setVariant( BrachiosaurusVariant variant){
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    /// Constructors
    public BrachiosaurusEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level, EDJurassicItems.BigScarab, 9, 100/*TicksInDay * 2*/, EverbloomDandaloo.Dimensions.Ancient.Jurassic.BrachiosaurusDimensions,20, 20, 80, 40, 40, 40, true, 3);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return PathfinderMob.createMobAttributes()
                .add(Attributes.SCALE, 1)
                .add(Attributes.MAX_HEALTH, 200)
                .add(Attributes.TEMPT_RANGE, 10)
                .add(Attributes.MOVEMENT_SPEED, 0.1);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class,15 ));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    /// SAVE DATA ///

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder entityData) {
        super.defineSynchedData(entityData);

        entityData.define(VARIANT, 1);
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putInt("variant", this.getTypeVariant());
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        BrachiosaurusVariant variant = BrachiosaurusVariant.byId(input.getInt("variant").orElse(0));
        setVariant(variant);
    }

    /// On Spawn ///

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason spawnReason, @Nullable SpawnGroupData groupData) {
        BrachiosaurusVariant variant  = Util.getRandom(BrachiosaurusVariant.values(), this.random);
        setVariant(variant);
        if(getVariant() == BrachiosaurusVariant.banana_female || getVariant() == BrachiosaurusVariant.movie_female){
            setGender(gender_female);
        }else{
            setGender(gender_male);
        }

        EverbloomDandaloo.LOGGER.info("Variant:" + getVariant() + "Gender:" + getGender());
        return super.finalizeSpawn(level, difficulty, spawnReason, groupData);
    }
}
