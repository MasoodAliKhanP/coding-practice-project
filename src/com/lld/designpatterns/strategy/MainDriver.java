package com.lld.designpatterns.strategy;

public class MainDriver {
	public static void main(String[] args) {
		A_Vehicle vh = new A_SportsVehicle();
		vh.drive();
		
		A_Vehicle vh2 = new A_GoodsVehicle();
		vh2.drive();
	}
}
