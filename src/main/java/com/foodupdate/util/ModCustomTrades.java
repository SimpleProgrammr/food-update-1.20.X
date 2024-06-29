package com.foodupdate.util;

import com.foodupdate.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

@SuppressWarnings("unused")
public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RUBY, 2),    //In
                            new ItemStack(Items.EMERALD, 1),    //In
                            new ItemStack(ModItems.TOMATO, 3),  //Out
                            6,      //Max Uses
                            6,      //Merchant Exp
                            0.05f   //Price Multiplier
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RUBY, 3),    //In
                            new ItemStack(Items.EMERALD, 2),    //In
                            new ItemStack(ModItems.CORN, 5),    //Out
                            6,
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
                            10,
                            0.1f
                    ));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RUBY, 6),
                            new ItemStack(ModItems.CORN_SEEDS, 10),
                            4,
                            10,
                            0.05f
                    ));
                });
    }
}
