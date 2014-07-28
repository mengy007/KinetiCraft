package com.techmafia.mcmods.KinetiCraft.blocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.techmafia.mcmods.KinetiCraft.KinetiCraft;
import com.techmafia.mcmods.KinetiCraft.tileentities.WoodenKineticEnergyCubeTileEntity;

public class WoodenKineticEnergyCube extends BaseKineticEnergyCube {

	public WoodenKineticEnergyCube(int id, Material par2Material) {
		super(id, par2Material);
		
		maxCores = 1;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
		ItemStack cube, core;
		EntityItem cubeEI, coreEI;
		WoodenKineticEnergyCubeTileEntity te = (WoodenKineticEnergyCubeTileEntity)world.getBlockTileEntity(x, y, z);
		
		// Check tile entity and drop cores if there were any
		if (te != null) {
			core = te.decrStackSize(0, 1);

			if (core != null) {
				//core.stackTagCompound = new NBTTagCompound();
				//core.stackTagCompound.setInteger("energyStored", energyStored);
				world.spawnEntityInWorld(new EntityItem(world, x, y, z, core));
			}
		} else {
			System.out.println("No tile entity found!");
		}

		// This drops the cube
		super.breakBlock(world, x, y, z, par5, par6);
	}
	
	public boolean hasTileEntity(int metadata)
	{
	    return true;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{		
    	TileEntity te = world.getBlockTileEntity(x, y, z);
        	
    	player.openGui(KinetiCraft.instance, 0, world, x, y, z);
        	
    	return true;
	}
	
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
	    itemStack.stackTagCompound = new NBTTagCompound();
	    itemStack.stackTagCompound.setInteger("energyStored", 0);
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		if (itemStack.stackTagCompound != null) {
            int energyStored = itemStack.stackTagCompound.getInteger("energyStored");
            list.add(EnumChatFormatting.GREEN + "RF stored: " + energyStored);
		}
	}
	
	/**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     */
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
    	WoodenKineticEnergyCubeTileEntity te = (WoodenKineticEnergyCubeTileEntity) world.getBlockTileEntity(x, y, z);

        return metadata;
    }

    //@Override
    public TileEntity createNewTileEntity(World world)
	{
    	System.out.println("Create new tile entity!");
        return new WoodenKineticEnergyCubeTileEntity();
	}  
}
