package com.my.designpattern.others;

import com.my.designpattern.factory.Shape;

public class Proxy implements Shape{
	private Circle circle;

	public Proxy() {
		circle = new Circle(1);
	}

	@Override
	public void draw() {
		circle.draw();
	}
}
