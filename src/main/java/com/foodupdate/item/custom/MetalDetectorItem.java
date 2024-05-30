package com.foodupdate.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

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
            for (int i = 0; i < yPos; i++) {
                BlockState state = context.getWorld().getBlockState(clickedBlockPos.down(i));

                if (isValuableBlock(state)) {
                    outputValuableCoordinates(clickedBlockPos.down(i), player, state.getBlock());
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

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString() + " " + ((int)player.getY() - blockPos.getY()) + " below"), false);
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.GOLD_ORE) || state.isOf(Blocks.DIAMOND_ORE);
    }
}
