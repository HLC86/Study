package com.my.designpattern.factory;

public class SquareFactory implements Provider {

	@Override
	public Shape produce() {
		// TODO Auto-generated method stub
		return new Square();
	}

}
