package com.lld.designpatterns.factory;

public class DriverClass {
	public static void main(String[] args) {
		B_ShapeFactory sf = new B_ShapeFactory();
		A_Shape shape = sf.getShapeObject("SQUARE");
		shape.getShape();
		
	}
	
}
