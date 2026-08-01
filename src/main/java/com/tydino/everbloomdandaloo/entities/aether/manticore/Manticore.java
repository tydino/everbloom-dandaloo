package com.tydino.everbloomdandaloo.entities.aether.manticore;

import com.tydino.everbloomdandaloo.entities.custom_entity_bases.DepricatedFlyingLandingEntity;
import com.tydino.everbloomdandaloo.entities.custom_goals.flying.DepricatedFlyingGoals;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;

public class Manticore extends DepricatedFlyingLandingEntity implements NeutralMob {
    /// ANIMATION DECLARATION /// MAKE SURE THE ENTITYDATE ACCESSORs ARE SET TO THE RIGHT ENTITY!
    static final EntityDataAccessor<Boolean> IDLE = SynchedEntityData.defineId(Manticore.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState idleAnimation = new AnimationState();
    int idleCount;

    static final EntityDataAccessor<Boolean> BLINK = SynchedEntityData.defineId(Manticore.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState blinkAnimation = new AnimationState();
    int blinkCount;

    static final EntityDataAccessor<Boolean> FLYING = SynchedEntityData.defineId(Manticore.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState flyingAnimation = new AnimationState();

    public final AnimationState AttackAnimation = new AnimationState();
    int attackCount;

    /// RAGE ///
    private static final EntityDataAccessor<Long> DATA_ANGER_END_TIME = SynchedEntityData.defineId(Manticore.class, EntityDataSerializers.LONG);
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 60);
    private EntityReference<LivingEntity> persistentAngerTarget;

    /// REFRENCED IN GAME /// COMMON ISSUE OF IT NOT BEING PUBLIC, MAKE SURE TO DOUBLE CHECK THAT!
    public Manticore(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level, 15, true);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 150)
                .add(Attributes.FLYING_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, 5)
                .add(Attributes.MOVEMENT_SPEED, 0.1);
    }

    /// SELF EXPLANATORIES ///
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5, true));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(3, new DepricatedFlyingGoals.fly(this, 12, 15, 1, 5));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    @Override
    public void tick() {
        super.tick();

        if (!level().isClientSide()){//NOT CLIENT - IS SERVER
            if (isIdle()){
                if(idleCount-- <= 0){
                    setIdle(false);
                }
            }else {
                setIdle(true);
                idleCount = 40;
            }

            if (isBlink()){
                if(blinkCount-- <= 0){
                    setBlink(false);
                }
            }else {
                setBlink(true);
                blinkCount = 40+ random.nextInt(20, 40);
            }

            if(isFlying()){
                flyingAnimation.startIfStopped(this.tickCount);
            }else{
                flyingAnimation.stop();
            }
            this.AttackAnimation.animateWhen(this.attackCount > 0, this.tickCount);
        }
    }

    /// SAVED DATA ///
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder entityData) {
        super.defineSynchedData(entityData);
        entityData.define(IDLE, false);
        entityData.define(BLINK, false);
        entityData.define(FLYING, false);
        entityData.define(DATA_ANGER_END_TIME, -1L);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> updatedItems) {
        super.onSyncedDataUpdated(updatedItems);

        if(updatedItems == IDLE){
            idleAnimation.animateWhen(isIdle(), this.tickCount);
        }
        if(updatedItems == BLINK){
            blinkAnimation.animateWhen(isBlink(), this.tickCount);
        }
        if(updatedItems == FLYING){
            flyingAnimation.animateWhen(isFly(), this.tickCount);
        }
    }

    public boolean isIdle(){
        return entityData.get(IDLE);
    }

    void setIdle(boolean idle){
        entityData.set(IDLE, idle);
    }

    public boolean isBlink(){
        return entityData.get(BLINK);
    }

    void setBlink(boolean blink){
        entityData.set(BLINK, blink);
    }

    public boolean isFly(){
        return entityData.get(FLYING);
    }

    void setFly(boolean fly){
        entityData.set(FLYING, fly);
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putInt("flap_count", idleCount);
        output.putInt("blink_count", blinkCount);
        this.addPersistentAngerSaveData(output);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        idleCount = input.getInt("flap_count").orElse(0);
        blinkCount = input.getInt("blink_count").orElse(0);
        setIdle(idleCount>0);
        setBlink(blinkCount>0);
        this.readPersistentAngerSaveData(this.level(), input);
    }

    /// ATTACK ///

    @Override
    public long getPersistentAngerEndTime() {return this.entityData.get(DATA_ANGER_END_TIME);}

    @Override
    public void setPersistentAngerEndTime(long endTime) {this.entityData.set(DATA_ANGER_END_TIME, endTime);}

    @Override
    public @Nullable EntityReference<LivingEntity> getPersistentAngerTarget() {return this.persistentAngerTarget;}

    @Override
    public void setPersistentAngerTarget(@Nullable EntityReference<LivingEntity> persistentAngerTarget) {this.persistentAngerTarget = persistentAngerTarget;}

    @Override
    public void startPersistentAngerTimer() {this.setTimeToRemainAngry(PERSISTENT_ANGER_TIME.sample(this.random));}

    @Override
    public boolean doHurtTarget(ServerLevel level, Entity target) {
        if (!(target instanceof LivingEntity)) {
            return false;
        } else {
            this.attackCount = 20;
            this.level().broadcastEntityEvent(this, (byte)4);
            return super.doHurtTarget(level, target);
        }
    }

    @Override
    public void handleEntityEvent(byte id) {
        if(id==4){
            this.attackCount = 20;
            this.playAttackSound();
        }
        super.handleEntityEvent(id);
    }
}
