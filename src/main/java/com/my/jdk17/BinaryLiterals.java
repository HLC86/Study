package com.my.jdk17;

import java.util.ArrayList;
import java.util.List;

public class BinaryLiterals {

	public static void main(String[] args) {
		int mask = 0b010101010101;
		short a = (short) 0b1000110101;
		long b = 0b1000000000000000000001L;

		int mask2 = 0b1010_1010;
		long b2 = 90000_10000L;
		long h = 0xFF_EE_01;
		
		List<String> list = new ArrayList<>();
	}

	// It produces generally more efficient byte codes than an if-then-else
	// statement.
	private static void testswitch(String s) {
		switch (s) {
		case "A":
			System.out.println("A");
			break;
		case "B":
			System.out.println("B");
			break;
		default:
			System.out.println("Others");
		}
	}

}
