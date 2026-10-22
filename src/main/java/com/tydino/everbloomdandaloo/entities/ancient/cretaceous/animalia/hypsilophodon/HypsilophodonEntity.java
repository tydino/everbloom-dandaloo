package com.tydino.everbloomdandaloo.entities.ancient.cretaceous.animalia.hypsilophodon;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.blocks.ancient.EDCretaceousBlocks;
import com.tydino.everbloomdandaloo.entities.entitybases.EDDinosaureEntityBase;
import com.tydino.everbloomdandaloo.entities.entitygoals.EDDinosaurEntityGoals;
import com.tydino.everbloomdandaloo.items.ancient.EDCretaceousItems;
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
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class HypsilophodonEntity extends EDDinosaureEntityBase {

    public static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(HypsilophodonEntity.class, EntityDataSerializers.INT);
    public HypsilophodonVariant getVariant(){
        return HypsilophodonVariant.byId(this.getTypeVariant() & 255);
    }
    int getTypeVariant(){
        return this.entityData.get(VARIANT);
    }
    public void setVariant( HypsilophodonVariant variant){
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    public static final List<EntityDimensions> Dimensions = List.of(
            registerDimensions(0.375f, 0.5f, 0.375f), //0 hatchling
            registerDimensions(0.375f, 0.375f, 0.375f), //1 baby
            registerDimensions(0.375f, 0.5f, 0.4375f), //2 baby at 1.25
            registerDimensions(0.375f, 0.5f, 0.4375f), //3 adult at 0.75
            registerDimensions(0.375f, 0.625f, 0.5f), //4 adult at 0.85
            registerDimensions(0.375f, 0.625f, 0.575f), //5 adult at 0.9
            registerDimensions(0.375f, 0.625f, 0.625f) //6 adult at 1
    );

    public HypsilophodonEntity(EntityType<? extends PathfinderMob> type, Level level){
        super(type, level, EDCretaceousItems.SmallScarab, 6, TicksInDay*2, Dimensions, 40, 15, 0, 20, 5, 20, true, 2, 3, 1200);
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
        this.goalSelector.addGoal(2, new EDDinosaurEntityGoals.LayEggGoal(this, 1.5, EDCretaceousBlocks.HypsilophodonEgg));
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
        HypsilophodonVariant variant = HypsilophodonVariant.byId(input.getInt("variant").orElse(0));
        setVariant(variant);
    }

    /// On Spawn ///

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason spawnReason, @Nullable SpawnGroupData groupData) {
        HypsilophodonVariant temp  = Util.getRandom(HypsilophodonVariant.values(), this.random);
        setVariant(temp);
        if(getVariant() == HypsilophodonVariant.mud_female || getVariant() == HypsilophodonVariant.groomed_female || getVariant() == HypsilophodonVariant.nerd_female){
            setGender(gender_female);
        }else{
            setGender(gender_male);
        }

        variant = getVariant().getId();

        EverbloomDandaloo.LOGGER.info("Variant:" + getVariant() + "Gender:" + getGender());
        return super.finalizeSpawn(level, difficulty, spawnReason, groupData);
    }
}
