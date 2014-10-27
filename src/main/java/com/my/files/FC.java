package com.my.files;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FC {
	public abstract class MyFile implements Runnable {
		protected String fileName;

		protected MyFile(String fileName) {
			this.fileName = fileName;
		}
	}

	public class Reader extends MyFile {

		public Reader(String fileName) {
			super(fileName);
		}

		@Override
		public void run() {
			Path p = Paths.get(fileName);
			try {
				FileChannel ch = FileChannel.open(p, StandardOpenOption.READ);
				ByteBuffer bb = ByteBuffer.allocate(10);
				while (ch.read(bb) > 0) {
					while (bb.hasRemaining()) {
						System.out.println(bb.getChar());
					}
					TimeUnit.SECONDS.sleep(1);
				}
				ch.close();
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public class Writer extends MyFile {

		protected Writer(String fileName) {
			super(fileName);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void run() {
			Path p = Paths.get(fileName);
			try {
				FileChannel ch = FileChannel.open(p, StandardOpenOption.WRITE);
				ch.position(ch.size());
				ByteBuffer bb = ByteBuffer.allocate(1);
				String newData = "New String to write to file..." + System.currentTimeMillis() + "\r\n";
				for (byte b : newData.getBytes()) {
					bb.put(b);
					bb.flip();
					while (bb.hasRemaining()) {
						ch.write(bb);
						System.out.println("Write ...");
						TimeUnit.SECONDS.sleep(1);
					}
					bb.clear();
				}
				ch.close();
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		String fileName = "1.txt";
		ExecutorService pool = Executors.newCachedThreadPool();
		pool.execute(new FC().new Reader(fileName));
		pool.execute(new FC().new Reader(fileName));
		//pool.execute(new FC().new Writer(fileName));
	}

}
