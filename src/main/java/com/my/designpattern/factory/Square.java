package com.my.designpattern.factory;

public class Square implements Shape {
	private final int i;

	public Square() {
		this.i = 0;
	}

	public void draw() {
		System.out.println("Square" + i);
	}

}
