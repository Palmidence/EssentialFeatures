package net.anti_quark.EssentialFeatures.common.block;

import net.minecraft.block.material.Material;

public class ModBlocks {

	public static BlockViewedBlock VIEWED_BLOCK;
	public static BlockSmoothGlowstone SMOOTH_GLOWSTONE;
	public static BlockPolishedGlowstone POLISHED_GLOWSTONE;
	public static BlockStainedLamp STAINED_LAMP;
	public static BlockStainedLamp LIT_STAINED_LAMP;
	public static BlockSnowBrick SNOW_BRICK;
	public static BlockBlockBreaker BLOCK_BREAKER;
	public static BlockCryingObsidian CRYING_OBSIDIAN;
	public static BlockSpike SPIKE_BLOCK;
	public static BlockBlockPlacer BLOCK_PLACER;
	
	public static void addBlocks() 
	{
        VIEWED_BLOCK = new BlockViewedBlock("viewed_block", Material.ROCK, 5, 5);
        SMOOTH_GLOWSTONE = new BlockSmoothGlowstone("smooth_glowstone", Material.GLASS, 1, 2);
        STAINED_LAMP = new BlockStainedLamp("stained_lamp", Material.GLASS, 0.3F, 1.5F, false);
        LIT_STAINED_LAMP = new BlockStainedLamp("lit_stained_lamp", Material.GLASS, 0.3F, 1.5F, true);
        POLISHED_GLOWSTONE = new BlockPolishedGlowstone("polished_glowstone", Material.GLASS, 1, 2);
        SNOW_BRICK = new BlockSnowBrick("snow_brick", Material.CRAFTED_SNOW, 1, 1);
        BLOCK_BREAKER = new BlockBlockBreaker("block_breaker", Material.PISTON, 5, 5);
        CRYING_OBSIDIAN = new BlockCryingObsidian("crying_obsidian", Material.ROCK, 100, 100);
        SPIKE_BLOCK = new BlockSpike("spike_block", Material.IRON, 1, 1);
        BLOCK_PLACER = new BlockBlockPlacer("block_placer", Material.ROCK, 5, 5);
    }

	public static void initModels() 
	{
		VIEWED_BLOCK.initModel();
		SMOOTH_GLOWSTONE.initModel();
		STAINED_LAMP.initModel();
		LIT_STAINED_LAMP.initModel();
		POLISHED_GLOWSTONE.initModel();
		SNOW_BRICK.initModel();
		BLOCK_BREAKER.initModel();
		CRYING_OBSIDIAN.initModel();
		SPIKE_BLOCK.initModel();
		BLOCK_PLACER.initModel();
	}
}
