package com.lld.designpatterns.factory;

public class B_ShapeFactory {
	public A_Shape getShapeObject(String shape) {
		switch (shape) {
		case "CIRCLE":
			return new A_Circle();
		case "SQUARE":
			return new A_Square();
		case "RECTANGLE":
			return new A_Rectangle();
		default:
			return null;
		}
	}
}
