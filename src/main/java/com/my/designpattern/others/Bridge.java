package com.my.designpattern.others;

import com.my.designpattern.factory.Shape;

abstract class BridgeBase{
	private  Shape shape;

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}
	
	public abstract void action();
}

public class Bridge extends BridgeBase {

	@Override
	public void action() {
		getShape().draw();
	}

	public static void main(String[] args){
		Bridge b1 = new Bridge();
		b1.setShape(new com.my.designpattern.factory.Circle());
		b1.action();
		
		Bridge b2 = new Bridge();
		b2.setShape(new com.my.designpattern.factory.Angle());
		b2.action();
	}
}
