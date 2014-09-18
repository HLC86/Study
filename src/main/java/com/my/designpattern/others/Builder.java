package com.my.designpattern.others;

import java.util.ArrayList;
import java.util.List;

import com.my.designpattern.factory.Circle;
import com.my.designpattern.factory.Shape;
import com.my.designpattern.factory.Square;

public class Builder {

	private List<Shape> list = new ArrayList<>();

	public void produceSquare(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new Square());
		}
	}

	public void produceCircle(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new Circle());
		}
	}
}
