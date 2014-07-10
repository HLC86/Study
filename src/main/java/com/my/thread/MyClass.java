package com.my.thread;

class MyClass {

	public int i = 11;

	public String toString() {
		return i++ + "";
	}

	public boolean equals(MyClass o) {
		if (o.hashCode() == this.hashCode())
			return true;
		return false;
	}

	public int hashCode() {
		return this.toString().hashCode();
	}
}
