package com.foodupdate.mixin;

import com.foodupdate.FoodUpdate;
import com.foodupdate.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public class ItemRenderMixin {
    @ModifyVariable(method = "renderItem",at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useRubyStaffModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean lefthanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay){
        if(stack.isOf(ModItems.RUBY_STAFF) && renderMode != ModelTransformationMode.GUI)
        {
            return ((ItemRenderAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(FoodUpdate.MOD_ID, "ruby_staff_3d", "inventory"));
        }
        return value;
    }
}
