package com.tydino.everbloomdandaloo;

import com.tydino.everbloomdandaloo.blockentities.EDBlockEntities;
import com.tydino.everbloomdandaloo.blocks.EDBlockRegistry;
import com.tydino.everbloomdandaloo.creativemenu.EDItemGroups;
import com.tydino.everbloomdandaloo.entities.EDEntitySpawn;
import com.tydino.everbloomdandaloo.entities.EDEntityTypes;
import com.tydino.everbloomdandaloo.items.EDItemRegistry;
import com.tydino.everbloomdandaloo.recipes.EDRecipes;
import com.tydino.everbloomdandaloo.menus.EDMenuTypes;
import com.tydino.everbloomdandaloo.stats.EDStats;
import com.tydino.everbloomdandaloo.worldgen.ore.EDAncientOres;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.impl.util.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// TODO:
//Finish removing depricated fossil items (cretaceous and triassic still have their fossil and fragment items)
// Add the ability for dinosaurs to eat and drink
// Rework the current fossils a bit to match a definitive system.
// Implement the menu to the Fossil Adapter
// Make the fossil Adapter functionality
// Make the egg only hatchable around specific dinosaurs/mobs, or can be put into an incubator.
// Make and implement the missing textures and ways to get the untextured items
// Reimplement the old mobs
//make the brachiosaurus deepslate fossil ore

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

		/*LOGGER.info("Adding the Items into Vanilla Creative Tabs");
		// fossils //																													/// ANCIENT ///
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(Items.BONE_MEAL, EDPaleozoicItems.PermianAnimalFossil));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(EDPaleozoicItems.PermianAnimalFossil, EDTriassicItems.TriassicAnimalFossil));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(EDTriassicItems.TriassicAnimalFossil, EDJurassicItems.JurassicAnimalFossil));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(EDJurassicItems.JurassicAnimalFossil, EDCretaceousItems.CretaceousAnimalFossil));

		// fossil fragments //
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(EDPaleozoicItems.PermianAnimalFossil, EDPaleozoicItems.AnimalFossilFragments));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(EDTriassicItems.TriassicAnimalFossil, EDTriassicItems.AnimalFossilFragments));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(EDJurassicItems.JurassicAnimalFossil, EDJurassicItems.AnimalFossilFragments));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(EDCretaceousItems.CretaceousAnimalFossil, EDCretaceousItems.AnimalFossilFragments));

		// amber //
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(Items.SLIME_BALL, EDPaleozoicItems.BigBugAmber));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(EDPaleozoicItems.BigBugAmber, EDAncientItems.AmberBugs));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(EDAncientItems.AmberBugs, EDAncientItems.AmberMediumBug));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(EDAncientItems.AmberMediumBug, EDAncientItems.AmberPlant));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content ->
				content.insertAfter(EDAncientItems.AmberPlant, EDAncientItems.AmberWing));*/

	}
}