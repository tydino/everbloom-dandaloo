package com.tydino.everbloomdandaloo.entities.entitygoals;

import com.tydino.everbloomdandaloo.entities.entitybases.EDDinosaureEntityBase;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

import java.util.EnumSet;

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

    public static class FollowOwner extends Goal{
        private final EDDinosaureEntityBase tamable;
        private @Nullable LivingEntity owner;
        private final double speedModifier;
        private final PathNavigation navigation;
        private int timeToRecalcPath;
        private final float stopDistance;
        private final float startDistance;
        private float oldWaterCost;

        public FollowOwner(final EDDinosaureEntityBase tamable, final double speedModifier, final float startDistance, final float stopDistance) {
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
}
