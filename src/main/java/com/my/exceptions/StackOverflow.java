package com.my.exceptions;

public class StackOverflow {
	private int sl = 1;

	public void stackLeak() {
		sl++;
		stackLeak();
	}

	public static void main(String[] args) throws Throwable {
		StackOverflow sof = new StackOverflow();
		try {

			sof.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack len: " + sof.sl);
			throw e;
		}
	}

}
