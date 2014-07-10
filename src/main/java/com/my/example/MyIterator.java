package com.my.example;

import java.util.Iterator;

public class MyIterator implements Iterator<String> {
    private String[] arr;
    private int index = 0;

    public MyIterator(String[] arr) {
        this.arr = arr;
    }

    public boolean hasNext() {
        return index < arr.length;
    }

    public String next() {
        return arr[index++];
    }

    public void remove() {
        System.out.println("ffffffffffff");
    }

}
