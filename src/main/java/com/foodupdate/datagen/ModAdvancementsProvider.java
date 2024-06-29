package com.foodupdate.datagen;

import com.foodupdate.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModAdvancementsProvider extends FabricAdvancementProvider {
    public ModAdvancementsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement get_mod = Advancement.Builder.create()
                .display(Blocks.FARMLAND,
                        Text.translatable("advancement.get_mod_advancement"),
                        Text.translatable("advancement.get_mod_advancement_description"),
                        new Identifier("minecraft:textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false)
                .criterion("spawned", TickCriterion.Conditions.createTick())
                .build(consumer, "foodupdate/get_mod");

        Advancement get_tomato = Advancement.Builder.create()
                .display(ModItems.TOMATO,
                        Text.translatable("advancement.get_tomato_advancement"),
                        Text.translatable("advancement.get_tomato_advancement_description"),
                        new Identifier("minecraft:textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false)
                .parent(get_mod)
                .criterion("get_tomato", InventoryChangedCriterion.Conditions.items(ModItems.TOMATO))
                .build(consumer, "foodupdate/get_tomato");

        Advancement get_corn = Advancement.Builder.create()
                .display(ModItems.CORN,
                        Text.translatable("advancement.get_corn_advancement"),
                        Text.translatable("advancement.get_corn_advancement_description"),
                        new Identifier("minecraft:textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false)
                .parent(get_mod)
                .criterion("get_corn", InventoryChangedCriterion.Conditions.items(ModItems.CORN))
                .build(consumer, "foodupdate/get_corn");


    }

}