package com.my.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainClass {

	public static void main(String[] args) {
		SharedRes res1 = new SharedRes();
		SharedRes res2 = new SharedRes();
		Thread1 t1 = new Thread1(res1);
		Thread2 t2 = new Thread2(res1);
		ScheduledExecutorService sch = Executors.newScheduledThreadPool(2);
		sch.scheduleAtFixedRate(t1, 0, 2, TimeUnit.SECONDS);
		sch.scheduleAtFixedRate(t2, 0, 3, TimeUnit.SECONDS);
		
//		Thread tt1 = new Thread(t1);
//		Thread tt2 = new Thread(t2);
//		tt1.start();
//		tt2.start();
		
	}

}
