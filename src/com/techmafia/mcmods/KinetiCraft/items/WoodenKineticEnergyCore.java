package com.techmafia.mcmods.KinetiCraft.items;

public class WoodenKineticEnergyCore extends BaseKineticEnergyCore
{
	public WoodenKineticEnergyCore()
	{
		super();
		
		this.setUnlocalizedName("woodenKineticEnergyCore");
		
		this.energyFromJumping = 1;
		this.energyFromMoving = 2;
		this.energyFromUsing = 5;
		this.overChargeBuffer = 10;
		this.maxEnergy=500;
		
		this.setMaxDamage(this.maxEnergy);
	}
	
	@Override
	protected boolean hasMultipleIcons()
	{
		return true;
	}
}