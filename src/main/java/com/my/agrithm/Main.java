package com.my.agrithm;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// int[][] arr = { { 1, 2, 3, 10 }, { 4, 5, 6, 11 }, { 7, 8, 9, 12 },
		// { 13, 14, 15, 16 } };
		// spirallyPrint(arr);

		int[] arr2 = new int[] { 1, 0, 10, 20, 3, 5, 6, 4, 9, 8, 12, 17, 34, 11 };

		// Sort
		Sort sort2 = new Sort();
		// sort2.quickSort(arr2, 0, arr2.length - 1);
		// sort2.bubbleSort(arr2);
		// sort2.selectionSort(arr2);
		// sort2.insertionSort(arr2);
		// sort2.insertionSort2(arr2);
		//sort2.shellSort(arr2);
        sort2.mergeSort(arr2,0, arr2.length-1);

		// heap sort
//		HeapSort sort1 = new HeapSort();
//		sort1.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		
	}

	static void spirallyPrint(int[][] arr) {

		// Spirally print the array
		int sx = 0, ex = 3, sy = 0, ey = 3;
		while (sx <= ex && sy <= ey) {
			int i = 0;
			for (i = sx; i <= ex; i++) {
				System.out.print(arr[sy][i] + " ");
			}
			sy++;
			for (i = sy; i <= ey; i++) {
				System.out.print(arr[i][ex] + " ");
			}
			ex--;
			for (i = ex; i >= sx; i--) {
				System.out.print(arr[ey][i] + " ");
			}
			ey--;
			for (i = ey; i >= sy; i--) {
				System.out.print(arr[i][sx] + " ");
			}
			sx++;
		}

	}
}
