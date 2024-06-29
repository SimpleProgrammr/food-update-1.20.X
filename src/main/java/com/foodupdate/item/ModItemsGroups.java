package com.foodupdate.item;

import com.foodupdate.FoodUpdate;
import com.foodupdate.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroups {

    @SuppressWarnings("unused")
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(FoodUpdate.MOD_ID,"ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() ->  new ItemStack(ModItems.TOMATO)).entries(((displayContext, entries) -> {
                        //Adding Items Space
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);

                        //Adding Ores
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);

                        //Adding Special Blocks
                        entries.add(ModBlocks.SOUND_BLOCK);

                        //Adding Building Blocks
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RUBY_STAIRS);
                        entries.add(ModBlocks.RUBY_SLAB);
                        entries.add(ModBlocks.RUBY_BUTTON);
                        entries.add(ModBlocks.RUBY_PRESSURE_PLATE);
                        entries.add(ModBlocks.RUBY_FENCE);
                        entries.add(ModBlocks.RUBY_FENCE_GATE);
                        entries.add(ModBlocks.RUBY_WALL);
                        entries.add(ModBlocks.RUBY_DOOR);
                        entries.add(ModBlocks.RUBY_TRAPDOOR);

                        entries.add(ModBlocks.RAW_RUBY_BLOCK);

                        entries.add(ModItems.RUBY_STAFF);

                        entries.add(ModItems.RUBY_SHOVEL);
                        entries.add(ModItems.RUBY_PICKAXE);
                        entries.add(ModItems.RUBY_AXE);
                        entries.add(ModItems.RUBY_HOE);
                        entries.add(ModItems.RUBY_SWORD);

                        entries.add(ModItems.RUBY_HELMET);
                        entries.add(ModItems.RUBY_CHESTPLATE);
                        entries.add(ModItems.RUBY_LEGGINGS);
                        entries.add(ModItems.RUBY_BOOTS);

                        entries.add(ModItems.TOMATO);
                        entries.add(ModItems.TOMATO_SEEDS);

                        entries.add(ModItems.CORN);
                        entries.add(ModItems.CORN_SEEDS);

                    })).build());

    public static void registerItemGroups(){
        FoodUpdate.LOGGER.info("Registering Item Groups for "+ FoodUpdate.MOD_ID);

    }
}
