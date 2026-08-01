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

import java.util.List;

//utilize Vanilla: Animal, TameableAnimal, and AgeableMob as basis
public class EDDinosaureEntityBase extends PathfinderMob {

    List<EntityDimensions> Dimensions;

    public static final int TicksInDay = 24000;///24000/20 is 1200, 1200/60 is 20. 20 minutes long

    public Item TameItem;

    ///  ANIMATIONS ///
    static final EntityDataAccessor<Boolean> IDLE = SynchedEntityData.defineId(EDDinosaureEntityBase.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState idleAnimation = new AnimationState();
    int idleCount;
    public boolean getIdle(){
        return entityData.get(IDLE);
    }
    public void setIdle(boolean input){
        entityData.set(IDLE, input);
    }
    int maxIdleCount;

    static final EntityDataAccessor<Boolean> BLINK = SynchedEntityData.defineId(EDDinosaureEntityBase.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState blinkAnimation = new AnimationState();
    int blinkCount;
    public boolean getBlink(){
        return entityData.get(IDLE);
    }
    public void setBlink(boolean input){
        entityData.set(IDLE, input);
    }
    int maxBlinkCount;

    static final EntityDataAccessor<Boolean> EAT = SynchedEntityData.defineId(EDDinosaureEntityBase.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState eatAnimation = new AnimationState();
    int eatCount;
    public boolean getEat(){
        return entityData.get(IDLE);
    }
    public void setEat(boolean input){
        entityData.set(IDLE, input);
    }
    int maxEatCount;

    /// GENDER
    public static final EntityDataAccessor<Boolean> GENDER =
            SynchedEntityData.defineId(EDDinosaureEntityBase.class, EntityDataSerializers.BOOLEAN);
    public static final boolean gender_male = true;
    public static final boolean gender_female = false;
    public boolean getGender(){
        return entityData.get(GENDER);
    }
    public void setGender(boolean input){
        entityData.set(GENDER, input);
    }


    ///  AGE ///
    public static List<EntityDimensions> AgeDimensions;
    public static final EntityDataAccessor<Integer> AGE =
            SynchedEntityData.defineId(EDDinosaureEntityBase.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> AgeTicks =
            SynchedEntityData.defineId(EDDinosaureEntityBase.class, EntityDataSerializers.INT);
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

    /// CONSTRUCTOR

    protected EDDinosaureEntityBase(EntityType<? extends PathfinderMob> type, Level level, Item tameItem, int maxAge, int rateOfAging, List<EntityDimensions> dimensions, int LengthOfIdle, int LengthOfBlink, int LengthOfEat) {
        super(type, level);
        this.TameItem = tameItem;
        this.MaxAge = maxAge;
        this.RateOfAging = rateOfAging;
        this.maxIdleCount = LengthOfIdle;
        this.maxBlinkCount = LengthOfBlink;
        this.maxEatCount = LengthOfEat;
        this.Dimensions = dimensions;
    }

    /// SAVE DATA ///

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder entityData) {
        super.defineSynchedData(entityData);
        //aimations
        entityData.define(IDLE, false);
        entityData.define(BLINK, false);
        entityData.define(EAT, false);
        //gender
        entityData.define(GENDER, false);
        //age
        entityData.define(AGE, 0);
        entityData.define(AgeTicks, 0);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> updatedItems) {
        super.onSyncedDataUpdated(updatedItems);
        if(updatedItems == AGE){
            this.refreshDimensions();
        }

        if(updatedItems == IDLE){
            idleAnimation.animateWhen(getIdle(), this.tickCount);
        }
        if(updatedItems == BLINK){
            blinkAnimation.animateWhen(getBlink(), this.tickCount);
        }
        if(updatedItems == EAT){
            eatAnimation.animateWhen(getEat(), this.tickCount);
        }
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putInt("idle_count", idleCount);
        output.putInt("blink_count", blinkCount);
        output.putInt("eat_count", eatCount);

        output.putBoolean("gender", getGender());

        output.putInt("age", getAge());
        output.putInt("age_ticks", getAgeTicks());
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        idleCount = input.getInt("idle_count").orElse(0);
        blinkCount = input.getInt("blink_count").orElse(0);
        eatCount = input.getInt("eat_count").orElse(0);
        setIdle(idleCount>0);
        setBlink(blinkCount>0);
        setEat(eatCount>0);

        setGender(input.getBooleanOr("gender", false));

        setAge(input.getInt("age").orElse(0));
        setAgeTicks(input.getInt("age_ticks").orElse(0));
    }

    /// On Spawn ///

    @Override
    public  SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason spawnReason, SpawnGroupData groupData) {
        return super.finalizeSpawn(level, difficulty, spawnReason, groupData);
    }

    /// TICKS ///
    ///
    @Override
    public void tick() {
        super.tick();
        if(!level().isClientSide()){

            /// AGE ///
            if(MaxAge > getAge()){
                setAgeTicks(getAgeTicks() + 1);
                if(getAgeTicks() >= RateOfAging){
                    setAgeTicks(0);
                    setAge(getAge() + 1);
                }
            }

            /// ANIMATIONS ///
            if (getIdle()){
                if(idleCount-- <= 0){
                    setIdle(false);
                }
            }else {
                setIdle(true);
                idleCount = maxIdleCount;
            }

            if (getBlink()){
                if(blinkCount-- <= 0){
                    setBlink(false);
                }
            }else {
                setBlink(true);
                blinkCount = maxBlinkCount+ random.nextInt(20, 100);
            }

            if (getEat()){
                if(eatCount-- <= 0){
                    setEat(false);
                }
            }else {
                setEat(true);
                eatCount = maxEatCount;
            }
        }
    }

    @Override
    protected EntityDimensions getDefaultDimensions(Pose pose) {
        return Dimensions.get(getAge());
    }
}