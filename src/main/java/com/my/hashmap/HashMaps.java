package com.my.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class HashMaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = new String("a");
		String b = new String("b");
		Map<String, String> weakmap = new WeakHashMap<String, String>();
//		Map<String, String> map = new HashMap<String, String>();
//		map.put(a, "aaa");
//		map.put(b, "bbb");

		weakmap.put(a, "aaa");
		weakmap.put(b, "bbb");

		//map.remove(a);

		a = null;
		//b = null;

		//System.gc();
		
//		for (Object en : map.entrySet()) {
//			System.out.println("map:" + ((Map.Entry) en).getKey() + ":" + ((Map.Entry) en).getValue());
//		}

		for (Object en : weakmap.entrySet()) {
			System.out.println("weakmap:" + ((Map.Entry) en).getKey() + ":" + ((Map.Entry) en).getValue());
		}

		System.out.print(new String(new char[] { (char) ('1' + 1) }));
	}

}
