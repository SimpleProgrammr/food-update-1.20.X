package com.foodupdate.item;

import com.foodupdate.FoodUpdate;
import com.foodupdate.block.ModBlocks;
import com.foodupdate.item.custom.MetalDetectorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    //Creating Ruby
    public static final Item RUBY = registerItem("ruby",new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby",new Item(new FabricItemSettings()));

    //Creating Food
    public static final Item TOMATO = registerItem("tomato",new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));

    //Creating Custom Fuel
    public static final Item COAL_BRIQUETTE = registerItem("coal_briquette",new Item(new FabricItemSettings()));

    //Creating tools
    public static final Item METAL_DETECTOR = registerItem("metal_detector",new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));



    private static void addItemToIngredientsItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RAW_RUBY);
        entries.add(COAL_BRIQUETTE);
    }

    private static void addItemToToolItemGroup(FabricItemGroupEntries entries) {
        entries.add(METAL_DETECTOR);
    }

    private static void addItemToFoodItemGroup(FabricItemGroupEntries entries) {
        entries.add(TOMATO);
    }

    private static void addItemToSpawnEggsItemGroup(FabricItemGroupEntries entries) {

    }

    private static void addItemToRedstoneItemGroup(FabricItemGroupEntries entries) {

    }

    private static void addItemToNaturalItemGroup(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.RUBY_ORE);
        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
    }

    private static void addItemToFunctionalItemGroup(FabricItemGroupEntries entries) {

    }

    private static void addItemToColoredBlocksItemGroup(FabricItemGroupEntries entries) {

    }

    private static void addItemToBuildingBlocksItemGroup(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.RUBY_BLOCK);
        entries.add(ModBlocks.RUBY_STAIRS);
        entries.add(ModBlocks.RUBY_SLAB);
        entries.add(ModBlocks.RUBY_BUTTON);
        entries.add(ModBlocks.RUBY_PRESSURE_PLATE);
        entries.add(ModBlocks.RUBY_FENCE);
        entries.add(ModBlocks.RUBY_FENCE);
        entries.add(ModBlocks.RUBY_WALL);
        entries.add(ModBlocks.RUBY_DOOR);
        entries.add(ModBlocks.RUBY_TRAPDOOR);
        entries.add(ModBlocks.RAW_RUBY_BLOCK);
    }

    private static void addItemToCombatItemGroup(FabricItemGroupEntries entries) {

    }


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FoodUpdate.MOD_ID,name),item);
    }

    public static void registerModItems() {
        FoodUpdate.LOGGER.info("Registering Mod items for " + FoodUpdate.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIngredientsItemGroup);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemToFoodItemGroup);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemToToolItemGroup);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemToCombatItemGroup);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItems::addItemToBuildingBlocksItemGroup);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(ModItems::addItemToColoredBlocksItemGroup);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModItems::addItemToFunctionalItemGroup);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemToNaturalItemGroup);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(ModItems::addItemToRedstoneItemGroup);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ModItems::addItemToSpawnEggsItemGroup);

    }


}
