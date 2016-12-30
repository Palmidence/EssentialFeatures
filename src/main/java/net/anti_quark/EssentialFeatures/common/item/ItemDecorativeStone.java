package net.anti_quark.EssentialFeatures.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemColored;
import net.minecraft.item.ItemStack;

public class ItemDecorativeStone extends ItemBlock {
	
	private String[] subtypeNames;

	public ItemDecorativeStone(Block block, boolean hasSubtypes, String[] names) {
		super(block);
		
        if (hasSubtypes)
        {
            this.setMaxDamage(0);
            this.setHasSubtypes(true);
            this.setSubtypeNames(names);
        }
	}
	
    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }
    
    public ItemDecorativeStone setSubtypeNames(String[] names)
    {
        this.subtypeNames = names;
        return this;
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        if (this.subtypeNames == null)
        {
            return super.getUnlocalizedName(stack);
        }
        else
        {
            int i = stack.getMetadata();
            return i >= 0 && i < this.subtypeNames.length ? super.getUnlocalizedName(stack) + "." + this.subtypeNames[i] : super.getUnlocalizedName(stack);
        }
    }

}
