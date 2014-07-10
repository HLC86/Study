package com.my.thread;

public class Thread2 implements Runnable {
	SharedRes res = null;

	public Thread2(SharedRes res) {
		this.res = res;
	}

	public void run() {
			res.stop("t2");
			res.test("t2");

	}

}
