package com.my.string;

public class Reverse {
	static void revertByChar(char[] arr, int start, int end) {
		for (int i = start; i <= start + (end - start) / 2; i++) {
			char c = arr[i];
			arr[i] = arr[end - i + start];
			arr[end - i + start] = c;
		}
	}

	static String revertByWord(String s) {
		char[] arr = s.toCharArray();
		revertByChar(arr, 0, arr.length - 1);

		int p1 = 0;
		int p2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ') {
				p2 = i - 1;
				revertByChar(arr, p1, p2);
				p1 = i + 1;
			}
		}
		revertByChar(arr, p1, arr.length - 1);

		return new String(arr);
	}

	public static void main(String[] args) {
		String s = "This is a word";
		System.out.println(revertByWord(s));
	}

}
