package com.my.designpattern.adapter;

class Source {
	public void m1() {
		System.out.println("m1");
	}
}

interface Targetable {
	public void m1();

	public void m2();
}

public class AdapterClass extends Source implements Targetable {

	@Override
	public void m2() {
		System.out.println("m2");
	}
}
