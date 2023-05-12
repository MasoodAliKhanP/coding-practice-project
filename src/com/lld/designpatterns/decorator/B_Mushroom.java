package com.lld.designpatterns.decorator;

public class B_Mushroom extends B_ToppingDecorator{
	A_BasePizza basePizza;
	public B_Mushroom(A_BasePizza basePizza) {
		this.basePizza = basePizza;
	}
	@Override
	public double cost() {
		return this.basePizza.cost() + 40.0;
	}
}
