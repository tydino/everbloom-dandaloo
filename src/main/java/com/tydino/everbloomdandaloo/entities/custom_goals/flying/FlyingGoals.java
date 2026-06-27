package com.tydino.everbloomdandaloo.entities.custom_goals.flying;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.bee.Bee;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

import java.util.EnumSet;
import java.util.Objects;

public class FlyingGoals {

    public static class wander extends Goal {
        public PathfinderMob mob;
        public int horizontalDistance;
        public int verticalDistance;
        public int hoverMin;
        public int hoverMax;


        public wander(PathfinderMob mob, int horizontalDistance, int verticalDistance, int hoverMin, int hoverMax) {
            super();
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
            this.mob = mob;
            this.horizontalDistance = horizontalDistance;
            this.verticalDistance = verticalDistance;
            this.hoverMin = hoverMin;
            this.hoverMax = hoverMax;
        }

        @Override
        public boolean canUse() {
            return this.mob.getNavigation().isDone() && mob.getRandom().nextInt(10) == 0;
        }

        @Override
        public boolean canContinueToUse() {
            return mob.getNavigation().isInProgress();
        }

        @Override
        public void start() {
            Vec3 targetPos = this.findPos();
            if (targetPos != null) {
                mob.getNavigation().moveTo(mob.getNavigation().createPath(BlockPos.containing(targetPos), 1), 1.0);
            }
        }

        @Nullable
        private Vec3 findPos() {
            Vec3 wanderDirection;
            wanderDirection = mob.getViewVector(0.0F);

            int xzDist = 8;
            Vec3 groundBasedPosition = HoverRandomPos.getPos(mob, horizontalDistance, verticalDistance, wanderDirection.x, wanderDirection.z, (float) (Math.PI / 2), hoverMax, hoverMin);
            return groundBasedPosition != null
                    ? groundBasedPosition
                    : AirAndWaterRandomPos.getPos(mob, horizontalDistance, verticalDistance, -2, wanderDirection.x, wanderDirection.z, (float) (Math.PI / 2));
        }
    }
}
