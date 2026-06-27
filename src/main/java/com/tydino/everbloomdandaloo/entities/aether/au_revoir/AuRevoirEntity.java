package com.tydino.everbloomdandaloo.entities.aether.au_revoir;

import com.tydino.everbloomdandaloo.entities.custom_entity_bases.FlyingNonLandingEntity;
import com.tydino.everbloomdandaloo.entities.custom_goals.flying.FlyingGoals;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class AuRevoirEntity extends FlyingNonLandingEntity {

    /// ANIMATION DECLARATION /// MAKE SURE THE ENTITYDATE ACCESSORs ARE SET TO THE RIGHT ENTITY!
    static final EntityDataAccessor<Boolean> FLAP = SynchedEntityData.defineId(AuRevoirEntity.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState flapAnimation = new AnimationState();
    int flapCount;

    static final EntityDataAccessor<Boolean> BLINK = SynchedEntityData.defineId(AuRevoirEntity.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState blinkAnimation = new AnimationState();
    int blinkCount;

    /// REFRENCED IN GAME /// COMMON ISSUE OF IT NOT BEING PUBLIC, MAKE SURE TO DOUBLE CHECK THAT!
    public AuRevoirEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.moveControl = new FlyingMoveControl(this, 10, true);
    }

    /// SELF EXPLANATORIES ///
    public static AttributeSupplier.Builder createAttributes(){
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.FLYING_SPEED, 0.2)
                .add(Attributes.MOVEMENT_SPEED, 0.05);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FlyingGoals.wander(this, 8, 6, 1, 3));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class,5 ));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    @Override
    public void tick() {
        super.tick();

        if (!level().isClientSide()){//NOT CLIENT - IS SERVER
            if (isFlap()){
                if(flapCount-- <= 0){
                    setFlap(false);
                }
            }else {
                setFlap(true);
                flapCount = 20;
            }

            if (isBlink()){
                if(blinkCount-- <= 0){
                    setBlink(false);
                }
            }else {
                setBlink(true);
                blinkCount = 40+ random.nextInt(20, 40);
            }
        }
    }

    /// SAVED DATA ///
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder entityData) {
        super.defineSynchedData(entityData);
        entityData.define(FLAP, false);
        entityData.define(BLINK, false);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> updatedItems) {
        super.onSyncedDataUpdated(updatedItems);

        if(updatedItems == FLAP){
            flapAnimation.animateWhen(isFlap(), this.tickCount);
        }
        if(updatedItems == BLINK){
            blinkAnimation.animateWhen(isBlink(), this.tickCount);
        }
    }

    public boolean isFlap(){
        return entityData.get(FLAP);
    }

    void setFlap(boolean flap){
        entityData.set(FLAP, flap);
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
        output.putInt("flap_count", flapCount);
        output.putInt("blink_count", blinkCount);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        flapCount = input.getInt("flap_count").orElse(0);
        blinkCount = input.getInt("blink_count").orElse(0);
        setFlap(flapCount>0);
        setBlink(blinkCount>0);
    }

    @Override
    public boolean canBeLeashed() {
        return false;
    }
}
