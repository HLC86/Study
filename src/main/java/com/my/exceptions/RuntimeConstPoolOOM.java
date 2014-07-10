package com.my.exceptions;

import java.util.ArrayList;
import java.util.List;

public class RuntimeConstPoolOOM {

	//-XX:PermSize=10M -XX:MaxPermSize=10M
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		int i = 0;
		while (true) {
			list.add(String.valueOf(i+++"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").intern());
		}
	}

}
