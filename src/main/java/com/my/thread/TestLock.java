package com.my.thread;

class P {
	public void printN(int i) {
		System.out.print(i * 2 + 1);
		System.out.print(i * 2 + 2);
	}

	public void printC(int i) {
		System.out.println((char) ('A' + i));
	}
}

class foo1 implements Runnable {

	private P p1;

	public foo1(P p1) {
		this.p1 = p1;
	}

	public void print() {

		for (int i = 0; i < 26; i++) {
			synchronized (p1) {
				try {
					p1.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				p1.printC(i);
				p1.notify();
			}
		}
	}

	public void run() {
		print();
	}
}

class foo2 implements Runnable {

	private P p1;

	public foo2(P p1) {
		this.p1 = p1;
	}

	public void print() {

		for (int i = 0; i < 26; i++) {
			synchronized (p1) {
				p1.notify();
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				p1.printN(i);
				try {
					p1.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void run() {
		print();
	}
}

public class TestLock {

	public static void main(String[] args) {

		P p1 = new P();
		foo1 f1 = new foo1(p1);
		foo2 f2 = new foo2(p1);
		new Thread(f1).start();
		new Thread(f2).start();
	}

}
