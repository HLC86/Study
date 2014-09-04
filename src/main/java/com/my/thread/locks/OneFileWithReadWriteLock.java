package com.my.thread.locks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class OneFileWithReadWriteLock {
	class MyFileReader implements Runnable {
		private ReadWriteLock lock;
		private String fileName;

		public MyFileReader(ReadWriteLock lock, String fileName) {
			this.lock = lock;
			this.fileName = fileName;
		}

		public void readFile() {
			while (true) {
				lock.readLock().lock();
				try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
					String line = null;
					while ((line = reader.readLine()) != null) {
						System.out.println("Reader " + System.currentTimeMillis() + ": "
								+ Thread.currentThread().getName() + ": " + line);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lock.readLock().unlock();
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		@Override
		public void run() {
			readFile();

		}
	}

	class MyFileWriter implements Runnable {
		private ReadWriteLock lock;
		private String fileName;

		public MyFileWriter(ReadWriteLock lock, String fileName) {
			this.lock = lock;
			this.fileName = fileName;
		}

		public void writeFile() {
			while (true) {
				lock.writeLock().lock();
				try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName,
						true)))) {

					Random r = new Random();
					int i = r.nextInt();
					writer.write("---->>>> " + i);
					writer.newLine();
					System.out.println("Writer " + System.currentTimeMillis() + ": " + Thread.currentThread().getName()
							+ ": " + "---->>>> " + i);
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lock.writeLock().unlock();
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		@Override
		public void run() {
			writeFile();

		}
	}

	public static void main(String[] args) {
		int readerCnt = 4;
		int writerCnt = 2;
		final String fileName = "/tmp/1.txt";
		ExecutorService readPool = Executors.newFixedThreadPool(readerCnt);
		ExecutorService writePool = Executors.newFixedThreadPool(writerCnt);
		ReadWriteLock lock = new ReentrantReadWriteLock();

		MyFileReader myReader = new OneFileWithReadWriteLock().new MyFileReader(lock, fileName);
		MyFileWriter myWriter = new OneFileWithReadWriteLock().new MyFileWriter(lock, fileName);

		for (int i = 0; i < readerCnt; i++) {
			readPool.execute(myReader);
		}

		for (int i = 0; i < writerCnt; i++) {
			writePool.execute(myWriter);
		}

	}

}
