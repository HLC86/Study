package com.my.agrithm;

public class HeapSort {
	public void sort(int[] arr) {
		heapify(arr);
		int end = arr.length - 1;
		while (end > 0) {
			Sort.swap(arr, 0, end);
			end--;
			shiftDown(arr, 0, end);
		}
	}

	private void heapify(int[] arr) {
		int start = (arr.length - 2) / 2;
		while (start >= 0) {
			shiftDown(arr, start, arr.length - 1);
			start--;
		}
	}

	private void shiftDown(int[] arr, int start, int end) {
		int root = start;
		while (root * 2 + 1 <= end) {
			int child = root * 2 + 1;
			int swap = root;
			if (arr[swap] < arr[child]) {
				swap = child;
			}
			if (child + 1 <= end && arr[swap] < arr[child + 1]) {
				swap = child + 1;
			}
			if (swap != root) {
				Sort.swap(arr, swap, root);
				root = swap;
			}
			else
				return;
		}
	}
}
