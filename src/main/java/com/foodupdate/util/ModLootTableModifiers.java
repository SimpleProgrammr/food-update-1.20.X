package com.foodupdate.util;

import com.foodupdate.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class ModLootTableModifiers {

    private static final Identifier JUNGLE_TEMPLE_ID =
            new Identifier("minecraft", "chests/jungle_temple");

    private static final Identifier ZOMBIE_VILLAGER_ID =
            new Identifier("minecraft", "entities/zombie_villager");

    private static final Identifier CREEPER_ID =
            new Identifier("minecraft", "entities/creeper");

    private static final Identifier SUS_SAND_ID =
            new Identifier("minecraft", "archaeology/desert_pyramid");

    private static final Identifier PLAINS_VILLAGE_HOUSE_ID =
            new Identifier("minecraft", "chests/village/village_plains_house");

    private static final Identifier WOODLAND_MANSION_ID =
            new Identifier("minecraft", "chests/woodland_mansion");

    private static final Identifier SHIPWRECK_SUPPLY_ID =
            new Identifier("minecraft", "chests/shipwreck_supply");



    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (JUNGLE_TEMPLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.9f)) // 0.9f == 90%
                        .with(ItemEntry.builder(ModItems.METAL_DETECTOR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build())

                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(ModItems.CORN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build()); // Number of Items found in structure

                tableBuilder.pool(poolBuilder.build());
            }

            if (ZOMBIE_VILLAGER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f)) // 0.1f == 10%
                        .with(ItemEntry.builder(ModItems.TOMATO))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build()) // Number of Items found in structure

                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(ModItems.CORN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (CREEPER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f)) // 0.2f == 20%
                        .with(ItemEntry.builder(ModItems.COAL_BRIQUETTE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)).build()); // Number of Items found in structure

                tableBuilder.pool(poolBuilder.build());
            }

            if (PLAINS_VILLAGE_HOUSE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()

                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.6f))
                        .with(ItemEntry.builder(ModItems.TOMATO))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)))

                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.6f))
                        .with(ItemEntry.builder(ModItems.CORN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                // Number of Items found in structure

                tableBuilder.pool(poolBuilder.build());
            }

            if (WOODLAND_MANSION_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.6f))
                        .with(ItemEntry.builder(ModItems.TOMATO))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 4.0f)).build())

                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(ModItems.CORN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (SHIPWRECK_SUPPLY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()

                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.4f))
                        .with(ItemEntry.builder(ModItems.TOMATO))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build())

                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.4f))
                        .with(ItemEntry.builder(ModItems.CORN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

        });

        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            if (SUS_SAND_ID.equals(id)) {
                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
                entries.add(ItemEntry.builder(ModItems.METAL_DETECTOR).build());
                entries.add(ItemEntry.builder(ModItems.COAL_BRIQUETTE).build());

                LootPool.Builder pool = LootPool.builder().with(entries);

                return LootTable.builder().pool(pool).build();
            }

            return null;
        });

    }

}

