package com.leclowndu93150.nom.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.IceBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.BlueIceFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(IceBlock.class)
public class IceBlockMixin {

	// Cancel melting in randomTick
	@Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
	public void preventMeltingRandomTick(BlockState state, ServerWorld world, BlockPos pos, net.minecraft.util.math.random.Random random, CallbackInfo ci) {
		ci.cancel();
		System.out.println("Prevented Melting");
	}

	// Cancel melting in afterBreak
	@Inject(method = "afterBreak", at = @At("HEAD"), cancellable = true)
	public void preventMeltingAfterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack tool, CallbackInfo ci) {
		ci.cancel();
		System.out.println("Prevented Melting in After Break");
	}

	// Cancel melting in melt
	@Inject(method = "melt", at = @At("HEAD"), cancellable = true)
	protected void preventMeltingMelt(BlockState state, World world, BlockPos pos, CallbackInfo ci) {
		ci.cancel();
		System.out.println("Prevented Melting in melt !");
	}
}