package com.lld.designpatterns.factory;

public class ShapeFactory {
	public Shape getShapeObject(String shape) {
		switch (shape) {
		case "CIRCLE":
			return new Circle();
		case "SQUARE":
			return new Square();
		case "RECTANGLE":
			return new Rectangle();
		default:
			return null;
		}
	}
}
