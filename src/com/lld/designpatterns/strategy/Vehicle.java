package com.lld.designpatterns.strategy;

public class Vehicle {
	DriveStrategy driveStrategy;
	public Vehicle(DriveStrategy ds) {
		this.driveStrategy = ds;
	}
	
	void drive() {
		this.driveStrategy.drive();
	}
}
