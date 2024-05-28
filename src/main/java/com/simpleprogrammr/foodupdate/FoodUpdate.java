package com.simpleprogrammr.foodupdate;

import com.simpleprogrammr.foodupdate.block.ModBlocks;
import com.simpleprogrammr.foodupdate.item.ModItems;
import com.simpleprogrammr.foodupdate.item.ModItemsGroups;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FoodUpdate implements ModInitializer {
	public static final String MOD_ID = "foodupdate";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing {0}"+MOD_ID);
		ModItemsGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}