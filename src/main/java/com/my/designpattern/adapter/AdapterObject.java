package com.my.designpattern.adapter;

public class AdapterObject implements Targetable {

	private Source source;
	
	public AdapterObject(Source source){
		this.source = source;
	}

	@Override
	public void m1() {
		source.m1();
	}

	@Override
	public void m2() {
		System.out.println("m2");
	}
	
	
}
