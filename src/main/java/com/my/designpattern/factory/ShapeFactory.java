package com.my.designpattern.factory;

public class ShapeFactory {
	public Shape getShape(String name) {
		if (name.equalsIgnoreCase("Circle"))
			return new Circle();
		else if (name.equalsIgnoreCase("Square"))
			return new Square();
		return new Angle();
	}
}
