package com.codingdojo.zookeeper;

public class Mammal {

	protected int energy;
	protected int maxEnergy;
	
	public Mammal(int amount) {
		this.energy = amount;
		this.maxEnergy = amount;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public int getMaxEnergy() {
		return maxEnergy;
	}

	public int displayEnergy() {
		System.out.printf("Enery level: %d/%d \n", energy, maxEnergy);
		return energy;
	}
	
}
