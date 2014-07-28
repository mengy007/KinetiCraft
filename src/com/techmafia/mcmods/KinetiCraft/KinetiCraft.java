package com.techmafia.mcmods.KinetiCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import com.techmafia.mcmods.KinetiCraft.blocks.StoneKineticEnergyCube;
import com.techmafia.mcmods.KinetiCraft.blocks.WoodenKineticEnergyCube;
import com.techmafia.mcmods.KinetiCraft.gui.EnergyCubeGuiHandler;
import com.techmafia.mcmods.KinetiCraft.items.WoodenKineticEnergyCore;
import com.techmafia.mcmods.KinetiCraft.tileentities.StoneKineticEnergyCubeTileEntity;
import com.techmafia.mcmods.KinetiCraft.tileentities.WoodenKineticEnergyCubeTileEntity;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = KinetiCraft.modid, name = "Mengy007_KinetiCraft", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)

public class KinetiCraft {
	@Instance("Mengy007_KinetiCraft")
	public static KinetiCraft instance = new KinetiCraft();
	
	// define modid
	public static final String modid = "Mengy007_KinetiCraft";

	// define items
	public static Item WoodenKineticEnergyCore;
	public static Item StoneKineticEnergyCore;

	// define blocks
	public static Block WoodenKineticEnergyCube;
	public static Block StoneKineticEnergyCube;
	public static Block IronKineticEnergyCube;
	public static Block GoldKineticEnergyCube;
	public static Block DiamondKineticEnergyCube;
	
	// define tile entities
	public static TileEntity BasicKineticEnergyCubeTileEntity;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent preInitEvent) {
		/* Init Items */
		WoodenKineticEnergyCore = new WoodenKineticEnergyCore(4701);
		WoodenKineticEnergyCore.setMaxStackSize(1).setUnlocalizedName("BasicKineticEnergyCubeItem").setCreativeTab(CreativeTabs.tabRedstone).setTextureName("KinetiCraft:woodenKineticEnergyCore");
		
		//StoneKineticEnergyCore = new StoneKineticEnergyCore()
		
		/* Register Items */
		GameRegistry.registerItem(WoodenKineticEnergyCore, "WoodenKineticEnergyCore");

		/* Init blocks */
		WoodenKineticEnergyCube = new WoodenKineticEnergyCube(3701, Material.wood).setUnlocalizedName("WoodenKineticEnergyCube").setCreativeTab(CreativeTabs.tabRedstone).setTextureName("KinetiCraft:woodenKineticEnergyCube");
		StoneKineticEnergyCube = new StoneKineticEnergyCube(3702, Material.wood).setUnlocalizedName("StoneKineticEnergyCube").setCreativeTab(CreativeTabs.tabRedstone).setTextureName("KinetiCraft:stoneKineticEnergyCube0");
		
		/* Register blocks */
		GameRegistry.registerBlock(WoodenKineticEnergyCube, this.modid + WoodenKineticEnergyCube.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(StoneKineticEnergyCube, this.modid + StoneKineticEnergyCube.getUnlocalizedName().substring(5));

		/* Register tile entities */
		GameRegistry.registerTileEntity(WoodenKineticEnergyCubeTileEntity.class, "WoodenKineticEnergyCubeTileEntity");
		GameRegistry.registerTileEntity(StoneKineticEnergyCubeTileEntity.class, "StoneKineticEnergyCubeTileEntity");
		
		/* Register GUI stuff */
		NetworkRegistry.instance().registerGuiHandler(this.instance, new EnergyCubeGuiHandler());
		
		/* Items Crafting Recipes */
		GameRegistry.addRecipe(new ItemStack(WoodenKineticEnergyCore, 1), new Object[]{
			" W ",
			"WRW",
			" W ",
			'W', Block.planks,
			'R', Item.redstone
		});

		/* Blocks Crafting Recipes */
		GameRegistry.addRecipe(new ItemStack(WoodenKineticEnergyCube, 1), new Object[]{
			"WWW",
			"WLW",
			"WWW",
			'W', Block.planks,
			'L', Block.lever
		});
		/*
		GameRegistry.addRecipe(new ItemStack(StoneKineticEnergyCube, 1), new Object[]{
			"WWW",
			"WLW",
			"WWW",
			'W', Block.planks,
			'L', Block.lever
		});
		GameRegistry.addRecipe(new ItemStack(IronKineticEnergyCube, 1), new Object[]{
			"WWW",
			"WLW",
			"WWW",
			'W', Block.planks,
			'L', Block.lever
		});
		GameRegistry.addRecipe(new ItemStack(GoldKineticEnergyCube, 1), new Object[]{
			"WWW",
			"WLW",
			"WWW",
			'W', Block.planks,
			'L', Block.lever
		});
		GameRegistry.addRecipe(new ItemStack(DiamondKineticEnergyCube, 1), new Object[]{
			"WWW",
			"WLW",
			"WWW",
			'W', Block.planks,
			'L', Block.lever
		});
		*/
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		// init blocks
		
		//NetworkRegistry.instance().registerGuiHandler(this.instance, new WoodenKineticEnergyCubeGuiHandler());
		
		//GameRegistry.registerTileEntity(WoodenKineticEnergyCubeTileEntity.class, "WoodenKineticEnergyCubeTileEntity");
		//GameRegistry.registerTileEntity(StoneKineticEnergyCubeTileEntity.class, "StoneKineticEnergyCubeTileEntity");
	}
}