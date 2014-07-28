package com.techmafia.mcmods.KinetiCraft.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BaseKineticEnergyCubeTileEntity extends TileEntity implements IInventory {
	public int energyStored=0;
	protected ItemStack[] energyCores;
	
	public void insertCore(ItemStack itemStack, EntityPlayer player) { }
	
	public void setEnergyStored(int e) {
		energyStored = e;
	}
	
	public int getEnergyStored() {
		return energyStored;
	}
	
	protected int getCores() {
		int cores = 0;
		
		for (int i = 0; i < energyCores.length; i++) {
			if (energyCores[i] != null) {
				cores++;
			}
		}
		
		return cores;
	}
	
	protected int getMaxCores() {
		return 1;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
	   super.writeToNBT(par1NBTTagCompound);
       NBTTagList nbttaglist = new NBTTagList();

       for (int i = 0; i < this.energyCores.length; ++i)
       {
           if (this.energyCores[i] != null)
           {        	   
               NBTTagCompound nbttagcompound1 = new NBTTagCompound();
               nbttagcompound1.setByte("Slot", (byte)i);
               this.energyCores[i].writeToNBT(nbttagcompound1);
               nbttaglist.appendTag(nbttagcompound1);
           }
       }

       par1NBTTagCompound.setTag("Cores", nbttaglist);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
	   super.readFromNBT(par1NBTTagCompound);

	   System.out.println("Start NBT read");
	   
	   NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Cores");
       this.energyCores = new ItemStack[this.getMaxCores()];

       System.out.println(nbttaglist.tagCount() + " cores found in inventory");
       
       for (int i = 0; i < nbttaglist.tagCount(); ++i)
       {
           NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
           int j = nbttagcompound1.getByte("Slot") & 255;

           if (j >= 0 && j < this.energyCores.length)
           {
               this.energyCores[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
           }
       }
	}
	
	@Override
	public int getSizeInventory() {
		return this.energyCores.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return this.energyCores[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (this.energyCores[i] != null) {
			return this.energyCores[i];
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i)
    {
        if (this.energyCores[i] != null)
        {
            ItemStack itemstack = this.energyCores[i];
            this.energyCores[i] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		this.energyCores[i] = itemstack;

        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
        {
        	itemstack.stackSize = this.getInventoryStackLimit();
        }
		
	}

	@Override
	public String getInvName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return false;
	}
}
