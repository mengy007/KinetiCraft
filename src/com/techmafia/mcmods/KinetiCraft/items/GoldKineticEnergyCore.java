package com.techmafia.mcmods.KinetiCraft.items;

public class GoldKineticEnergyCore extends BaseKineticEnergyCore
{
	public GoldKineticEnergyCore()
	{
		super();
		
		this.setUnlocalizedName("goldKineticEnergyCore");
		
		this.energyFromJumping 				= 4;
		this.energyFromMoving 				= 10;
		this.energyFromUsing 				= 15;
		this.overChargeBuffer 				= 30;
		this.maxEnergy						= 15000;
		this.hasMultipleIcons				= true;
		this.damageFromOverChargeExplosion 	= 3.0f;
		
		this.setMaxDamage(this.maxEnergy);
	}
}
