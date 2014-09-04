package com.my.designpattern.factory;

public class ShapeFactory2 {
	
	public Shape produceCircle(){
		return new Circle();
	}
	
	public Shape produceSquare(){
		return new Square();
	}
}
