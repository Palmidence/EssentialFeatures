package net.anti_quark.EssentialFeatures.common.item;

import java.util.HashSet;
import java.util.Set;

import net.anti_quark.EssentialFeatures.client.music.ModSound;
import net.anti_quark.EssentialFeatures.common.block.ModBlocks;
import net.anti_quark.EssentialFeatures.common.config.ModConfig;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.BlockStoneSlabNew;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.anti_quark.EssentialFeatures.common.item.ItemEFRecord;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	
	public static ItemCereal CEREAL;
	public static ItemCereal IRON_CEREAL;
	public static EFItem LONDON_CLAY;
	public static EFItem LONDON_BRICK;
	public static EFItem SAND_CLAY_MIXTURE;
	public static EFItem CREAM_BRICK;
	public static ItemEFRecord RECORD_SCARLET;
	public static ItemEFRecord RECORD_LOFI;

	public static void addItems () 
	{
		CEREAL = new ItemCereal("cereal", 1, 6, false);
		IRON_CEREAL = new ItemCereal("iron_cereal", 3, 6, true);
		LONDON_CLAY = new EFItem("london_clay", CreativeTabs.MATERIALS);
		SAND_CLAY_MIXTURE = new EFItem("sand_clay_mixture", CreativeTabs.MATERIALS);
		LONDON_BRICK = new EFItem("london_brick", CreativeTabs.MATERIALS);
		CREAM_BRICK = new EFItem("cream_brick", CreativeTabs.MATERIALS);
		RECORD_SCARLET = new ItemEFRecord("scarlet", ModSound.RECORD_SCARLET);
		RECORD_LOFI = new ItemEFRecord("lo-fi", ModSound.RECORD_LOFI);
	}
	
	@Mod.EventBusSubscriber
	public static class RegistrationHandler {
		public static final Set<Item> ITEMS = new HashSet<>();

		/**
		 * Register this mod's {@link Item}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			if (!ModConfig.items)
				return;

			final Item[] items = {
					CEREAL,
					IRON_CEREAL,
					LONDON_CLAY,
					SAND_CLAY_MIXTURE,
					LONDON_BRICK,
					CREAM_BRICK,
					RECORD_SCARLET,
					RECORD_LOFI
			};

			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final Item item : items) {
				registry.register(item);
				ITEMS.add(item);
			}
		}
		
		/**
		 * Register this mod's Item Models.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerItemBlockModels(ModelRegistryEvent event) {
			if (!ModConfig.items)
				return;

			CEREAL.initModel();
			IRON_CEREAL.initModel();
			LONDON_CLAY.initModel();
			SAND_CLAY_MIXTURE.initModel();
			LONDON_BRICK.initModel();
			CREAM_BRICK.initModel();
			RECORD_SCARLET.initModel();
			RECORD_LOFI.initModel();
		}
	}
}
