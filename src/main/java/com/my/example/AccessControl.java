package com.my.example;

class A2 {
	private int x = 0;

	protected int getX() {
		return x;
	}
}

// The levels of access control from ��most access�� to ��least access�� are public,
// protected, package access (which has no keyword), and private
public class AccessControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A2 a = new A2();
		a.getX();// protected is the same as package access when in the same
					// package.
		//A1 a1 = new A1();
		// a1.getX();
	}

}
