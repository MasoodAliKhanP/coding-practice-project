package com.lld.designpatterns.decorator;

public class DriverClass {
	public static void main(String[] args) {
		A_BasePizza veggieDelightWithExtraCheese = new B_ExtraCheese(new A_VeggieDelight());
		System.out.println("veggie delight with extra cheese cost: " + veggieDelightWithExtraCheese.cost());
		
		A_BasePizza withMushroom = new B_Mushroom(veggieDelightWithExtraCheese);
		System.out.println("with mushrooms: " + withMushroom.cost());
	}
}
