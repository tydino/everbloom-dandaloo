package com.tydino.everbloomdandaloo.menus;

import com.tydino.everbloomdandaloo.EverbloomDandaloo;
import com.tydino.everbloomdandaloo.blocks.ancient.EDAncientBlocks;
import com.tydino.everbloomdandaloo.menus.fossil_recombinator.FossilRecombinatorMenu;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class FeederMenu extends AbstractContainerMenu {

    final Container container = new SimpleContainer(4) {
        @Override
        public void setChanged() {
            super.setChanged();
            FeederMenu.this.slotsChanged(this);
        }
    };

    private final ContainerLevelAccess access;

    @Nullable
    private final Player player;

    public FeederMenu(int containerId, Inventory inventory) {
        this(containerId, inventory, ContainerLevelAccess.NULL);
    }

    public FeederMenu(int containerId, Inventory inventory, ContainerLevelAccess access){
        super(EDMenuTypes.Feeder, containerId);

        this.access = access;

        this.player = inventory.player;

        addSlot(new Slot(this.container, 0, 69, 31));
        addSlot(new Slot(this.container, 1, 91, 31));
        addSlot(new Slot(this.container, 2, 69, 54));
        addSlot(new Slot(this.container, 3, 91, 54));

        addStandardInventorySlots(inventory, 8, 84);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return container.stillValid(player);
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.access.execute((level, blockPos) -> this.clearContainer(player, this.container));
    }
}
