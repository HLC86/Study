package com.my.designpattern.others;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.my.hashmap.HashMap;

abstract class Shape implements Cloneable {
	int id;

	abstract void draw();

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public Object clone2() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);

		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}

	public int getId() {
		return id;
	}
}

class Circle extends Shape {
	public Circle(int id) {
		this.id = id;
	}

	@Override
	void draw() {
		System.out.println("Circle");
	}
}

class Angle extends Shape {
	public Angle(int id) {
		this.id = id;
	}

	@Override
	void draw() {
		System.out.println("Angle");
	}

}

public class Prototype {
	private static HashMap<Integer, Shape> cache = new HashMap<>();

	public static Shape get(int id) {
		Shape shape = null;
		try {
			shape = (Shape) cache.get(id).clone2();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shape;
	}

	public static void loadCache() {
		Circle c = new Circle(1);
		cache.put(c.getId(), c);
		Angle a = new Angle(2);
		cache.put(a.getId(), a);
	}
}
