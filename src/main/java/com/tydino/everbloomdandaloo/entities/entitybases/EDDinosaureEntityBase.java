package com.tydino.everbloomdandaloo.entities.entitybases;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.scores.PlayerTeam;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Optional;

//utilize Vanilla: Animal, TameableAnimal, and AgeableMob as basis
public class EDDinosaureEntityBase extends PathfinderMob implements OwnableEntity{

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

    static final EntityDataAccessor<Boolean> SITTING_DOWN = SynchedEntityData.defineId(EDDinosaureEntityBase.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState sittingDownAnimation = new AnimationState();
    int sittingDownCount;
    public boolean getSittingDown(){
        return entityData.get(SITTING_DOWN);
    }
    public void setSittingDown(boolean input){
        entityData.set(SITTING_DOWN, input);
    }
    int maxSittingDownCount;

    static final EntityDataAccessor<Boolean> SITTING = SynchedEntityData.defineId(EDDinosaureEntityBase.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState sittingAnimation = new AnimationState();
    int sittingCount;
    public boolean getSitting(){
        return entityData.get(SITTING);
    }
    public void setSitting(boolean input){
        entityData.set(SITTING, input);
    }
    int maxSittingCount;

    static final EntityDataAccessor<Boolean> STANDING_UP = SynchedEntityData.defineId(EDDinosaureEntityBase.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState standingUpAnimation = new AnimationState();
    int standingUpCount;
    public boolean getStandingUp(){
        return entityData.get(STANDING_UP);
    }
    public void setStandingUp(boolean input){
        entityData.set(STANDING_UP, input);
    }
    int maxStandingUpCount;

    void setUpSitting(){
        if(properlySitting && !getSitting() && !getSittingDown() && !getStandingUp()){
            setSittingDown(true);
            setSitting(false);
            setStandingUp(false);
            sittingDownCount = 0;
            sittingCount = 0;
            standingUpCount = 0;
        }else if(properlySitting && !getSitting() && getSittingDown() && !getStandingUp() && sittingDownCount >= maxSittingDownCount){
            setSittingDown(false);
            setSitting(true);
            setStandingUp(false);
            sittingDownCount = 0;
            sittingCount = 0;
            standingUpCount = 0;
        }else if(!properlySitting && getSitting() && !getSittingDown() && !getStandingUp()){
            setSittingDown(false);
            setSitting(false);
            setStandingUp(true);
            sittingDownCount = 0;
            sittingCount = 0;
            standingUpCount = 0;
        }else if(!properlySitting && !getSitting() && !getSittingDown() && getStandingUp() && standingUpCount >= maxStandingUpCount){
            setSittingDown(false);
            setSitting(false);
            setStandingUp(false);
            sittingDownCount = 0;
            sittingCount = 0;
            standingUpCount = 0;
        }

        if(getSittingDown()){
            if(sittingDownCount == 0){
                sittingDownCount++;
            }else if(sittingDownCount < maxSittingDownCount){
                sittingDownCount++;
            }
        }
        if(getSitting()){
            if(sittingCount < maxSittingCount){
                sittingCount++;
            }else if(sittingCount >= maxSittingCount){
                sittingCount = 0;
            }
            if(sittingCount == 0){
                sittingCount++;
            }
        }
        if(getStandingUp()){
            if(standingUpCount == 0){
                standingUpCount++;
            }else if(standingUpCount < maxStandingUpCount){
                standingUpCount++;
            }
        }
    }

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

    /// TAMING ///
    protected static final EntityDataAccessor<Optional<EntityReference<LivingEntity>>> DATA_OWNERUUID_ID = SynchedEntityData.defineId(EDDinosaureEntityBase.class, EntityDataSerializers.OPTIONAL_LIVING_ENTITY_REFERENCE);
    protected static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(EDDinosaureEntityBase.class, EntityDataSerializers.BYTE);
    public boolean properlyWandering;
    public boolean properlyFollowing;
    public boolean properlySitting;
    public boolean leashable;
    public boolean canBeLeashed() {
        return leashable;
    }
    public int tamingChance;

    /// CONSTRUCTOR ///

    protected EDDinosaureEntityBase(EntityType<? extends PathfinderMob> type, Level level, Item tameItem, int maxAge, int rateOfAging, List<EntityDimensions> dimensions, int LengthOfIdle, int LengthOfBlink, int LengthOfEat, int LengthOfSittingDown, int LengthOfSitting, int LengthOfStandingUp, boolean leashable, int chanceAtTaming) {
        super(type, level);
        this.TameItem = tameItem;
        this.MaxAge = maxAge;
        this.RateOfAging = rateOfAging;
        this.maxIdleCount = LengthOfIdle;
        this.maxBlinkCount = LengthOfBlink;
        this.maxEatCount = LengthOfEat;

        this.maxSittingDownCount = LengthOfSittingDown;
        this.maxSittingCount = LengthOfSitting;
        this.maxStandingUpCount = LengthOfStandingUp;

        this.Dimensions = dimensions;

        this.leashable = leashable;
        this.tamingChance = chanceAtTaming;
    }

    public InteractionResult mobInteract(final Player player, final InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!this.level().isClientSide() && itemStack.is(TameItem) && !isTame()) {
            itemStack.consume(1, player);
            this.tryToTame(player);
            return InteractionResult.SUCCESS_SERVER;
        }else if(isTame()){
            if(properlySitting){
                this.properlyWandering = true;
                this.properlySitting = false;
                this.properlyFollowing = false;

                player.sendOverlayMessage(Component.literal("Wandering"));
                return InteractionResult.SUCCESS_SERVER;
            }
            else if(properlyWandering){
                this.properlyFollowing = true;
                this.properlySitting = false;
                this.properlyWandering = false;

                player.sendOverlayMessage(Component.literal("Following"));
                return InteractionResult.SUCCESS_SERVER;
            }
            else if(properlyFollowing){
                this.properlySitting = true;
                this.properlyWandering = false;
                this.properlyFollowing = false;

                player.sendOverlayMessage(Component.literal("Sitting"));
                return InteractionResult.SUCCESS_SERVER;
            }
        }

        return super.mobInteract(player, hand);
    }

    protected void spawnTamingParticles(final boolean success) {
        ParticleOptions particle = ParticleTypes.HEART;
        if (!success) {
            particle = ParticleTypes.SMOKE;
        }

        for(int i = 0; i < 7; ++i) {
            double xa = this.random.nextGaussian() * 0.02;
            double ya = this.random.nextGaussian() * 0.02;
            double za = this.random.nextGaussian() * 0.02;
            this.level().addParticle(particle, this.getRandomX((double)1.0F), this.getRandomY() + (double)0.5F, this.getRandomZ((double)1.0F), xa, ya, za);
        }

    }

    public void handleEntityEvent(final byte id) {
        if (id == 7) {
            this.spawnTamingParticles(true);
        } else if (id == 6) {
            this.spawnTamingParticles(false);
        } else {
            super.handleEntityEvent(id);
        }

    }

    /// SAVE DATA ///

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder entityData) {
        super.defineSynchedData(entityData);
        //animations
        entityData.define(IDLE, false);
        entityData.define(BLINK, false);
        entityData.define(EAT, false);

        entityData.define(SITTING_DOWN, false);
        entityData.define(SITTING, false);
        entityData.define(STANDING_UP, false);
        //gender
        entityData.define(GENDER, false);
        //age
        entityData.define(AGE, 0);
        entityData.define(AgeTicks, 0);
        //taming
        entityData.define(DATA_OWNERUUID_ID, Optional.empty());
        entityData.define(DATA_FLAGS_ID, (byte)0);
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

        if(updatedItems == SITTING_DOWN){
            sittingDownAnimation.animateWhen(getSittingDown(), this.tickCount);
        }
        if(updatedItems == SITTING){
            sittingAnimation.animateWhen(getSitting(), this.tickCount);
        }
        if(updatedItems == STANDING_UP){
            standingUpAnimation.animateWhen(getStandingUp(), this.tickCount);
        }
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putInt("idle_count", idleCount);
        output.putInt("blink_count", blinkCount);
        output.putInt("eat_count", eatCount);

        output.putInt("sitting_count", sittingDownCount);
        output.putInt("sit_count", sittingCount);
        output.putInt("standing_count", standingUpCount);

        output.putBoolean("sit", properlySitting);
        output.putBoolean("wander", properlyWandering);
        output.putBoolean("follow", properlyFollowing);

        output.putBoolean("gender", getGender());

        output.putInt("age", getAge());
        output.putInt("age_ticks", getAgeTicks());

        EntityReference<LivingEntity> owner = this.getOwnerReference();
        EntityReference.store(owner, output, "Owner");
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

        sittingDownCount = input.getInt("sitting_count").orElse(0);
        sittingCount = input.getInt("sit_count").orElse(0);
        standingUpCount = input.getInt("standing_count").orElse(0);
        setSittingDown(sittingDownCount>0);
        setSitting(sittingCount>0);
        setStandingUp(standingUpCount>0);

        properlySitting = input.getBooleanOr("sit", false);
        properlyWandering = input.getBooleanOr("wander", true);
        properlyFollowing = input.getBooleanOr("follow", false);

        setGender(input.getBooleanOr("gender", false));

        setAge(input.getInt("age").orElse(0));
        setAgeTicks(input.getInt("age_ticks").orElse(0));

        EntityReference<LivingEntity> owner = EntityReference.readWithOldOwnerConversion(input, "Owner", this.level());
        if (owner != null) {
            try {
                this.entityData.set(DATA_OWNERUUID_ID, Optional.of(owner));
                this.setTame(true, false);
            } catch (Throwable var4) {
                this.setTame(false, true);
            }
        } else {
            this.entityData.set(DATA_OWNERUUID_ID, Optional.empty());
            this.setTame(false, true);
        }
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

            setUpSitting();
        }
    }

    @Override
    protected EntityDimensions getDefaultDimensions(Pose pose) {
        return Dimensions.get(getAge());
    }

    /// TAMING ///

    private void tryToTame(final Player player) {
        if (this.random.nextInt(tamingChance) == 0) {
            this.tame(player);
            this.navigation.stop();
            this.setTarget((LivingEntity)null);
            this.level().broadcastEntityEvent(this, (byte)7);
        } else {
            this.level().broadcastEntityEvent(this, (byte)6);
        }

    }

    @Override
    public @Nullable EntityReference<LivingEntity> getOwnerReference() {
        return (EntityReference)((Optional)this.entityData.get(DATA_OWNERUUID_ID)).orElse((Object)null);
    }

    public boolean isTame() {
        return ((Byte)this.entityData.get(DATA_FLAGS_ID) & 4) != 0;
    }

    public void setTame(final boolean isTame, final boolean includeSideEffects) {
        byte current = (Byte)this.entityData.get(DATA_FLAGS_ID);
        if (isTame) {
            this.entityData.set(DATA_FLAGS_ID, (byte)(current | 4));
        } else {
            this.entityData.set(DATA_FLAGS_ID, (byte)(current & -5));
        }

        if (includeSideEffects) {
            this.applyTamingSideEffects();
        }

    }

    protected void applyTamingSideEffects() {
    }

    public void setOwner(final @Nullable LivingEntity owner) {
        this.entityData.set(DATA_OWNERUUID_ID, Optional.ofNullable(owner).map(EntityReference::of));
    }

    public void setOwnerReference(final @Nullable EntityReference<LivingEntity> owner) {
        this.entityData.set(DATA_OWNERUUID_ID, Optional.ofNullable(owner));
    }

    public void tame(final Player player) {
        this.setTame(true, true);
        this.setOwner(player);
        this.properlySitting = true;
        player.sendOverlayMessage(Component.literal("Sitting"));
    }

    public boolean canAttack(final LivingEntity target) {
        return this.isOwnedBy(target) ? false : super.canAttack(target);
    }

    public boolean isOwnedBy(final LivingEntity entity) {
        return entity == this.getOwner();
    }

    public boolean wantsToAttack(final LivingEntity target, final LivingEntity owner) {
        return true;
    }

    public @Nullable PlayerTeam getTeam() {
        PlayerTeam ownTeam = super.getTeam();
        if (ownTeam != null) {
            return ownTeam;
        } else {
            if (this.isTame()) {
                LivingEntity owner = this.getRootOwner();
                if (owner != null) {
                    return owner.getTeam();
                }
            }

            return null;
        }
    }

    protected boolean considersEntityAsAlly(final Entity other) {
        if (this.isTame()) {
            LivingEntity owner = this.getRootOwner();
            if (other == owner) {
                return true;
            }
        }

        return super.considersEntityAsAlly(other);
    }

    public void die(final DamageSource source) {
        Level var3 = this.level();
        if (var3 instanceof ServerLevel serverLevel) {
            if ((Boolean)serverLevel.getGameRules().get(GameRules.SHOW_DEATH_MESSAGES)) {
                LivingEntity var4 = this.getOwner();
                if (var4 instanceof ServerPlayer) {
                    ServerPlayer serverPlayer = (ServerPlayer)var4;
                    serverPlayer.sendSystemMessage(this.getCombatTracker().getDeathMessage());
                }
            }
        }

        super.die(source);
    }

    public final boolean unableToMoveToOwner() {
        return this.getSitting() || this.isPassenger() || this.mayBeLeashed() || this.getOwner() != null && this.getOwner().isSpectator();
    }

    protected boolean canFlyToOwner() {
        return false;
    }
}