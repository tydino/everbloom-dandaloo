package com.tydino.everbloomdandaloo.entities.custom_entity_bases;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.level.Level;

//is to be used whenever a entity flies but will never land

public class FlyingNonLandingEntity extends PathfinderMob implements FlyingAnimal {
    //construction matching super
    protected FlyingNonLandingEntity(EntityType<? extends PathfinderMob> type, Level level) {
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
    public boolean isFlying() {
        return true;
    }
}
