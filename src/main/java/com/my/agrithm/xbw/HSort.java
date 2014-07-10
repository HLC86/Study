package com.my.agrithm.xbw;

import java.util.Arrays;

public class HSort {

	static void heapfixupward(int[] a, int n) {
		int t;
		for (int i = (n - 1) / 2; i >= 0 && n != 0 && a[i] > a[n]; n = i, i = (n - 1) / 2) {
			t = a[i];
			a[i] = a[n];
			a[n] = t;
		}
	}

	static void heapfixdownward(int[] a, int i, int n) {
		int j = 2 * i + 1, t = a[i];
		while (i < n && j < n) {

			if (j + 1 < n && a[j] > a[j + 1])
				j++;
			if (t <= a[j])
				break;
			a[i] = a[j];
			i = j;
			j = 2 * i + 1;
		}
		a[i] = t;

	}

	static void hsort(int[] a, int m, int n) {
		for (int i = m; i <= n; i++) {
			heapfixupward(a, i);
		}
		int t;
		for (int i = n; i >= 1; i--) {
			t = a[i];
			a[i] = a[m];
			a[m] = t;
			heapfixdownward(a, m, i);
		}
	}

	public static void main(String[] args) {
		int[] a = { 4, 3, 1, 7, 9, 3, 2, 2, 0, 8, 11 };
		hsort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}
}
