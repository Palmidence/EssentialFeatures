package net.anti_quark.EssentialFeatures.client;

import net.anti_quark.EssentialFeatures.common.CommonProxy;
import net.anti_quark.EssentialFeatures.common.block.ModBlocks;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit()
	{
    	super.preInit();
		ModBlocks.initModels();
	}
    
	@Override
	public void init()
	{
		super.init();
	}
	
	@Override
	public void postInit()
	{
		super.postInit();
	}
}
