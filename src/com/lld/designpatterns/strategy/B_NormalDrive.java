package com.lld.designpatterns.strategy;

public class B_NormalDrive implements B_DriveStrategy{
	@Override
	public void drive() {
		System.out.println("Normal drive setup");
	}
}
