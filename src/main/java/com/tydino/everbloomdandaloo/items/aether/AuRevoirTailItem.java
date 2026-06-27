package com.tydino.everbloomdandaloo.items.aether;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class AuRevoirTailItem extends Item {
    final double maxReach = 20.0;// this is the max reach for the item.

    public AuRevoirTailItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if(level.isClientSide()) {
            return InteractionResult.PASS;
        }

        Vec3 eyePosition = player.getEyePosition(1.0f);
        Vec3 lookVector = player.getViewVector(1.0f);
        Vec3 endPosition = eyePosition.add(lookVector.scale(maxReach));

        BlockHitResult hitResult = level.clip(new ClipContext(
                eyePosition,
                endPosition,
                ClipContext.Block.OUTLINE,
                ClipContext.Fluid.NONE,
                player
        ));

        if(hitResult.getType() == HitResult.Type.BLOCK){

            BlockPos blockPos = hitResult.getBlockPos();

            //something simmilar to this can be used for the travel to the aether!
            player.teleportTo(blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5);

            player.getCooldowns().addCooldown(player.getItemInHand(player.getUsedItemHand()), 20);

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
