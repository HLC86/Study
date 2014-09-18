package com.my.performance;

import java.util.Random;

public class IFvsTRY {
	private static Random random = new Random();

	static void iftest(Object o) {
		if (o != null) {
			o.toString();
		}
	}

	static void trytest(Object o) {
		try {
			o.toString();
		} catch (Exception e) {
			return;
		}
	}

	static Integer RandomInt(int trigerPercent) {
		int i = random.nextInt(100);
		if (i < trigerPercent) {
			return null;
		}
		return i;
	}

	static void test(int exceptionPercent) {
		final int cnt = 100000;
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < cnt; i++) {
			iftest(RandomInt(exceptionPercent));
		}
		long t2 = System.currentTimeMillis() - t1;
		t1 = System.currentTimeMillis();

		for (int i = 0; i < cnt; i++) {
			trytest(RandomInt(exceptionPercent));
		}
		long t3 = System.currentTimeMillis() - t1;
		System.out.println(t2 + " " + t3);
	}

	public static void main(String[] args) {
		//for (int i = 0; i < 100; i++) {
			test(0);
		//}
	}

}
