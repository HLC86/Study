package com.my.designpattern.adapter;

interface Sourceable {
	public void m1();

	public void m2();
}

abstract class Wrapper implements Sourceable {
	public void m1() {
	};

	public void m2() {
	};
}

class Source1 extends Wrapper {
	public void m1() {
		System.out.println("m1");
	}
}

class Source2 extends Wrapper {
	public void m2() {
		System.out.println("m2");
	}
}

public class AdapterInterface {

}
