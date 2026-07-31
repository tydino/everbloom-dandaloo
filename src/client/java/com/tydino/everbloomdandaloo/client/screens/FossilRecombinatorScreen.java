package com.tydino.everbloomdandaloo.client.screens;

import com.tydino.everbloomdandaloo.menus.fossil_recombinator.FossilRecombinatorMenu;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class FossilRecombinatorScreen extends AbstractContainerScreen<FossilRecombinatorMenu> {
    private static final Identifier SCREEN_TEXTURE = Identifier.withDefaultNamespace("textures/gui/container/anvil.png");

    public FossilRecombinatorScreen(FossilRecombinatorMenu abstractContainerMenu, Inventory inventory, Component component) {
        super(abstractContainerMenu, inventory, component);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float delta) {
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SCREEN_TEXTURE, this.leftPos, this.topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
    }
}
