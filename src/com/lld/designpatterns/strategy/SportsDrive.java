package com.lld.designpatterns.strategy;

public class SportsDrive implements DriveStrategy{
	@Override
	public void drive() {
		System.out.println("Special drive setup");
	}
	
}
