package com.my.thread;

class R implements Runnable {

	private Object o;

	public R(Object o) {
		this.o = o;
	}

	public void run() {
		synchronized (o) {
			for (int i = 0; i < 10; i++) {
				System.out.println("a");
				o.notify();
			}
		}

	}

}

public class Thread3 implements Runnable {
	private Object o;

	public Thread3(Object o) {
		this.o = o;
	}

	public void run() {
		synchronized (o) {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
				try {
					o.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		Object o = new Object();
		new Thread(new Thread3(o)).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(new R(o)).start();

	}

}
