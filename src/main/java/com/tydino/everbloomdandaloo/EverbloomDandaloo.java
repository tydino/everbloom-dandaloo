package com.tydino.everbloomdandaloo;

import com.tydino.everbloomdandaloo.blockentities.EDBlockEntities;
import com.tydino.everbloomdandaloo.blocks.EDBlockRegistry;
import com.tydino.everbloomdandaloo.creativemenu.EDItemGroups;
import com.tydino.everbloomdandaloo.entities.EDEntitySpawn;
import com.tydino.everbloomdandaloo.entities.EDEntityTypes;
import com.tydino.everbloomdandaloo.items.EDItemRegistry;
import com.tydino.everbloomdandaloo.items.ancient.EDAncientItems;
import com.tydino.everbloomdandaloo.items.ancient.EDPaleozoicItems;
import com.tydino.everbloomdandaloo.recipes.EDRecipes;
import com.tydino.everbloomdandaloo.menus.EDMenuTypes;
import com.tydino.everbloomdandaloo.stats.EDStats;
import com.tydino.everbloomdandaloo.worldgen.ore.EDAncientOres;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// TODO:
/// Make and implement the missing textures and ways to get the untextured items (only add texture when way to get item is added.)
/// Make everything a definitive system (paleozoic is the only exception, but one is garenteed per amber)
///Finish removing depricated fossil items with dinos from their respective times instead. (cretaceous and triassic still have their fossil and fragment items)
//add items currently incomplete from wednesday 10/21/26 to be fully done and implemented regarding hypsilophodon.
//add hypsilophodon fossils, items and scritch+scritch-sound
//implement the untamable brachiosaurus/dinosaurs (best if done before adding hypsilophodon.)
//carnotaurus gets 'jocky' variant, and hypsilophodon gets 'nerdy'
//finish the bone analyzer and dna reformer
//consider removing the motabolism entirely.
// Add the ability for dinosaurs to eat and drink (feeder should hold items using a hopper putting them in, see line 21 for major issue) (motabolism is commented out until this is done!)
// Implement the menu to the Fossil Adapter
// Make the fossil Adapter functionality
// Make the egg only hatchable around specific dinosaurs/mobs, or can be put into an incubator.
// Reimplement the old mobs
//make the brachiosaurus deepslate fossil ore
//make shadows scale with mobs.
//make scarabs

/// REMINDERS
/// Make the systems definitive over RNG.
/// Texture filter;monochromatic at 25% on multiply
/// ctrl+alt+shift+J selects all of same thing for copy paste when needed.
/// look through if needed https://docs.fabricmc.net/develop/items/first-item
/// If struggling check https://github.com/Tutorials-By-Kaupenjoe/Fabric-Tutorial-26.X/tree/30-update-to-26.2 there may be an answer there.

public class EverbloomDandaloo implements ModInitializer {
	public static final String MOD_ID = "everbloomdandaloo";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Registering Items");
		EDItemRegistry.onInitialize();
		LOGGER.info("Registering Block");
		EDBlockRegistry.onInitialize();
		LOGGER.info("Registering Block Entities");
		EDBlockEntities.OnInitialize();
		LOGGER.info("Registering Recipes");
		EDRecipes.onInitialize();
		LOGGER.info("Registeirng Menus");
		EDMenuTypes.onInitialize();

		LOGGER.info("Registering Entities");
		EDEntityTypes.onInitialize(); //ENTITIES IN GENERAL//
		EDEntitySpawn.onInitialize();//ENTITIES SPAWN//

		LOGGER.info("Registering Sounds");
		EDSounds.registerSounds();

		LOGGER.info("Registering Item Groups (for creative)");
		EDItemGroups.onInitialize();

		LOGGER.info("Registering WorldGen Adjustments");
		EDAncientOres.onInitialize();

		LOGGER.info("Registering Stats");
		EDStats.OnInitialize();

		LOGGER.info("Adding the Items into Vanilla Creative Tabs");
		// amber //																													/// ANCIENT ///
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(Items.SLIME_BALL, EDPaleozoicItems.BigBugAmber));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(EDPaleozoicItems.BigBugAmber, EDAncientItems.AmberBugs));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(EDAncientItems.AmberBugs, EDAncientItems.AmberMediumBug));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(EDAncientItems.AmberMediumBug, EDAncientItems.AmberPlant));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(EDAncientItems.AmberPlant, EDAncientItems.AmberWing));
	}
}