package com.simpleprogrammr.foodupdate.item;

import com.simpleprogrammr.foodupdate.FoodUpdate;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RUBY = registerItem("ruby",new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby",new Item(new FabricItemSettings()));

    private static void addItemToIngredientsItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RAW_RUBY);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FoodUpdate.MOD_ID,name),item);
    }

    public static void registerModItems() {
        FoodUpdate.LOGGER.info("Registering Mod items for " + FoodUpdate.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIngredientsItemGroup);
    }
}
