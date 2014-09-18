package com.my.exceptions;

import java.util.ArrayList;
import java.util.List;

public class RuntimeConstPoolOOM {

	// -XX:PermSize=10M -XX:MaxPermSize=10M
	public static void main(String[] args) {
		objectPoolTest2();
	}

	private static void constPoolTest() {
		String str1 = new StringBuilder("¼ÆËã»ú").append("Èí¼þ").toString();
		System.out.println(str1.intern() == str1);// true

		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);// false
	}

	private static void makeOOM() {
		List<String> list = new ArrayList<String>();
		int i = 0;
		while (true) {
			list.add(String
					.valueOf(i++ + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
					.intern());
		}// Nothing happens from jdk1.7
	}

	/*
	 * true
	 * true
	 * false
	 * true, unboxing
	 * */
	private static void objectPoolTest() {
		Integer i1 = 40;
		Integer i2 = 40;
		Integer i3 = 0;
		Integer i4 = new Integer(40);
		Integer i5 = new Integer(40);
		Integer i6 = new Integer(0);

		System.out.println(i1 == i2);
		System.out.println(i1 == i2 + i3);
		System.out.println(i4 == i5);
		System.out.println(i4 == i5 + i6);
		System.out.println();
	}
	
	/*
	 * false, autoboxing beyond of cache[-128, 127]
	 * true
	 * false
	 * true
	 * */
	private static void objectPoolTest2() {
		Integer i1 = 400;
		Integer i2 = 400;
		Integer i3 = 0;
		Integer i4 = new Integer(400);
		Integer i5 = new Integer(400);
		Integer i6 = new Integer(0);

		System.out.println(i1 == i2);
		System.out.println(i1 == i2 + i3);
		System.out.println(i4 == i5);
		System.out.println(i4 == i5 + i6);
		System.out.println();
	}
}
