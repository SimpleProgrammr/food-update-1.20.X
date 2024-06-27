package com.foodupdate.item.custom;

import com.foodupdate.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {

    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        if(!context.getWorld().isClient()) {
            BlockPos clickedBlockPos = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            int yPos = clickedBlockPos.getY();
            for (int i = 0; i < 64 + yPos; i++) {
                BlockState state = context.getWorld().getBlockState(clickedBlockPos.down(i));

                if (isValuableBlock(state)) {
                    outputValuableCoordinates(player, i);
                    foundBlock = true;

                    break;
                }
            }

            if(!foundBlock)
                player.sendMessage(Text.literal("No Valuables Found!"));
        }

        context.getStack().damage(1, context.getPlayer(),
                playerEntity ->
                    playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    private void outputValuableCoordinates(PlayerEntity player, int depth) {
        player.sendMessage(Text.literal("Found something " + depth + " below"), false);
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isIn(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.foodupdate.metal_detector.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
