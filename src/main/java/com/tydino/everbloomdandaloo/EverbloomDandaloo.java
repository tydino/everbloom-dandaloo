package com.tydino.everbloomdandaloo;

import com.tydino.everbloomdandaloo.blocks.EDBlockRegistry;
import com.tydino.everbloomdandaloo.creativemenu.EDItemGroups;
import com.tydino.everbloomdandaloo.entities.EDEntitySpawn;
import com.tydino.everbloomdandaloo.entities.EDEntityTypes;
import com.tydino.everbloomdandaloo.items.EDItemRegistry;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// REMINDERS
/// ctrl+alt+shift+J selects all of same thing for copy paste when needed.
/// utilize: https://docs.fabricmc.net/develop/items/first-item
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
	}
}