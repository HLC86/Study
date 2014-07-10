package com.my.thread;

public class SharedRes {

	int i = 0;
	private boolean done;

	public synchronized boolean isDone() {
		return done;
	}

	public synchronized void setDone(boolean done) {
		this.done = done;
	}

	public void test(String name) {
		// System.out.println("Test started ...");
		i = i + 1;
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + " " + i);
	}

	public synchronized void stop(String name) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (isDone()) {
			System.out.println(name + " stopped ...");
		} else {
			setDone(true);
		}
	}

	public synchronized static void test2() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("test2");
	}

	public synchronized static void test3() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("test3");
	}
}
