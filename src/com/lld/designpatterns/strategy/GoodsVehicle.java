package com.lld.designpatterns.strategy;

public class GoodsVehicle extends Vehicle{
	public GoodsVehicle() {
		super(new NormalDrive());
	}
}
