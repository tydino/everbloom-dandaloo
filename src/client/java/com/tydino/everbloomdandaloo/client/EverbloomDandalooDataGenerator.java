package com.tydino.everbloomdandaloo.client;

import com.tydino.everbloomdandaloo.client.datagen.EDBlockLootTables;
import com.tydino.everbloomdandaloo.client.datagen.EDLangProvider;
import com.tydino.everbloomdandaloo.client.datagen.EDModelProvider;
import com.tydino.everbloomdandaloo.client.datagen.EDRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class EverbloomDandalooDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(EDModelProvider::new);
		pack.addProvider(EDRecipeProvider::new);
		pack.addProvider(EDLangProvider::new);
		pack.addProvider(EDBlockLootTables::new);
	}
}
