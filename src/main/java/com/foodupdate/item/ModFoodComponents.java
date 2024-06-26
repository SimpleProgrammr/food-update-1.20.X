package com.foodupdate.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent TOMATO = new FoodComponent.Builder().hunger(3).saturationModifier(0.25f).statusEffect(new StatusEffectInstance(StatusEffects.LUCK,200), 0.33f).build();
    public static final FoodComponent CORN = new FoodComponent.Builder().hunger(4).saturationModifier(0.4f).build();
}
