package com.techmafia.mcmods.KinetiCraft.items;

import net.minecraft.item.Item;

public class BaseKineticEnergyCore extends Item {
	protected int energyFromJumping = 0;
	protected int energyFromMoving = 0;
	protected float prevDistanceWalkedModified = 0;
	public int maxEnergy = 0;
	
	public BaseKineticEnergyCore(int id) {
		super(id);
	}
}
