package com.foodupdate.util;

import com.foodupdate.item.ModItems;
import com.foodupdate.villager.ModVillager;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;

@SuppressWarnings("unused")
public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(ModVillager.COOK, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RUBY, 10),    //In
                            new ItemStack(ModItems.TOMATO, 3),  //Out
                            6,      //Max Uses
                            6,      //Merchant Exp
                            0.05f   //Price Multiplier
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RUBY, 8),    //In
                            new ItemStack(ModItems.CORN, 5),    //Out
                            6,
                            8,
                            0.05f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillager.SOUND_MASTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RUBY, 5),    //In
                            new ItemStack(Items.EMERALD, 4),    //In
                            new ItemStack(Items.MUSIC_DISC_5, 1),  //Out
                            2,      //Max Uses
                            9,     //Merchant Exp
                            0.05f   //Price Multiplier
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RUBY, 4),
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(Items.MUSIC_DISC_BLOCKS, 1),
                            2,
                            8,
                            0.05f
                    ));
                });


        TradeOfferHelper.registerWanderingTraderOffers(1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RUBY, 6),
                            new ItemStack(ModItems.TOMATO_SEEDS, 10),
                            4,
                            6,
                            0.1f
                    ));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RUBY, 6),
                            new ItemStack(ModItems.CORN_SEEDS, 10),
                            4,
                            6,
                            0.05f
                    ));
                });


    }
}
