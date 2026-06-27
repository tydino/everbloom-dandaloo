package com.tydino.everbloomdandaloo.entities.aether.dagger_stabber;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.entities.aether.AetherEntityTypes;
import com.tydino.everbloomdandaloo.entities.aether.EDAetherEntitySounds;
import com.tydino.everbloomdandaloo.items.cooking.EDCookingItemRegistry;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;

//NEVER USE DaggerStabberEntity as a direct reference. Au Revoir is sorted as an example

public class DaggerStabberEntity extends PathfinderMob implements NeutralMob {

    private static final EntityDataAccessor<Long> DATA_ANGER_END_TIME = SynchedEntityData.defineId(DaggerStabberEntity.class, EntityDataSerializers.LONG);
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 60);
    private EntityReference<LivingEntity> persistentAngerTarget;

    static final EntityDataAccessor<Boolean> IDLE = SynchedEntityData.defineId(DaggerStabberEntity.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState idleAnimation = new AnimationState();
    int idleCount;

    static final EntityDataAccessor<Boolean> BLINK = SynchedEntityData.defineId(DaggerStabberEntity.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState blinkAnimation = new AnimationState();
    int blinkCount;

    public final AnimationState StabAnimation = new AnimationState();
    int StabCount;

    public DaggerStabberEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10)
                .add(Attributes.TEMPT_RANGE, 10)
                .add(Attributes.ATTACK_DAMAGE, 3)
                .add(Attributes.MOVEMENT_SPEED, 0.15);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5, true));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1, Ingredient.of(EDCookingItemRegistry.Tomato), false));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class,3 ));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, 10, true, false, this::isAngryAt));
        this.targetSelector.addGoal(3, new ResetUniversalAngerTargetGoal<>(this, true));
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder entityData) {
        super.defineSynchedData(entityData);
        entityData.define(IDLE, false);
        entityData.define(BLINK, false);
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
                idleCount = 20;
            }

            if (isBlink()){
                if(blinkCount-- <= 0){
                    setBlink(false);
                }
            }else {
                setBlink(true);
                blinkCount = 40+ random.nextInt(20, 40);
            }

            this.StabAnimation.animateWhen(this.StabCount > 0, this.tickCount);
        }
    }

    @Override
    public void aiStep() {
        if(this.StabCount > 0){
            StabCount--;
        }
        super.aiStep();
    }

    @Override
    public boolean doHurtTarget(ServerLevel level, Entity target) {
        if (!(target instanceof LivingEntity)) {
            return false;
        } else {
            this.StabCount = 20;
            this.level().broadcastEntityEvent(this, (byte)4);
            return super.doHurtTarget(level, target);
        }
    }

    @Override
    public void handleEntityEvent(byte id) {
        if(id==4){
            this.StabCount = 20;
            this.playAttackSound();
        }
        super.handleEntityEvent(id);
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

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putInt("idle_count", idleCount);
        output.putInt("blink_count", blinkCount);
        this.addPersistentAngerSaveData(output);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        idleCount = input.getInt("idle_count").orElse(0);
        blinkCount = input.getInt("blink_count").orElse(0);
        setIdle(idleCount>0);
        setBlink(blinkCount>0);
        this.readPersistentAngerSaveData(this.level(), input);
    }

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
    protected @Nullable SoundEvent getAmbientSound() {
        return EDAetherEntitySounds.DaggerStabber_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return EDAetherEntitySounds.DaggerStabber_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return EDAetherEntitySounds.DaggerStabber_DEATH;
    }

    @Override
    protected void playAttackSound() {
        float pitchForAttackSound = (float)this.random.nextInt(25, 100)/10;
        this.playSound(EDAetherEntitySounds.DaggerStabber_ATTACK, 1.0f, pitchForAttackSound);
    }
}
