package com.foodupdate.villager;

import com.foodupdate.FoodUpdate;
import com.foodupdate.block.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillager {

    public static final RegistryKey<PointOfInterestType> SOUND_POI_KEY = poiKey("soundpoi");
    public static final PointOfInterestType SOUND_POI = registerPoi("soundpoi", ModBlocks.SOUND_BLOCK);
    public static final VillagerProfession SOUND_MASTER = registerProfession("sound_master", SOUND_POI_KEY);

    public static final RegistryKey<PointOfInterestType> COOK_POI_KEY = poiKey("cookpoi");
    public static final PointOfInterestType COOK_POI = registerPoi("cookpoi", Blocks.CAMPFIRE);
    public static final VillagerProfession COOK = registerProfession("cook", COOK_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(FoodUpdate.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_FARMER));
    }

    public static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(FoodUpdate.MOD_ID, name), 1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(FoodUpdate.MOD_ID, name));
    }

    public static void registerVillagers() {
        FoodUpdate.LOGGER.info("Registering Villagers " + FoodUpdate.MOD_ID);
    }
}
