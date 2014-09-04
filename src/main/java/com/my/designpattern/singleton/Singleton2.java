package com.my.designpattern.singleton;

public class Singleton2 {
	
	private Singleton2(){
		
	}
	
	private static class SingletonFactory{
		private static Singleton2 instance = new Singleton2();
	}
	
	public Singleton2 getInstance(){
		return SingletonFactory.instance;
	}
}
