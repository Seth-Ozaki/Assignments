package com.codingDojo.Devices;

public class Device {
	protected int battery;
	
	public Device() {
		this.battery = 100;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}
}
