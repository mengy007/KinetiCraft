package com.techmafia.mcmods.KinetiCraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.techmafia.mcmods.KinetiCraft.KinetiCraft;
import com.techmafia.mcmods.KinetiCraft.tileentities.WoodenKineticEnergyCubeTileEntity;

public class StoneKineticEnergyCube extends KCBlock {

	public StoneKineticEnergyCube(Material material) {
		super(material);
		
		this.setHardness(0.2f);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{		
    	TileEntity te = world.getTileEntity(x, y, z);
    
    	player.addChatMessage(new ChatComponentText("click"));
    
    	player.openGui(KinetiCraft.instance, 1, world, x, y, z);
    	
    	return true;
	}
	
	@Override
    public TileEntity createNewTileEntity(World world, int metadata)
	{
        return new WoodenKineticEnergyCubeTileEntity();
	}
	
	@Override
	public boolean hasTileEntity(int metadata)
	{
	    return true;
	}

}
