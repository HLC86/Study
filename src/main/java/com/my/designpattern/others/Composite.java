package com.my.designpattern.others;

import java.util.ArrayList;
import java.util.List;

class Employee {
	private String id;
	private String name;
	private List<Employee> subordinates;

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public Employee(String id, String name) {
		this.id = id;
		this.name = name;
		subordinates = new ArrayList<>();
	}

	public String toString() {
		return id + ": " + name;
	}

	public void add(Employee e) {
		subordinates.add(e);
	}

	public void remove(Employee e) {
		subordinates.remove(e);
	}
}

public class Composite {

	//Can be together with factory pattern
	public static void main(String[] args) {
		Employee ceo = new Employee("u1", "Tom");
		Employee manager1 = new Employee("u2", "zhangsan");
		Employee manager2 = new Employee("u3", "lisi");
		Employee e1 = new Employee("u4", "u4");
		Employee e2 = new Employee("u5", "u5");
		Employee e3 = new Employee("u6", "u6");
		Employee e4 = new Employee("u7", "u7");
		Employee e5 = new Employee("u8", "u8");

		ceo.add(manager1);
		ceo.add(manager2);
		
		manager1.add(e1);
		manager1.add(e2);
		manager2.add(e3);
		manager2.add(e4);
		manager2.add(e5);

		printAll(ceo);
	}

	private static void printAll(Employee e) {
		System.out.println(e);
		for (Employee e1 : e.getSubordinates()) {
			if (e1.getSubordinates().size() == 0)
				System.out.println(e1);
			else
				printAll(e1);
		}
	}

}
