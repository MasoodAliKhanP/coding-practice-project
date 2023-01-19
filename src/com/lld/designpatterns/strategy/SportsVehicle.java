package com.lld.designpatterns.strategy;

public class SportsVehicle extends Vehicle{
	public SportsVehicle() {
		super(new SportsDrive());
	}
}
