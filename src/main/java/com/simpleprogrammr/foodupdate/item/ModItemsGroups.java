package com.simpleprogrammr.foodupdate.item;

import com.simpleprogrammr.foodupdate.FoodUpdate;
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
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);

                    })).build());

    public static void registerItemGroups(){
        FoodUpdate.LOGGER.info("Registering Item Groups for "+ FoodUpdate.MOD_ID);
    }
}
