package com.tydino.everbloomdandaloo.blocks.ancient.energy;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FossilRecombinerBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<FossilRecombinerBlock> CODEC = simpleCodec(FossilRecombinerBlock::new);
    public static final VoxelShape SHAPE = Block.box(1, 0, 4, 15, 4, 16);
    public FossilRecombinerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {return CODEC;}

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {return SHAPE;}
}
