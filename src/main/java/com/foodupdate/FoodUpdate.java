package com.foodupdate;

import com.foodupdate.block.ModBlocks;
import com.foodupdate.item.ModItems;
import com.foodupdate.item.ModItemsGroups;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FoodUpdate implements ModInitializer {
	public static final String MOD_ID = "foodupdate";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing "+ MOD_ID);

		ModItemsGroups.registerItemGroups();

		ModItems.registerModItems();

		ModBlocks.registerModBlocks();

		//Adding custom fuel
		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 200);
	}
}