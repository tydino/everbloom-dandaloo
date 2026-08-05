package com.tydino.everbloomdandaloo.entities.ancient.jurassic;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.blocks.ancient.EDJurassicBlocks;
import com.tydino.everbloomdandaloo.entities.entitybases.EDDinosaureEntityBase;
import com.tydino.everbloomdandaloo.entities.entitygoals.EDDinosaurEntityGoals;
import com.tydino.everbloomdandaloo.items.ancient.EDJurassicItems;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Util;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;

import java.util.List;

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

    public static final List<EntityDimensions> BrachiosaurusDimensions = List.of(
            registerDimensions(0.5f, 1.5f, 1.4f),// 0
            registerDimensions(0.5f, 1.4f, 1.3f),// 1
            registerDimensions(0.7f, 1.6f, 1.5f),// 2
            registerDimensions(1f, 2.8f, 6.3f),// 3
            registerDimensions(1.25f, 3.5f, 7.875f),// 4
            registerDimensions(1.5f, 4.2f, 9.45f),// 5
            registerDimensions(1.75f, 4.9f, 11.025f),// 6
            registerDimensions(2f, 5.6f, 12.6f),// 7
            registerDimensions(2.25f, 6.3f, 14.175f),// 8
            registerDimensions(2.5f, 7f, 15.75f));// 9

    /// Constructors
    public BrachiosaurusEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level, EDJurassicItems.BigScarab, 9, 500/*TicksInDay * 2*/, BrachiosaurusDimensions,20, 20, 80, 40, 40, 40, true, 3, 1, 1200);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return PathfinderMob.createMobAttributes()
                .add(Attributes.SCALE, 1)
                .add(Attributes.MAX_HEALTH, 200)
                .add(Attributes.TEMPT_RANGE, 10)
                .add(Attributes.MOVEMENT_SPEED, 0.09);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.05));
        this.goalSelector.addGoal(2, new EDDinosaurEntityGoals.LayEggGoal(this, 1.5, EDJurassicBlocks.BrachiosaurusEgg));
        this.goalSelector.addGoal(2, new EDDinosaurEntityGoals.BreedGoal(this, 1));
        this.goalSelector.addGoal(3, new EDDinosaurEntityGoals.WanderFarGoal(this, 1, 2f));
        this.goalSelector.addGoal(4, new EDDinosaurEntityGoals.FollowOwnerGoal(this, 1.3, 5, 2));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class,15 ));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
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
        BrachiosaurusVariant temp  = Util.getRandom(BrachiosaurusVariant.values(), this.random);
        setVariant(temp);
        if(getVariant() == BrachiosaurusVariant.banana_female || getVariant() == BrachiosaurusVariant.movie_female){
            setGender(gender_female);
        }else{
            setGender(gender_male);
        }

        variant = getVariant().getId();

        EverbloomDandaloo.LOGGER.info("Variant:" + getVariant() + "Gender:" + getGender());
        return super.finalizeSpawn(level, difficulty, spawnReason, groupData);
    }
}
