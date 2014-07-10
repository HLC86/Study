package com.my.exceptions;

import java.util.ArrayList;
import java.util.List;

public class OOMHeap {

	static class OOMObject{}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError

		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}

}
