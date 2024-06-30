package com.foodupdate.item;

import com.foodupdate.FoodUpdate;
import com.foodupdate.block.ModBlocks;
import com.foodupdate.item.custom.MetalDetectorItem;
import com.foodupdate.item.custom.ModArmorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


@SuppressWarnings("UnstableApiUsage")
public class ModItems {
    //Creating Ruby
    public static final Item RUBY = registerItem("ruby",
            new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby",
            new Item(new FabricItemSettings()));

    //Creating Custom Fuel
    public static final Item COAL_BRIQUETTE = registerItem("coal_briquette",
            new Item(new FabricItemSettings()));

    //Creating tools
    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));
    public static final Item RUBY_STAFF = registerItem("ruby_staff",
            new Item(new FabricItemSettings().maxCount(1)));


    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel",
            new ShovelItem(ModToolMaterial.RUBY, 2.5f, -3f, new FabricItemSettings()));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe",
            new PickaxeItem(ModToolMaterial.RUBY, 2, -2.8f, new FabricItemSettings()));
    public static final Item RUBY_AXE = registerItem("ruby_axe",
            new AxeItem(ModToolMaterial.RUBY, 6, -3.0f, new FabricItemSettings()));
    public static final Item RUBY_HOE = registerItem("ruby_hoe",
            new HoeItem(ModToolMaterial.RUBY, -4, 1f, new FabricItemSettings()));
    public static final Item RUBY_SWORD = registerItem("ruby_sword",
            new SwordItem(ModToolMaterial.RUBY, 4, -2.4f, new FabricItemSettings()));

    public static final Item RUBY_HELMET = registerItem("ruby_helmet",
            new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //Creating Food
    public static final Item TOMATO = registerItem("tomato",
            new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));
    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds",
            new AliasedBlockItem(ModBlocks.TOMATO_CROP, new FabricItemSettings()));

    public static final Item CORN = registerItem("corn",
            new Item(new FabricItemSettings().food(ModFoodComponents.CORN)));
    public static final Item CORN_SEEDS = registerItem("corn_seeds",
            new AliasedBlockItem(ModBlocks.CORN_CROP, new FabricItemSettings()));



    private static void addItemToIngredientsItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RAW_RUBY);
        entries.add(COAL_BRIQUETTE);
    }

    private static void addItemToToolItemGroup(FabricItemGroupEntries entries) {
        entries.add(METAL_DETECTOR);
        entries.add(RUBY_STAFF);
        entries.add(RUBY_SHOVEL);
        entries.add(RUBY_PICKAXE);
        entries.add(RUBY_AXE);
        entries.add(RUBY_HOE);
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
        entries.add(RUBY_SWORD);
        entries.add(RUBY_AXE);
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
