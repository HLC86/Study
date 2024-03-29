package com.my.designpattern.singleton;

public class Singleton1 {

	private static Singleton1 instance = null;
	
	private Singleton1(){
		
	}
	
	public Singleton1 getInstance(){
		if(instance == null){
			instance = new Singleton1();
		}
		
		return instance;
	}
}
