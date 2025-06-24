package com.codingdojo.zookeeper;

public class Gorilla extends Mammal {
		
	public Gorilla() {
		super(100); 
	}
	
	public void throwSomething() {
		this.setEnergy(this.getEnergy()-5);
		System.out.println("💩💩💩 Throwing 'something'");
	}
	
	public void eatBanana() {
		this.setEnergy(this.getEnergy()-10);
		System.out.println("🍌🍌🍌 Mmmm banana");
	}
	
	public void climb() {
		this.setEnergy(this.getEnergy()-10);
		System.out.println("🐒🐒🐒 Monkey climb");
	}
}
