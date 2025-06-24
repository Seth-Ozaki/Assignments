package com.codingDojo.Devices;

public class Phone extends Device {

	public Phone() {
		super();
	}
	
	public void critical() {
		if(this.getBattery()<10) {
			System.out.printf("Battery Critical %d/100 \n", this.getBattery());
		}
	}

	public void call() {
		this.setBattery(this.getBattery() - 5);
		System.out.printf("Battery after call %d \n", this.getBattery());
		critical();
	}

	public void game() {
		
		if (this.getBattery() < 25) {
			System.out.printf("Battery too low \n Required 25/100 \n Current %d/100 \n", this.getBattery());
		} else {
			this.setBattery(this.getBattery() - 20);
			System.out.printf("Battery after game %d \n", this.getBattery());
			critical();
		}
	}
	
	public void charge() {
		if((this.getBattery()+50)>100) {
			this.setBattery(100);
			System.out.println("Battery 100/100");
		}else {
			this.setBattery(this.getBattery()+50);
			System.out.printf("Battery %d/100", this.getBattery());
		}
	}
}
