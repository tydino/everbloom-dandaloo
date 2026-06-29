package com.tydino.everbloomdandaloo;

import com.tydino.everbloomdandaloo.blocks.EDBlockRegistry;
import com.tydino.everbloomdandaloo.creativemenu.EDItemGroups;
import com.tydino.everbloomdandaloo.entities.EDEntitySpawn;
import com.tydino.everbloomdandaloo.entities.EDEntityTypes;
import com.tydino.everbloomdandaloo.items.EDItemRegistry;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// ToDO
/// update fabricloom
/// add the image for the aether creative tab

/// REMINDERS
/// ctrl+alt+shift+J selects all of same thing for copy paste when needed.
/// utilize: https://docs.fabricmc.net/develop/items/first-item

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

		LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
			// Replace "your_entity_loot_table_name" with the path to your custom entity loot table JSON
			Identifier myEntityLootTable = Identifier.fromNamespaceAndPath(MOD_ID, "entities/dagger_stabber");

			if (source.isBuiltin() && myEntityLootTable.equals(key)) {
				// The event fires, and automatically associates the entity with this loot table
				// No datagen or getLootTableId override needed.
			}
		});
	}
}