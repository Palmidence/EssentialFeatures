package net.anti_quark.EssentialFeatures.common.item;

import net.anti_quark.EssentialFeatures.client.music.MovingSoundGeneric;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.lwjgl.input.Mouse;

public class ItemPortableJukebox extends EFItem {

    public ItemRecord record;

    public ItemPortableJukebox (String registryName, CreativeTabs tab, ItemRecord recordIn) {
        super(registryName, tab);
        record = recordIn;
    }

    @Override
    public boolean initCapabilities () {
        ICapabilityProvider
    }

     /**
     * Called when a Block is right-clicked with this Item
     */
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack stack = player.getHeldItem(hand);

        NBTTagCompound nbt;
        if (stack.hasTagCompound())
            nbt = stack.getTagCompound();
        else
            nbt = new NBTTagCompound();

        if (openGUIIfNeeded(stack, worldIn, player, nbt, hand))
            return EnumActionResult.SUCCESS;

        if (worldIn.isRemote)
            Minecraft.getMinecraft().getSoundHandler().playSound(new MovingSoundGeneric(player, record.getSound()));
        return EnumActionResult.SUCCESS;
    }

    protected boolean openGUIIfNeeded (ItemStack stack, World worldIn, EntityPlayer playerIn, NBTTagCompound nbt, EnumHand hand) {
        NBTTagCompound tag = nbt.getCompoundTag("record");

        boolean needsRecord = (tag == null || tag.hasNoTags() || playerIn.isSneaking());

        if (needsRecord & !worldIn.isRemote) {
            //TODO: Open GUI with one slot to put record in
            System.out.println("open gui now");
            stack.writeToNBT(nbt);
        }

        stack.setTagInfo("record", nbt);
        playerIn.setHeldItem(hand, stack);
        return needsRecord;
    }
}
