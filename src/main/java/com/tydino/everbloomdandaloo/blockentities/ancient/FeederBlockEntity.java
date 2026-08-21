package com.tydino.everbloomdandaloo.blockentities.ancient;

import com.tydino.everbloomdandaloo.menus.FeederMenu;
import net.fabricmc.fabric.api.menu.v1.ExtendedMenuProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;

public class FeederBlockEntity extends BaseContainerBlockEntity implements ExtendedMenuProvider<BlockPos> {
    public NonNullList<ItemStack> inventory;
    private static final Component DefaultName = Component.translatable("container.feeder");

    public FeederBlockEntity(BlockPos worldPosition, BlockState blockState){
        super(EDAncientBlockEntities.Feeder, worldPosition, blockState);
        this.inventory = NonNullList.withSize(4, ItemStack.EMPTY);
    }

    @Override
    protected Component getDefaultName() {
        return DefaultName;
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        this.inventory = items;
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return new FeederMenu(containerId, inventory, this);
    }

    @Override
    public int getContainerSize() {
        return 4;
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        ContainerHelper.saveAllItems(output, this.inventory);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        ContainerHelper.loadAllItems(input, this.inventory);
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }

    public void drops() {
        Containers.dropContents(this.level, this.worldPosition, this.inventory);
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayer serverPlayer) {
        return this.worldPosition;
    }

    @Override
    public void setChanged() {
        super.setChanged();
        if(!level.isClientSide()) {
            level.sendBlockUpdated(worldPosition, this.getBlockState(), this.getBlockState(), 3);
        }
    }
}
