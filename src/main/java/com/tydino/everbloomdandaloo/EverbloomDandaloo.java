package com.tydino.everbloomdandaloo;

import com.tydino.everbloomdandaloo.blocks.EDBlockRegistry;
import com.tydino.everbloomdandaloo.creativemenu.EDItemGroups;
import com.tydino.everbloomdandaloo.entities.EDEntitySpawn;
import com.tydino.everbloomdandaloo.entities.EDEntityTypes;
import com.tydino.everbloomdandaloo.items.EDItemRegistry;
import com.tydino.everbloomdandaloo.items.ancient.*;
import com.tydino.everbloomdandaloo.recipes.EDRecipes;
import com.tydino.everbloomdandaloo.menus.EDMenuTypes;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/// TODO:
/// Fix the menu for the Fossil Recombinator

/// REMINDERS
/// ctrl+alt+shift+J selects all of same thing for copy paste when needed.
/// look through if needed https://docs.fabricmc.net/develop/items/first-item
/// If struggling check https://github.com/Tutorials-By-Kaupenjoe/Fabric-Tutorial-26.X/tree/30-update-to-26.2 there may be an answer there.

public class EverbloomDandaloo implements ModInitializer {
	public static final String MOD_ID = "everbloomdandaloo";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Registering Items");
		EDItemRegistry.onInitialize(); //ITEMS//
		LOGGER.info("Registering Block");
		EDBlockRegistry.onInitialize(); //BLOCKS//
		LOGGER.info("Registering Recipes");
		EDRecipes.onInitialize();
		LOGGER.info("Registeirng Menus");
		EDMenuTypes.onInitialize();

		LOGGER.info("Registering Entities");
		Dimensions.onInitialize();
		EDEntityTypes.onInitialize(); //ENTITIES//
		EDEntitySpawn.onInitialize();//ENTITIES SPAWN//

		LOGGER.info("Registering Sounds");
		EDSounds.registerSounds(); //SOUNDS//

		LOGGER.info("Registering Item Groups (for creative)");
		EDItemGroups.onInitialize(); //ITEMGROUPS//

		LOGGER.info("Adding the Items into Vanilla Creative Tabs");
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
				content.insertAfter(EDAncientItems.AmberPlant, EDAncientItems.AmberWing));

	}

	public static class Dimensions{
		public static void onInitialize(){
			Ancient.onInitialize();
		}
		public static class Ancient{
			public static void onInitialize(){
				Jurassic.onInitialize();
			}
			public static class Jurassic{
				public static void onInitialize(){
					BrachiosaurusDimensionsLoader();
				}

				public static List<EntityDimensions> BrachiosaurusDimensions = new ArrayList<EntityDimensions>();
				public static void BrachiosaurusDimensionsLoader(){
					BrachiosaurusDimensions.add(register(0.25f, 0.7f, 1.575f));
					BrachiosaurusDimensions.add(register(0.5f, 1.4f, 3.15f));
					BrachiosaurusDimensions.add(register(0.75f, 2.1f, 4.725f));
					BrachiosaurusDimensions.add(register(1f, 2.8f, 6.3f));
					BrachiosaurusDimensions.add(register(1.25f, 3.5f, 7.875f));
					BrachiosaurusDimensions.add(register(1.5f, 4.2f, 9.45f));
					BrachiosaurusDimensions.add(register(1.75f, 4.9f, 11.025f));
					BrachiosaurusDimensions.add(register(2f, 5.6f, 12.6f));
					BrachiosaurusDimensions.add(register(2.25f, 6.3f, 14.175f));
					BrachiosaurusDimensions.add(register(2.5f, 7f, 15.75f));
				}
			}
		}

		public static EntityDimensions register(float width, float height, float eyeHeight){
			return EntityDimensions.scalable(width, height).withEyeHeight(eyeHeight);
		}
	}
}