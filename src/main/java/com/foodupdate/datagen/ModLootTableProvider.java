package com.foodupdate.datagen;

import com.foodupdate.block.ModBlocks;
import com.foodupdate.block.custom.CornCropBlock;
import com.foodupdate.block.custom.TomatoCropBlock;
import com.foodupdate.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RUBY_BLOCK);
        addDrop(ModBlocks.RAW_RUBY_BLOCK);
        addDrop(ModBlocks.SOUND_BLOCK);

        addDrop(ModBlocks.RUBY_ORE, copperLikeOreDrops(ModBlocks.RUBY_ORE, ModItems.RAW_RUBY, 2.0f, 5.0f));
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, copperLikeOreDrops(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RAW_RUBY, 3.0f , 6.0f));

        addDrop(ModBlocks.RUBY_STAIRS);
        addDrop(ModBlocks.RUBY_SLAB, slabDrops(ModBlocks.RUBY_SLAB));

        addDrop(ModBlocks.RUBY_BUTTON);
        addDrop(ModBlocks.RUBY_PRESSURE_PLATE);

        addDrop(ModBlocks.RUBY_FENCE);
        addDrop(ModBlocks.RUBY_FENCE_GATE);
        addDrop(ModBlocks.RUBY_WALL);

        addDrop(ModBlocks.RUBY_DOOR, doorDrops(ModBlocks.RUBY_DOOR));
        addDrop(ModBlocks.RUBY_TRAPDOOR);


        addDrop(ModBlocks.TOMATO_CROP, cropDrops(ModBlocks.TOMATO_CROP, ModItems.TOMATO, ModItems.TOMATO_SEEDS,
                BlockStatePropertyLootCondition.builder(ModBlocks.TOMATO_CROP)
                        .properties(StatePredicate.Builder.create()
                                .exactMatch(TomatoCropBlock.AGE, 5)))
        );

        addDrop(ModBlocks.CORN_CROP, cropDrops(ModBlocks.CORN_CROP, ModItems.CORN, ModItems.CORN_SEEDS,
                BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP)
                        .properties(StatePredicate.Builder.create()
                                .exactMatch(CornCropBlock.AGE, 8)))
        );

    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item, float min, float max) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder) ItemEntry.builder(item)
                        .apply(SetCountLootFunction.
                                builder(UniformLootNumberProvider.
                                        create(min, max))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
