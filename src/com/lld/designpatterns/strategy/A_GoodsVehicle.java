package com.lld.designpatterns.strategy;

public class A_GoodsVehicle extends A_Vehicle{
	public A_GoodsVehicle() {
		super(new B_NormalDrive());
	}
}
