package com.lld.designpatterns.decorator;

public class B_ExtraCheese extends B_ToppingDecorator{
	A_BasePizza basePizza;
	public B_ExtraCheese(A_BasePizza basePizza) {
		this.basePizza = basePizza;
	}
	@Override
	public double cost() {
		return this.basePizza.cost() + 50.0;
	}
}
