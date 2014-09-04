package com.my.designpattern.factory;

public class CircleFactory implements Provider {

	@Override
	public Shape produce() {
		// TODO Auto-generated method stub
		return new Circle();
	}

}
