package com.lld.designpatterns.strategy;

public class MainDriver {
	public static void main(String[] args) {
		Vehicle vh = new SportsVehicle();
		vh.drive();
		
		Vehicle vh2 = new GoodsVehicle();
		vh2.drive();
	}
}
