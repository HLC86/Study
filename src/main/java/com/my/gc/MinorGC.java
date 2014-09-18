package com.my.gc;

public class MinorGC {

	private static final int _1MB = 1024 * 1024;

	public static void main(String[] args) {
		// -verbose:gc -Xms20M -Xmx20M -XX:+PrintGCDetails

		byte[] a1, a2, a3, a4,a5;
		//while(true)
		{
		a1 = new byte[1 * _1MB];
		a2 = new byte[2 * _1MB];
		a3 = new byte[2 * _1MB];
		a5 = new byte[2 * _1MB];
		a4 = new byte[4 * _1MB];}
	}

}
