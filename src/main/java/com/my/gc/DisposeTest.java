package com.my.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class foo {
	private int i = 0;
	private List<Integer> list = new ArrayList<>();

	public foo(int i) {
		this.i = i;
		System.out.println(String.format("object %d created", i));
		for (int j = 0; i < i; j++) {
			list.add(j);
		}
	}

	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println(String.format("object %d deleted", i));
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class DisposeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100000; i++) {
			foo f = new foo(i);
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// f = null;
			// System.gc();
		}

	}

}
