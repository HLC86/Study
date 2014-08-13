package com.my.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Logon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7183244237186828270L;
	private Date date = new Date();
	private String username;
	private transient String password;

	public Logon(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String toString() {
		return String.format("logon info: username: %s, date: %s, password: %s", username, date, password);
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Logon logon = new Logon("Hello", "world");
		System.out.println(logon);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("logon.out"));
		objectOutputStream.writeObject(logon);
		objectOutputStream.close();
		
		TimeUnit.SECONDS.sleep(1);
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("logon.out"));
		System.out.println("after");
		logon = (Logon)in.readObject();
		System.out.println(logon);
		in.close();
	}

}
