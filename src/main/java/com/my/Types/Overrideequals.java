package com.my.Types;

public class Overrideequals {
	private int i=0;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Overrideequals other = (Overrideequals) obj;
		if (i != other.i)
			return false;
		return true;
	}

}
