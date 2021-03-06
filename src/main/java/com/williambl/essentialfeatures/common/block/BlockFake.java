package com.williambl.essentialfeatures.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

public class BlockFake extends Block {
	
	IBlockState realBlockState;

	//This can be used if you want to place an unplaceable block
	public BlockFake(String registryName, CreativeTabs tab, IBlockState realBlockState) {
        super(Material.AIR);
        this.setCreativeTab(tab);
        this.setRegistryName(registryName);
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.realBlockState = realBlockState;
	}
	
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
    
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
    		return realBlockState;
    }
}
