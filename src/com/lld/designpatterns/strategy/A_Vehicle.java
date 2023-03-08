package com.lld.designpatterns.strategy;

public class A_Vehicle {
	B_DriveStrategy driveStrategy;
	public A_Vehicle(B_DriveStrategy ds) {
		this.driveStrategy = ds;
	}
	
	void drive() {
		this.driveStrategy.drive();
	}
}
