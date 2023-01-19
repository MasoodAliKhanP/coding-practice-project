package com.lld.designpatterns.factory;

public class DriverClass {
	public static void main(String[] args) {
		ShapeFactory sf = new ShapeFactory();
		Shape shape = sf.getShapeObject("SQUARE");
		shape.getShape();
		
	}
	
}
