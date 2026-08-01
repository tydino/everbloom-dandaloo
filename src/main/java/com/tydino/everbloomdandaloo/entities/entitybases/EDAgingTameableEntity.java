package com.tydino.everbloomdandaloo.entities.entitybases;


import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

//utilize Vanilla: Animal, TameableAnimal, and AgeableMob as basis
public class EDAgingTameableEntity extends PathfinderMob {

    public Item TameItem;

    ///  ANIMATIONS ///
    static final EntityDataAccessor<Boolean> IDLE = SynchedEntityData.defineId(EDAgingTameableEntity.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState idleAnimation = new AnimationState();
    int idleCount;
    public boolean getIdle(){
        return entityData.get(IDLE);
    }
    public void setIdle(boolean input){
        entityData.set(IDLE, input);
    }

    static final EntityDataAccessor<Boolean> BLINK = SynchedEntityData.defineId(EDAgingTameableEntity.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState blinkAnimation = new AnimationState();
    int blinkCount;
    public boolean getBlink(){
        return entityData.get(IDLE);
    }
    public void setBlink(boolean input){
        entityData.set(IDLE, input);
    }

    /// GENDER
    public static final EntityDataAccessor<Boolean> GENDER =
            SynchedEntityData.defineId(EDAgingTameableEntity.class, EntityDataSerializers.BOOLEAN);
    public static final boolean gender_male = true;
    public static final boolean gender_female = false;
    public boolean getGender(){
        return entityData.get(GENDER);
    }
    public void setGender(boolean input){
        entityData.set(GENDER, input);
    }


    ///  AGE ///
    public static final EntityDataAccessor<Integer> AGE =
            SynchedEntityData.defineId(EDAgingTameableEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> AgeTicks =
            SynchedEntityData.defineId(EDAgingTameableEntity.class, EntityDataSerializers.INT);
    public int getAge(){
        return entityData.get(AGE);
    }
    void setAge(int input){
        entityData.set(AGE, input);
    }
    public int getAgeTicks(){
        return entityData.get(AgeTicks);
    }
    void setAgeTicks(int input){
        entityData.set(AgeTicks, input);
    }

    public int MaxAge;
    public int RateOfAging;

    protected EDAgingTameableEntity(EntityType<? extends PathfinderMob> type, Level level, Item tameItem, int maxAge, int rateOfAging) {
        super(type, level);
        this.TameItem = tameItem;
        this.MaxAge = maxAge;
        this.RateOfAging = rateOfAging;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder entityData) {
        super.defineSynchedData(entityData);
        //aimations
        entityData.define(IDLE, false);
        entityData.define(BLINK, false);
        //gender
        entityData.define(GENDER, false);
        //age
        entityData.define(AGE, 0);
        entityData.define(AgeTicks, 0);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> updatedItems) {
        super.onSyncedDataUpdated(updatedItems);

        if(updatedItems == IDLE){
            idleAnimation.animateWhen(getIdle(), this.tickCount);
        }
        if(updatedItems == BLINK){
            blinkAnimation.animateWhen(getBlink(), this.tickCount);
        }
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putInt("idle_count", idleCount);
        output.putInt("blink_count", blinkCount);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        idleCount = input.getInt("idle_count").orElse(0);
        blinkCount = input.getInt("blink_count").orElse(0);
        setIdle(idleCount>0);
        setBlink(blinkCount>0);
    }

    @Override
    public  SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason spawnReason, SpawnGroupData groupData) {
        return super.finalizeSpawn(level, difficulty, spawnReason, groupData);
    }
}