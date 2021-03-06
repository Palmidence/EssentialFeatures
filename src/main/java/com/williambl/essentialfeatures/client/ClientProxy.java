package com.williambl.essentialfeatures.client;

import com.williambl.essentialfeatures.client.render.entity.PandaRenderFactory;
import com.williambl.essentialfeatures.common.CommonProxy;
import com.williambl.essentialfeatures.common.entity.EntityPanda;
import com.williambl.essentialfeatures.common.entity.ModEntities;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit()
	{
		super.preInit();
		ModEntities.initRenderers();
	}
    
	@Override
	public void init()
	{
		super.init();
		ClientEventHandler handler = new ClientEventHandler();
		MinecraftForge.EVENT_BUS.register(handler);
 	}
	
	@Override
	public void postInit()
	{
		super.postInit();
	}
}
