package com.my.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

abstract class MyFile implements Runnable {
	protected ReadWriteLock lock;
	protected String name;

	public MyFile(String name, ReadWriteLock lock) {
		this.name = name;
		this.lock = lock;
	}
}

class MyFileReader1 extends MyFile {
	private BufferedReader reader;

	public MyFileReader1(String name, ReadWriteLock lock) {
		super(name, lock);
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(name)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			lock.readLock().lock();
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println("reader1: " + line);
			}
			lock.readLock().unlock();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class MyFileReader2 extends MyFile {
	private RandomAccessFile reader;

	public MyFileReader2(String name, ReadWriteLock lock) {
		super(name, lock);
		try {
			reader = new RandomAccessFile(name, "r");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			lock.readLock().lock();
			String line = null;// unicode ...
			while ((line = reader.readLine()) != null) {
				System.out.println("reader2: " + line);
			}
			lock.readLock().unlock();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class WriteFile extends MyFile {

	public WriteFile(String name, ReadWriteLock lock) {
		super(name, lock);
	}

	@Override
	public void run() {
		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name, true)))) {
			lock.writeLock().lock();
			Random r = new Random();
			String line = "---->>>> " + r.nextInt();
			writer.write(line);
			writer.newLine();
			System.out.println("Writer : " + line);
			lock.writeLock().unlock();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

public class FileSeek {
	private static void rwLock() {
		String file = "/tmp/1.txt";
		ReadWriteLock lock = new ReentrantReadWriteLock();
		MyFile reader1 = new MyFileReader1(file, lock);
		MyFile reader2 = new MyFileReader2(file, lock);
		MyFile writer = new WriteFile(file, lock);
		ScheduledExecutorService exe = Executors.newScheduledThreadPool(3);
		exe.scheduleAtFixedRate(reader1, 0, 2, TimeUnit.SECONDS);
		exe.scheduleAtFixedRate(reader2, 0, 2, TimeUnit.SECONDS);
		exe.scheduleAtFixedRate(writer, 0, 1, TimeUnit.SECONDS);
	}

	public static void main(String[] args) {

	}

}
