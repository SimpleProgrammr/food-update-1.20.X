package com.foodupdate.datagen;

import com.foodupdate.block.ModBlocks;
import com.foodupdate.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(
            ModItems.RAW_RUBY,
            ModBlocks.RUBY_ORE,
            ModBlocks.DEEPSLATE_RUBY_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.7f, 200, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.7f, 100, "ruby");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_RUBY, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_RUBY_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.METAL_DETECTOR, 1)
                .pattern("I  ")
                .pattern(" IR")
                .pattern("  C")
                .input('I', Items.IRON_BARS)
                .input('R', ModItems.RUBY)
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(ModItems.RUBY),conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.METAL_DETECTOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_STAFF, 1)
                .pattern("  R")
                .pattern(" I ")
                .pattern("I  ")
                .input('I', Items.IRON_BARS)
                .input('R', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY),conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_STAFF)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COAL_BRIQUETTE, 8)
                .input(Items.COAL)
                .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
                .offerTo(exporter, new Identifier("coal_briquette_from_coal"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COAL_BRIQUETTE, 8)
                .input(Items.CHARCOAL)
                .criterion(hasItem(Items.CHARCOAL), conditionsFromItem(Items.CHARCOAL))
                .offerTo(exporter, new Identifier("coal_briquette_from_charcoal"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TOMATO_SEEDS, 9)
                .input(ModItems.TOMATO)
                .criterion(hasItem(ModItems.TOMATO), conditionsFromItem(ModItems.TOMATO))
                .offerTo(exporter, new Identifier("tomato_to_tomato_seeds"));

        createDoorRecipe(ModBlocks.RUBY_DOOR, Ingredient.ofItems(ModItems.RUBY)).criterion(hasItem(ModItems.RUBY),conditionsFromItem(ModItems.RUBY)).offerTo(exporter);

        createSimpleSwordRecipe(exporter, RecipeCategory.TOOLS, ModItems.RUBY_SWORD, ModItems.RUBY, Items.STICK);
        createSimplePickaxeRecipe(exporter, RecipeCategory.TOOLS, ModItems.RUBY_PICKAXE, ModItems.RUBY, Items.STICK);
        createSimpleAxeRecipe(exporter, RecipeCategory.TOOLS, ModItems.RUBY_AXE, ModItems.RUBY, Items.STICK);
        createSimpleShovelRecipe(exporter, RecipeCategory.TOOLS, ModItems.RUBY_SHOVEL, ModItems.RUBY, Items.STICK);
        createSimpleHoeRecipe(exporter, RecipeCategory.TOOLS, ModItems.RUBY_HOE, ModItems.RUBY, Items.STICK);


    }


    public void createSimpleSwordRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible outputItem, ItemConvertible mainMaterial, ItemConvertible handleMaterial)
    {
        ShapedRecipeJsonBuilder.create(category, outputItem, 1)
                .pattern(" M ")
                .pattern(" M ")
                .pattern(" H ")
                .input('M', mainMaterial)
                .input('H', handleMaterial)
                .criterion(hasItem(mainMaterial),conditionsFromItem(mainMaterial))
                .offerTo(exporter, new Identifier(getRecipeName(outputItem)));
    }

    public void createSimplePickaxeRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible outputItem, ItemConvertible mainMaterial, ItemConvertible handleMaterial)
    {
        ShapedRecipeJsonBuilder.create(category, outputItem, 1)
                .pattern("MMM")
                .pattern(" H ")
                .pattern(" H ")
                .input('M', mainMaterial)
                .input('H', handleMaterial)
                .criterion(hasItem(mainMaterial),conditionsFromItem(mainMaterial))
                .offerTo(exporter, new Identifier(getRecipeName(outputItem)));
    }

    public void createSimpleAxeRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible outputItem, ItemConvertible mainMaterial, ItemConvertible handleMaterial)
    {
        ShapedRecipeJsonBuilder.create(category, outputItem, 1)
                .pattern(" MM")
                .pattern(" HM")
                .pattern(" H ")
                .input('M', mainMaterial)
                .input('H', handleMaterial)
                .criterion(hasItem(mainMaterial),conditionsFromItem(mainMaterial))
                .offerTo(exporter, new Identifier(getRecipeName(outputItem)));
    }

    public void createSimpleShovelRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible outputItem, ItemConvertible mainMaterial, ItemConvertible handleMaterial)
    {
        ShapedRecipeJsonBuilder.create(category, outputItem, 1)
                .pattern(" M ")
                .pattern(" H ")
                .pattern(" H ")
                .input('M', mainMaterial)
                .input('H', handleMaterial)
                .criterion(hasItem(mainMaterial),conditionsFromItem(mainMaterial))
                .offerTo(exporter, new Identifier(getRecipeName(outputItem)));
    }

    public void createSimpleHoeRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible outputItem, ItemConvertible mainMaterial, ItemConvertible handleMaterial)
    {
        ShapedRecipeJsonBuilder.create(category, outputItem, 1)
                .pattern(" MM")
                .pattern(" H ")
                .pattern(" H ")
                .input('M', mainMaterial)
                .input('H', handleMaterial)
                .criterion(hasItem(mainMaterial),conditionsFromItem(mainMaterial))
                .offerTo(exporter, new Identifier(getRecipeName(outputItem)));
    }
}
