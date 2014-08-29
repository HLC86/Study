package com.my.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class LineThread implements Runnable{
	private Integer i = 0;
	private String fileName = null;
	
	public LineThread(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void run() {
		synchronized (i) {

		}
	}
	
	private void print(String line) {
		
	}
}

public class MultiThreadOneFile {
	
	public static void putKnowledgeItems() {
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		Future<?> task = null;
		for (int i=0;i<100;i++) {
			
			task = threadPool .submit(new Runnable() {

				@Override
				public void run() {
					//InsertLine2DB(entity);
					System.out.println(" ...");
					try {
						TimeUnit.SECONDS.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}

		try {
			task.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		putKnowledgeItems();
	}

}
