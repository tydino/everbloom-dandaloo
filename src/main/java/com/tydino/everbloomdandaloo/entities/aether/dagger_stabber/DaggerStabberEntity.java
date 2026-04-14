package com.tydino.everbloomdandaloo.entities.aether.dagger_stabber;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.entities.aether.AetherEntityTypes;
import com.tydino.everbloomdandaloo.items.cooking.EDCookingItemRegistry;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import java.util.List;

public class DaggerStabberEntity extends PathfinderMob {

    static final EntityDataAccessor<Boolean> IDLE = SynchedEntityData.defineId(DaggerStabberEntity.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState idleAnimation = new AnimationState();
    int idleCount;

    static final EntityDataAccessor<Boolean> BLINK = SynchedEntityData.defineId(DaggerStabberEntity.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState blinkAnimation = new AnimationState();
    int blinkCount;

    public DaggerStabberEntity(Level world){
        this(AetherEntityTypes.DaggerStabber, world);
    }

    public DaggerStabberEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10)
                .add(Attributes.TEMPT_RANGE, 10)
                .add(Attributes.MOVEMENT_SPEED, 0.2);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new TemptGoal(this, 1, Ingredient.of(EDCookingItemRegistry.Tomato), false));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class,3 ));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder entityData) {
        super.defineSynchedData(entityData);
        entityData.define(IDLE, false);
        entityData.define(BLINK, false);
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

        if (!level().isClientSide()){
            if (isIdle()){
                if(idleCount-- <= 0){
                    setIdle(false);
                }
            }else {
                EverbloomDandaloo.LOGGER.info("idle true");
                setIdle(true);
                idleCount = 20;
            }

            if (isBlink()){
                if(blinkCount-- <= 0){
                    setBlink(false);
                }
            }else {
                if(this.random.nextInt(10)==1) {
                    EverbloomDandaloo.LOGGER.info("blink true");
                    setBlink(true);
                    blinkCount = 15+this.random.nextInt(20);
                }
            }
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

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putInt("idle_count", idleCount);
        output.putInt("blink_count", idleCount);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        idleCount = input.getInt("idle_count").orElse(0);
        idleCount = input.getInt("blink_count").orElse(0);
        setIdle(idleCount>0);
        setBlink(blinkCount>0);
    }
}
