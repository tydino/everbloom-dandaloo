package com.tydino.everbloomdandaloo.entities.entitygoals;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.blocks.ancient.DinosaurEgg;
import com.tydino.everbloomdandaloo.entities.entitybases.EDDinosaureEntityBase;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;

public class EDDinosaurEntityGoals {

    public static class WanderFarGoal extends Goal {
        public static final int DEFAULT_INTERVAL = 120;
        protected final EDDinosaureEntityBase mob;
        protected double wantedX;
        protected double wantedY;
        protected double wantedZ;
        protected final double speedModifier;
        protected int interval;
        protected boolean forceTrigger;
        private final boolean checkNoActionTime;
        protected float distance;

        public WanderFarGoal(final EDDinosaureEntityBase mob, final double speedModifier, float distanceForFollow) {
            this(mob, speedModifier, 120, distanceForFollow);
        }

        public WanderFarGoal(final EDDinosaureEntityBase mob, final double speedModifier, final int interval, float distanceForFollow) {
            this(mob, speedModifier, interval, true, distanceForFollow);
        }

        public WanderFarGoal(final EDDinosaureEntityBase mob, final double speedModifier, final int interval, final boolean checkNoActionTime, float distanceForFollow) {
            this.mob = mob;
            this.speedModifier = speedModifier;
            this.interval = interval;
            this.checkNoActionTime = checkNoActionTime;
            this.setFlags(EnumSet.of(Flag.MOVE));
            this.distance = distanceForFollow;
        }

        public boolean canUse() {
            if(mob.properlySitting){
                return false;
            }
            if(this.mob.getOwner() != null) {
                if (mob.properlyFollowing && this.mob.distanceToSqr(this.mob.getOwner()) >= (double) (this.distance * this.distance)) {
                    return false;
                }
            }
            if (this.mob.hasControllingPassenger()) {
                return false;
            } else {
                if (!this.forceTrigger) {
                    if (this.checkNoActionTime && this.mob.getNoActionTime() >= 100) {
                        return false;
                    }

                    if (this.mob.getRandom().nextInt(reducedTickDelay(this.interval)) != 0) {
                        return false;
                    }
                }

                Vec3 pos = this.getPosition();
                if (pos == null) {
                    return false;
                } else {
                    this.wantedX = pos.x;
                    this.wantedY = pos.y;
                    this.wantedZ = pos.z;
                    this.forceTrigger = false;
                    return true;
                }
            }
        }

        protected @Nullable Vec3 getPosition() {
            return DefaultRandomPos.getPos(this.mob, 10, 7);
        }

        public boolean canContinueToUse() {
            return !this.mob.getNavigation().isDone() && !this.mob.hasControllingPassenger();
        }

        public void start() {
            this.mob.getNavigation().moveTo(this.wantedX, this.wantedY, this.wantedZ, this.speedModifier);
        }

        public void stop() {
            this.mob.getNavigation().stop();
            super.stop();
        }

        public void trigger() {
            this.forceTrigger = true;
        }

        public void setInterval(final int interval) {
            this.interval = interval;
        }
    }

    public static class FollowOwnerGoal extends Goal{
        private final EDDinosaureEntityBase tamable;
        private @Nullable LivingEntity owner;
        private final double speedModifier;
        private final PathNavigation navigation;
        private int timeToRecalcPath;
        private final float stopDistance;
        private final float startDistance;
        private float oldWaterCost;

        public FollowOwnerGoal(final EDDinosaureEntityBase tamable, final double speedModifier, final float startDistance, final float stopDistance) {
            this.tamable = tamable;
            this.speedModifier = speedModifier;
            this.navigation = tamable.getNavigation();
            this.startDistance = startDistance;
            this.stopDistance = stopDistance;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
            if (!(tamable.getNavigation() instanceof GroundPathNavigation) && !(tamable.getNavigation() instanceof FlyingPathNavigation)) {
                throw new IllegalArgumentException("Unsupported mob type for FollowOwnerGoal");
            }
        }

        public boolean canUse() {
            LivingEntity owner = this.tamable.getOwner();
            if (owner == null) {
                return false;
            } else if (this.tamable.unableToMoveToOwner()) {
                return false;
            } else if (this.tamable.distanceToSqr(owner) < (double)(this.startDistance * this.startDistance)) {
                return false;
            } else {
                this.owner = owner;
                if(tamable.properlyFollowing) {
                    return true;
                }else{
                    return false;
                }
            }
        }

        public boolean canContinueToUse() {
            if (this.navigation.isDone()) {
                return false;
            } else if (this.tamable.unableToMoveToOwner()) {
                return false;
            } else {
                return !(this.tamable.distanceToSqr(this.owner) <= (double)(this.stopDistance * this.stopDistance));
            }
        }

        public void start() {
            this.timeToRecalcPath = 0;
            this.oldWaterCost = this.tamable.getPathfindingMalus(PathType.WATER);
            this.tamable.setPathfindingMalus(PathType.WATER, 0.0F);
        }

        public void stop() {
            this.owner = null;
            this.navigation.stop();
            this.tamable.setPathfindingMalus(PathType.WATER, this.oldWaterCost);
        }

        public void tick() {
            this.tamable.getLookControl().setLookAt(this.owner, 10.0F, (float)this.tamable.getMaxHeadXRot());

            if (--this.timeToRecalcPath <= 0) {
                this.timeToRecalcPath = this.adjustedTickDelay(10);

                this.navigation.moveTo(this.owner, this.speedModifier);
            }
        }
    }

    public static class BreedGoal extends Goal{
        static final TargetingConditions PARTNER_TARGETING = TargetingConditions.forNonCombat().range(8.0F).ignoreLineOfSight();
        protected EDDinosaureEntityBase entity;
        final Class<? extends EDDinosaureEntityBase> partnerClass;
        protected final ServerLevel level;
        protected EDDinosaureEntityBase partner;
        private int loveTime;
        final double speedModifier;

        public BreedGoal(EDDinosaureEntityBase entity, double speedModifier){
            this(entity, speedModifier, entity.getClass());
        }

        public BreedGoal(EDDinosaureEntityBase entity, double speedModifier, Class<? extends EDDinosaureEntityBase> clazz){
            this.entity = entity;
            this.level = getServerLevel(entity);
            this.partnerClass = clazz;
            this.speedModifier = speedModifier;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        public boolean canUse() {
            if (!this.entity.inLove()) {
                return false;
            } else {
                this.partner = this.getFreePartner();
                return this.partner != null;
            }
        }

        public boolean canContinueToUse() {
            return this.partner.isAlive() && this.partner.inLove() && this.loveTime < 60 && !this.partner.isPanicking();
        }

        public void stop() {
            this.partner = null;
            this.loveTime = 0;
        }

        public void tick() {
            this.entity.getLookControl().setLookAt(this.partner, 10.0F, (float)this.entity.getMaxHeadXRot());
            this.entity.getNavigation().moveTo(this.partner, this.speedModifier);
            ++this.loveTime;
            if (this.loveTime >= this.adjustedTickDelay(60) && this.entity.distanceToSqr(this.partner) < (double)9.0F && entity.getGender() == EDDinosaureEntityBase.gender_female) {
                this.breed();
            }
        }

        private @Nullable EDDinosaureEntityBase getFreePartner() {
            List<? extends EDDinosaureEntityBase> animals = this.level.getNearbyEntities(this.partnerClass, PARTNER_TARGETING, this.entity, this.entity.getBoundingBox().inflate((double)10.0F));
            double dist = Double.MAX_VALUE;
            EDDinosaureEntityBase partner = null;

            for(EDDinosaureEntityBase potentialPartner : animals) {
                if(potentialPartner.getGender() != entity.getGender()) {
                    if (this.entity.canMate(potentialPartner) && !potentialPartner.isPanicking() && this.entity.distanceToSqr(potentialPartner) < dist) {
                        partner = potentialPartner;
                        dist = this.entity.distanceToSqr(potentialPartner);
                    }
                }
            }

            return partner;
        }

        void breed(){
            ServerPlayer LoveCause = this.entity.getLoveCause();
            if (LoveCause == null && this.partner.getLoveCause() != null) {
                LoveCause = this.partner.getLoveCause();
            }

            if (LoveCause != null) {
                LoveCause.awardStat(Stats.ANIMALS_BRED);
            }

            this.entity.partnerVariant = partner.variant;
            this.entity.setHasEgg(true);
            this.entity.resetLove();
            this.partner.resetLove();
            RandomSource random = this.entity.getRandom();
            if (getServerLevel(this.level).getGameRules().get(GameRules.MOB_DROPS)) {
                this.level.addFreshEntity(new ExperienceOrb(this.level, this.entity.getX(), this.entity.getY(), this.entity.getZ(), random.nextInt(15) + 1));
            }
        }
    }

    public static class LayEggGoal extends MoveToBlockGoal {
        private final EDDinosaureEntityBase entity;
        Block Egg;

        public LayEggGoal(final EDDinosaureEntityBase entity, final double speedModifier, Block egg) {
            super(entity, speedModifier, 16);
            this.entity = entity;
            Egg = egg;
        }

        public boolean canUse() {
            return this.entity.canLayEgg();
        }

        public boolean canContinueToUse() {
            return super.canContinueToUse() && entity.canLayEgg();
        }

        @Override
        public void start() {
            super.start();
            BlockPos entityPos = this.entity.blockPosition();
            EverbloomDandaloo.LOGGER.info("REMINDER: SET THIS SO THAT THEY NEED NEST BLOCK, add variant to egg as well.");
            Level level = entity.level();
            BlockState eggState = Egg.defaultBlockState().setValue(DinosaurEgg.HasParents, true).setValue(DinosaurEgg.ParentVariantFather, entity.partnerVariant).setValue(DinosaurEgg.ParentVariantMother, entity.variant);
            level.playSound(null, entityPos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + level.getRandom().nextFloat() * 0.2F);
            level.setBlock(entity.getOnPos().above(), eggState, 3);
            level.gameEvent(GameEvent.BLOCK_PLACE, blockPos.above(), GameEvent.Context.of(entity, eggState));
            entity.setHasEgg(false);
        }

        protected boolean isValidTarget(final LevelReader level, final BlockPos pos) {
            return level.isEmptyBlock(pos);
        }
    }
}
