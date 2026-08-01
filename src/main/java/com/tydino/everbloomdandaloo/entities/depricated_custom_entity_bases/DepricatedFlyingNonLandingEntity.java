package com.tydino.everbloomdandaloo.entities.depricated_custom_entity_bases;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.Level;

//is to be used whenever a entity flies but will never land

public class DepricatedFlyingNonLandingEntity extends PathfinderMob {
    //construction matching super
    protected DepricatedFlyingNonLandingEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    /// flying handler ///
    @Override
    protected PathNavigation createNavigation(Level level) {
        FlyingPathNavigation flyingPathNavigation = new FlyingPathNavigation(this, level){
            @Override
            public boolean isStableDestination(final BlockPos pos) {
                return !this.level.getBlockState(pos.below()).isAir();
            }
        };
        flyingPathNavigation.setCanOpenDoors(false);
        flyingPathNavigation.setCanFloat(false);
        flyingPathNavigation.setRequiredPathLength(48.0F);
        return flyingPathNavigation;
    }

    @Override
    public void tick() {
        super.tick();
        if(!this.level().isClientSide()){
            this.fallDistance = 0.0f;
        }
    }

    public boolean isFlying() {
        return true;
    }
}
