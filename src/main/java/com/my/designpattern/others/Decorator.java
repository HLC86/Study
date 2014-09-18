package com.my.designpattern.others;

class Source{
	public void m1(){
		System.out.println("m1");
	}
}

interface Wrapper {
	public void m1();
}

class Source2 implements Wrapper{
	private Source source;
	
	public Source2(Source source){
		this.source = source;
	}

	@Override
	public void m1() {
		System.out.println("Before m1");
		source.m1();
		System.out.println("After m1");
	}
	
}

public class Decorator {

}
