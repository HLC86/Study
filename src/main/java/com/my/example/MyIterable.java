package com.my.example;

public class MyIterable implements Iterable<String> {

	String[] arr;

	public MyIterable(String[] arr) {
		this.arr = arr;
	}

	public MyIterator iterator() {
		MyIterator iterator = new MyIterator(arr);
		return iterator;
	}

	public static void main(String[] argsStrings) {
		String[] ssStrings = { "a", "b", "c" };
		MyIterable iterable = new MyIterable(ssStrings);
		MyIterator iterator = iterable.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

        for(String s: iterable){

        }
	}

}
