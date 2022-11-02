package net.mcreator.levelingpickaxe.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.levelingpickaxe.network.LevelingPickaxeModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BlockBrokenProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y, z))).getMaterial() == net.minecraft.world.level.material.Material.STONE) {
			LevelingPickaxeModVariables.WorldVariables.get(world).BlockBroken = LevelingPickaxeModVariables.WorldVariables.get(world).BlockBroken + 1;
			LevelingPickaxeModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
