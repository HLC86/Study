package com.my.designpattern.factory;

public class Main {

	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		Shape shape1 = factory.getShape("circle");
		shape1.draw();
		Shape shape2 = factory.getShape("square");
		shape2.draw();
		Shape shape3 = factory.getShape("angle");
		shape3.draw();
	}

}
