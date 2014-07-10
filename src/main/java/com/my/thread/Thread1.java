package com.my.thread;

public class Thread1 implements Runnable {
	SharedRes res = null;

	public Thread1(SharedRes res) {
		this.res = res;
	}

	public void run() {
		res.stop("t1");
		res.test("t1");

	}

}
