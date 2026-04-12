package com.tydino.everbloomdandaloo;

import com.tydino.everbloomdandaloo.blocks.EDBlockRegistry;
import com.tydino.everbloomdandaloo.creativemenu.EDItemGroups;
import com.tydino.everbloomdandaloo.entities.EDEntityTypes;
import com.tydino.everbloomdandaloo.items.EDItemRegistry;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// ToDO
/// update fabricloom
/// add animations and finished ai to the dagger stabber

/// utilize: https://docs.fabricmc.net/develop/items/first-item

public class EverbloomDandaloo implements ModInitializer {
	public static final String MOD_ID = "everbloomdandaloo";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		EDBlockRegistry.onInitialize(); //BLOCKS//
		EDItemRegistry.onInitialize(); //ITEMS//
		EDEntityTypes.onInitialize(); //ENTITIES//

		EDItemGroups.onInitialize(); //ITEMGROUPS//
	}
}