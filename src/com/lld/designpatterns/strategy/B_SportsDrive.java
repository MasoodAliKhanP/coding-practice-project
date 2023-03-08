package com.lld.designpatterns.strategy;

public class B_SportsDrive implements B_DriveStrategy{
	@Override
	public void drive() {
		System.out.println("Special drive setup");
	}
	
}
