package com.my.agrithm.xbw;

import java.util.Arrays;

public class SQSort {

	static void qsort(int[] a, int low, int high) {
		int[] s = new int[200];
		s[0] = -1;
		int p = 0, mid;
		s[++p] = low;
		s[++p] = high;

		while (s[p] != -1) {
			high = s[p--];
			low = s[p--];
			if (low >= high)
				continue;
			else
				mid = p(a, low, high);
			s[++p] = low;
			s[++p] = mid;
			s[++p] = mid + 1;
			s[++p] = high;
		}
	}

	static int p(int[] a, int low, int high) {
		int p1 = low + 1, p2 = low, t = a[low];

		while (p1 < high) {
			if (a[p1] < t) {
				a[p2] = a[p1];
				a[p1] = a[++p2];

			}
			p1++;
		}
		a[p2] = t;
		return p2;
	}

	public static void main(String[] args) {
		int[] a = { 5, 3, 1, 2, 87, 0, 3, 9, 5, 1, 8 };
		qsort(a, 0, a.length);
		System.out.println(Arrays.toString(a));
	}
}
