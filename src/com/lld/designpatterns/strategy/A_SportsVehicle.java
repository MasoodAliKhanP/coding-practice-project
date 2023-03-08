package com.lld.designpatterns.strategy;

public class A_SportsVehicle extends A_Vehicle{
	public A_SportsVehicle() {
		super(new B_SportsDrive());
	}
}
