package com.codingdojo.zookeeper;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gorilla g1 = new Gorilla();
		Bat b1 = new Bat();
		
		//Gorilla test cases
		g1.displayEnergy();
		
		g1.throwSomething();
		g1.throwSomething();
		g1.throwSomething();
		g1.displayEnergy();
		
		g1.eatBanana();
		g1.eatBanana();
		g1.displayEnergy();
		
		g1.climb();
		g1.displayEnergy();
		
		
		//Bat test cases
		b1.displayEnergy();
		
		b1.attackTown();
		b1.attackTown();
		b1.attackTown();
		b1.displayEnergy();
		
		b1.eatHumans();
		b1.eatHumans();
		b1.displayEnergy();
		
		b1.fly();
		b1.fly();
		b1.displayEnergy();
	}

}
