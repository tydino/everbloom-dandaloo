package com.tydino.everbloomdandaloo.blocks.ancient;

import com.mojang.serialization.MapCodec;
import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.entities.entitybases.EDDinosaureEntityBase;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DinosaurEgg extends Block {

    /// OVERIDE THIS TO SET VARIANTS BASED ON PARENTS ///
    public void SetEntityData(ServerLevel level, EDDinosaureEntityBase entity, Vec3 spawnAt)
    {
        entity.setAge(0);
        entity.setAgeTicks(0);
        entity.snapTo(spawnAt.x(), spawnAt.y(), spawnAt.z(), Mth.wrapDegrees(level.getRandom().nextFloat() * 360.0F), 0.0F);
        level.addFreshEntity(entity);
    }

    public MapCodec<?> CODEC;
    public static IntegerProperty HATCH = BlockStateProperties.HATCH;
    int HATCHING_TIME;
    public VoxelShape SHAPE;
    public EntityType<? extends EDDinosaureEntityBase> TDE;

    public MapCodec<? extends DinosaurEgg> getCODEC() {
        return (MapCodec<? extends DinosaurEgg>) CODEC;
    }

    public DinosaurEgg(Properties properties, int minX, int minY, int minZ, int maxX, int maxY, int maxZ, int hatchingTime, EntityType<? extends EDDinosaureEntityBase> TDE, MapCodec<?> codec) {
        super(properties);
        this.registerDefaultState(defaultBlockState().setValue(HATCH, 0));
        this.SHAPE = DinosaurEgg.box(minX, minY, minZ, maxX, maxY, maxZ);
        this.HATCHING_TIME = hatchingTime;// /3 then *20 for full time in seconds
        this.CODEC = codec;
        this.TDE = TDE;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public int getHatchStage(BlockState state){
        return state.getValue(HATCH);
    }

    boolean isReadyToHatch(BlockState state){
        return this.getHatchStage(state) == 1;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HATCH);
        //for multiple: builder.add(new Property[]{HATCH, EGGS});
    }

    @Override
    protected void tick(final BlockState state, final ServerLevel level, final BlockPos pos, final RandomSource random) {
        if(!this.isReadyToHatch(state)){
            level.playSound(null, pos, SoundEvents.SNIFFER_EGG_CRACK, SoundSource.BLOCKS, 0.7F, 0.9F + random.nextFloat() * 0.2F);
            level.setBlock(pos, state.setValue(HATCH, this.getHatchStage(state) + 1), 1);
        }else{
            level.playSound(null, pos, SoundEvents.SNIFFER_EGG_HATCH, SoundSource.BLOCKS, 0.7F, 0.9F + random.nextFloat() * 0.2F);
            level.destroyBlock(pos, false);
            EDDinosaureEntityBase entity = TDE.create(level, EntitySpawnReason.NATURAL);
            Vec3 spawnAt = Vec3.atCenterOf(pos);
            if(entity != null){
                SetEntityData(level, entity, spawnAt);
            }else{
                EverbloomDandaloo.LOGGER.error("Missing a dinosaur spawn to a egg.");
            }
        }
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        int progressionTickDelay = HATCHING_TIME/3;
        level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(state));
        level.scheduleTick(pos, this, progressionTickDelay + level.getRandom().nextInt(300));
    }

    public boolean isPathfindable(final BlockState state, final PathComputationType type) {
        return true;
    }
}
