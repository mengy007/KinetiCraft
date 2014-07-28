package com.techmafia.mcmods.KinetiCraft.items;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.techmafia.mcmods.KinetiCraft.tileentities.BaseKineticEnergyCubeTileEntity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WoodenKineticEnergyCore extends BaseKineticEnergyCore {
		
	public WoodenKineticEnergyCore(int par1) {
		super(par1);
		
		energyFromJumping = 1;
		energyFromMoving = 5;
		maxEnergy=10000;
	}

	// on item use, place BasicKineticEnergyCubeBlock
	// @SideOnly(Side.CLIENT)
	/*
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
		if (par7 != 1) {
			BaseKineticEnergyCubeTileEntity te = (BaseKineticEnergyCubeTileEntity)world.getBlockTileEntity(x, y, z);
			
			if (te != null && itemStack.stackTagCompound != null) {
				//player.addChatMessage(itemStack.stackTagCompound.getInteger("energyStored") + " RF");
				//te.insertCore(itemStack, player);
				
				return true;
			} else {
				return false;
			}
		} else {
			if (par2EntityPlayer.canPlayerEdit(x, y+1, z, par7, itemStack)) {
				world.setBlock(x, y+1, z, KinetiCraft.WoodenKineticEnergyCube.blockID);				
				world.notifyBlockOfNeighborChange(x, y+1, z, KinetiCraft.WoodenKineticEnergyCube.blockID);				
				--itemStack.stackSize;
				
				WoodenKineticEnergyCubeTileEntity te = (WoodenKineticEnergyCubeTileEntity) world.getBlockTileEntity(x, y+1, z);
				
				if (itemStack.stackTagCompound != null) {
					te.setEnergyStored(itemStack.stackTagCompound.getInteger("energyStored"));
				} else {
					par2EntityPlayer.addChatMessage("ERROR! no item NBT found!");
				}
					
				return true;
			} else {
				return false;
			}

			return false;
		}
	}
	*/
	
	// on update
	public void onUpdate(ItemStack itemStack, World par2World, Entity par3Entity, int par4, boolean inPlayerInv) {
		EntityPlayer ep = (EntityPlayer)par3Entity;
		
		if (prevDistanceWalkedModified == 0) {
			prevDistanceWalkedModified = ep.distanceWalkedModified;
		}

		if (itemStack.stackTagCompound == null) {
			createDefaultNBTTags(itemStack);
		}

		boolean isMoving = (ep.distanceWalkedModified - prevDistanceWalkedModified > 0) ? true : false;
		boolean isJumping = (ep.fallDistance > 0) ? true : false;
		boolean energyGained = false;
		int energyStored = itemStack.stackTagCompound.getInteger("energyStored");
		
		if (!par2World.isRemote) {
			if (energyStored <= maxEnergy) {
				if (isMoving) {
					energyStored += energyFromMoving;
					energyGained = true;
				}
				
				if (isJumping) {
					energyStored += energyFromJumping;
					energyGained = true;
				}
				
				if (energyGained) {
					if (itemStack.stackTagCompound != null) {
						itemStack.stackTagCompound.setInteger("energyStored", energyStored);
					}
				}
			}
		}
		
		prevDistanceWalkedModified = ep.distanceWalkedModified;
    }
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		if (itemStack.stackTagCompound != null) {
            int energyStored = itemStack.stackTagCompound.getInteger("energyStored");
            list.add(EnumChatFormatting.GREEN + "RF stored: " + energyStored);
		}
	}
	
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		createDefaultNBTTags(itemStack);
	}
	
	public void createDefaultNBTTags(ItemStack itemStack) {
		itemStack.stackTagCompound = new NBTTagCompound();
	    itemStack.stackTagCompound.setInteger("energyStored", 0);
	}
}