package com.tydino.everbloomdandaloo.client;

import com.tydino.everbloomdandaloo.client.entities.EDModelLoader;
import net.fabricmc.api.ClientModInitializer;

public class EverbloomDandalooClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EDModelLoader.onInitialize();
	}
}