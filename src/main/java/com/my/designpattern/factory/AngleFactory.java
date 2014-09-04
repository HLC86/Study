package com.my.designpattern.factory;

public class AngleFactory implements Provider {

	@Override
	public Shape produce() {
		// TODO Auto-generated method stub
		return new Angle();
	}

}
