package com.my.thread;

public class VarsInThreads implements Runnable {

	public String s = "abc";
	private StringBuffer sb = new StringBuffer("xyz");
	private static int i = 0;
	private double d = 1;
	private MyClass mc = new MyClass();

	public VarsInThreads(String s, StringBuffer sb, double d) {
		this.s = s;
		this.sb = sb;
		//i = i1;
		this.d = d;
	}

	public void run() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s += "d";
		i++;
		d++;
		sb.append("z");
		String name = Thread.currentThread().getName();
		System.out.println(name + "|s:" + s);
		System.out.println(name + "|sb:" + sb);
		System.out.println(name + "|i:" + i);
		System.out.println(name + "|d:" + d);
		System.out.println(name + "|mc:" + mc);
		System.out.println();
	}

	public static void main(String[] args) {
		
		String s = "abc";
		StringBuffer sb = new StringBuffer("xyz");
		//static int i1 = 0;
		double d = 1;
		
		VarsInThreads obj = new VarsInThreads(s,sb,d);
		VarsInThreads obj2 = new VarsInThreads(s,sb,d);

		Thread t = new Thread(obj);
		t.start();

		Thread t2 = new Thread(obj2);
		t2.start();
	}
}