package com.my.designpattern.factory;

public class ShapeFactory3 {
	public static Shape produceCircle(){
		return new Circle();
	}
	
	public static Shape produceSquare(){
		return new Square();
	}
}
