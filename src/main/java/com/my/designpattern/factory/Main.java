package com.my.designpattern.factory;

public class Main {

	public static void main(String[] args) {
		create(new CircleFactory());
	}

	static void create(Provider p){
		p.produce().draw();
	}
}
