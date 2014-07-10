package com.my.list;

import java.util.LinkedList;

public class testLinkedList {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> la = new LinkedList<String>();
		LinkedList<String> lb = new LinkedList<String>();
		la.addLast("a0");
		la.addLast("a1");
		la.addLast("a2");
		la.addLast("a3");
		la.addLast("a4");
		la.addLast("n5");
		la.addLast("n6");
		la.addLast("n7");

		lb.addLast("b2");
		lb.addLast("b3");
		lb.addLast("b4");
		lb.addLast("n5");
		lb.addLast("n6");
		lb.addLast("n7");
		

		System.out.println("LinkedList a:" + la);
		System.out.println("LinkedList b:" + lb);
		//System.out.println("JointNode:" + findJointNode(la, lb));
	}

}
