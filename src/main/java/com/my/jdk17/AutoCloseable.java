package com.my.jdk17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AutoCloseable {

	public static void main(String[] args) {
		//same as using( ... ) in c#
		//Suitable for all class implements AutoCloseable
		try (InputStream in = new FileInputStream("src.txt");
				OutputStream out = new FileOutputStream("dest.txt")) {
			byte[] buffer = new byte[1024];
			int n;
			while ((n = in.read(buffer)) >= 0) {
				out.write(buffer, 0, n);
			}
		} catch (FileNotFoundException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
