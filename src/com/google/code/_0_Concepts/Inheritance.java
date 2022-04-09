package com.google.code._0_Concepts;

import java.math.BigDecimal;

class Shape{
	private String name;

	public Shape(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class Circle extends Shape{
	private final BigDecimal PI = new BigDecimal("3.17");
	private BigDecimal radius;

	public Circle(String name, BigDecimal radius) {
		super(name);
		this.radius = radius;
	}

	public BigDecimal getRadius() {
		return radius;
	}
	
	public BigDecimal area() {
		return radius.multiply(radius).multiply(PI);
	}
}

public class Inheritance {
	public static void main(String[] args) {
		Shape sh = new Shape("no shape");
		
		Circle c = new Circle("circle", new BigDecimal("3.1"));
		System.out.println("circle area: " + c.area());
		
		Circle c2 = (Circle) getShape();
		System.out.println("c2 area: " + c2.area());
		
		Shape sh2 = new Circle("sh2", new BigDecimal("1"));
		((Circle)sh2).area();
		
		Circle c3 = (Circle) new Shape("c3");
		System.out.println("c3 area: " + c3.area());
		
		
	}
	
	private static Shape getShape() {
		Circle c = new Circle("circle", new BigDecimal("2"));
		return (Shape)c;
	}
	
	
}
