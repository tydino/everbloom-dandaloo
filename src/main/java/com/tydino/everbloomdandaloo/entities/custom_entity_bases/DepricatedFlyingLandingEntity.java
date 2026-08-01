package com.tydino.everbloomdandaloo.entities.custom_entity_bases;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.Level;

public class DepricatedFlyingLandingEntity extends PathfinderMob{
    boolean flyLastChange = isFlying();

    protected DepricatedFlyingLandingEntity(EntityType<? extends PathfinderMob> type, Level level, int maxTurn, boolean canHoverInPlace) {
        super(type, level);
        this.moveControl = new FlyingMoveControl(this, maxTurn, canHoverInPlace);
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        if(this.isFlying()) {
            FlyingPathNavigation flightNavigation = new FlyingPathNavigation(this, level);
            flightNavigation.setCanOpenDoors(false);
            flightNavigation.setCanFloat(true);
            return flightNavigation;
        }
        return new GroundPathNavigation(this, level);
    }

    public boolean isFlying() {
        return !this.onGround();
    }

    @Override
    public void tick() {
        super.tick();
        if(this.isFlying()!=this.flyLastChange){
            this.flyLastChange = isFlying();
            this.createNavigation(level());
        }
    }
}
