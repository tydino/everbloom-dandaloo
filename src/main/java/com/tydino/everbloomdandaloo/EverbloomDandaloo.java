package com.tydino.everbloomdandaloo;

import com.tydino.everbloomdandaloo.blocks.EDBlockRegistry;
import com.tydino.everbloomdandaloo.creativemenu.EDItemGroups;
import com.tydino.everbloomdandaloo.entities.EDEntitySpawn;
import com.tydino.everbloomdandaloo.entities.EDEntityTypes;
import com.tydino.everbloomdandaloo.items.EDItemRegistry;
import com.tydino.everbloomdandaloo.items.ancient.EDCretaceousItems;
import com.tydino.everbloomdandaloo.items.ancient.EDJurassicItems;
import com.tydino.everbloomdandaloo.items.ancient.EDPaleozoicItems;
import com.tydino.everbloomdandaloo.items.ancient.EDTriassicItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// REMINDERS
///All Datagen Scripts must be open to run Datagen properly
/// ctrl+alt+shift+J selects all of same thing for copy paste when needed.
/// If struggling check https://github.com/Tutorials-By-Kaupenjoe/Fabric-Tutorial-26.X/tree/30-update-to-26.2 there may be an answer there.

public class EverbloomDandaloo implements ModInitializer {
	public static final String MOD_ID = "everbloomdandaloo";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		EDSounds.registerSounds(); //SOUNDS//
		EDItemRegistry.onInitialize(); //ITEMS//
		EDBlockRegistry.onInitialize(); //BLOCKS//

		EDEntityTypes.onInitialize(); //ENTITIES//
		EDEntitySpawn.onInitialize();//ENTITIES SPAWN//

		EDItemGroups.onInitialize(); //ITEMGROUPS//

		/// Ancient items added to vanilla creative mode tabs ///
		// fossils //
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(Items.BONE_MEAL, EDPaleozoicItems.PermianAnimalFossil));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(EDPaleozoicItems.PermianAnimalFossil, EDTriassicItems.TriassicAnimalFossil));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(EDTriassicItems.TriassicAnimalFossil, EDJurassicItems.JurassicAnimalFossil));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(EDJurassicItems.JurassicAnimalFossil, EDCretaceousItems.CretaceousAnimalFossil));
	}
}