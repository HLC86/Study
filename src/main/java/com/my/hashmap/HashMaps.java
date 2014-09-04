package com.my.hashmap;

import com.my.hashmap.HashMap;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

class MyObj {
	@Override
	public int hashCode() {
		return 1;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}
}

public class HashMaps {

	public static void main(String[] args) {
		sameKeyInMap();
	}

	public static void sameKeyInMap() {

		MyObj obj1 = new MyObj();
		MyObj obj2 = new MyObj();

		Map<MyObj, Integer> map = new HashMap<>();
		map.put(obj1, 1);
		map.put(obj2, 2);
		
		Iterator<Map.Entry<MyObj, Integer>> it = map.entrySet().iterator();
		while(it.hasNext()){
			System.out.println(it.next().getValue());
		}
		
		Integer i1 = 10;//10000
		Integer i2 = 10;//10000
		
		Map<Integer, Integer> map2 = new HashMap<>();
		map2.put(i1, 1);
		map2.put(i2, 2);
		
		Iterator<Map.Entry<Integer, Integer>> it2 = map2.entrySet().iterator();
		while(it2.hasNext()){
			System.out.println(it2.next().getValue());
		}
	}

	public static void testHashMap() {
		String a = new String("a");
		String b = new String("b");
		Map<String, String> map = new HashMap<String, String>();
		map.put(a, "aaa");
		map.put(b, "bbb");

		a = null;

		for (Object en : map.entrySet()) {
			System.out.println("map:" + ((Map.Entry) en).getKey() + ":"
					+ ((Map.Entry) en).getValue());
		}
	}

	public static void testWeekHashMap() {
		String a = new String("a");
		String b = new String("b");
		Map<String, String> weakmap = new WeakHashMap<String, String>();

		weakmap.put(a, "aaa");
		weakmap.put(b, "bbb");

		a = null;

		System.gc();

		for (Object en : weakmap.entrySet()) {
			System.out.println("weakmap:" + ((Map.Entry) en).getKey() + ":"
					+ ((Map.Entry) en).getValue());
		}
	}
}
