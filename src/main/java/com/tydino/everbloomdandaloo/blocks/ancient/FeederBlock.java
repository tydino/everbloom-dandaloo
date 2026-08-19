package com.tydino.everbloomdandaloo.blocks.ancient;

import com.mojang.serialization.MapCodec;
import com.tydino.everbloomdandaloo.blockentities.ancient.FeederBlockEntity;
import com.tydino.everbloomdandaloo.stats.ancient.EDAncientStats;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BarrelBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

public class FeederBlock extends BaseEntityBlock {
    public static final VoxelShape SHAPE = FeederBlock.box(0, 0, 0, 16, 16, 16);
    static MapCodec<FeederBlock> CODEC = simpleCodec(FeederBlock::new);

    public boolean hasSomethingInIt(NonNullList<ItemStack> TempInventory){
        for (ItemStack itemStack : TempInventory){
            if(itemStack != ItemStack.EMPTY){
                return true;
            }
        }
        return false;
    }

    public FeederBlock(Properties properties){
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos worldPosition, BlockState blockState) {
        return new FeederBlockEntity(worldPosition, blockState);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack destroyedWith) {

        if(level.getBlockEntity(pos) instanceof FeederBlockEntity be){
            be.drops();
            level.updateNeighbourForOutputSignal(pos, this);
        }

        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {

        BlockEntity var8 = level.getBlockEntity(pos);
        if (var8 instanceof FeederBlockEntity be) {
            player.openMenu(be);
            player.awardStat(EDAncientStats.InteractionsWithFeeder);
        }

        return InteractionResult.SUCCESS;
    }
}
