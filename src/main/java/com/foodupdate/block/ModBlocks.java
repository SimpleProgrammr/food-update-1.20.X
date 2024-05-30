package com.foodupdate.block;

import com.foodupdate.FoodUpdate;
//import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;


public class ModBlocks {

    public static final Block RUBY_BLOCK = registerBlock("ruby_block",new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_RUBY_BLOCK = registerBlock("raw_ruby_block", new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_CLUSTER)));

    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.LAPIS_ORE).strength(2.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK), UniformIntProvider.create(2, 5)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_LAPIS_ORE).strength(4.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK), UniformIntProvider.create(3, 5)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, new Identifier(FoodUpdate.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
    return Registry.register(Registries.ITEM, new Identifier(FoodUpdate.MOD_ID, name),
            new BlockItem(block,new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        FoodUpdate.LOGGER.info("Registering Mod Blocks for" + FoodUpdate.MOD_ID);

    }
}
