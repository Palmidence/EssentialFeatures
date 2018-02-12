package net.anti_quark.EssentialFeatures.common.loot;

import net.anti_quark.EssentialFeatures.common.item.ModItems;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModLootTables {

    public static LootEntry entry = new LootEntryItem(
            ModItems.PORTABLE_JUKEBOX, 100, 50, new LootFunction[0], new LootCondition[0], "essentialfeatures:loot_portable_jukebox");

    @SubscribeEvent
    public void onLootTableLoad(final LootTableLoadEvent event) {
        ResourceLocation name = event.getName();
        if(name.equals(LootTableList.CHESTS_DESERT_PYRAMID)
                || name.equals(LootTableList.CHESTS_ABANDONED_MINESHAFT)
                || name.equals(LootTableList.CHESTS_JUNGLE_TEMPLE)
                || name.equals(LootTableList.CHESTS_SIMPLE_DUNGEON)
                || name.equals(LootTableList.CHESTS_NETHER_BRIDGE)
                ) {
            System.out.println("injecting loot table");
            event.getTable().getPool("main").addEntry(entry);
        }
    }
}
