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

    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(FoodUpdate.MOD_ID,"ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() ->  new ItemStack(ModItems.RUBY)).entries(((displayContext, entries) -> {
                        //Adding Items Space
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);

                        //Adding Blocks Space
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);

                        //Adding Ores
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);

                        //Adding Special Blocks
                        entries.add(ModBlocks.SOUND_BLOCK);

                    })).build());

    public static void registerItemGroups(){
        FoodUpdate.LOGGER.info("Registering Item Groups for "+ FoodUpdate.MOD_ID);

    }
}
