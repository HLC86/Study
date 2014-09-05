package com.my.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncClass {
	Lock lock = new ReentrantLock();
	Object o = null;

	SyncClass(Object o) {
		this.o = o;
	}

	// Object oLock = new Object();

	public synchronized void testSync() {
		for (int i = 0; i < 10; i++) {
			System.out.println("SyncClass" + i);
		}
	}

	public void testSync2() {
		lock.lock();
		for (int i = 0; i < 10; i++) {
			System.out.println("SyncClass" + i);
		}
		lock.unlock();
	}

	public void testSync3() {
		synchronized (o) {
			try {
				o.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < 10; i++) {
				System.out.println("testSync3-" + i);
			}
		}
		// oLock.notify();
	}

	public void testSync4() {

		synchronized (o) {
			for (int i = 0; i < 10; i++) {
				System.out.println("testSync4-" + i);
			}

			o.notify();
		}
		// try {
		// wait();
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//

	}
}
