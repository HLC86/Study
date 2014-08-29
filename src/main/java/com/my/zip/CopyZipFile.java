package com.my.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

public class CopyZipFile {

	// OK
	private static String saveTmp(InputStream in, String fileName) throws IOException {
		OutputStream outputStream = null;
		try {
			File file = new File("D:\\local\\esb\\data\\rcs_tmp\\" + fileName);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdir();
			}
			outputStream = new FileOutputStream(file);
			byte[] buffer = new byte[200];
			int i = 0;
			while ((i = in.read(buffer)) != -1) {
				outputStream.write(buffer, 0, i);
			}
			return file.getPath();
		} finally {
			if (outputStream != null)
				outputStream.close();
		}
	}

	// Not sure why failed ... maybe some error while convert to string
	private static String saveTmp2(InputStream in, String fileName) throws IOException {
		BufferedWriter writer = null;
		BufferedReader reader = null;
		try {
			File file = new File("D:\\local\\esb\\data\\rcs_tmp\\" + fileName);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdir();
			}
			writer = new BufferedWriter(new FileWriter(file));
			reader = new BufferedReader(new InputStreamReader(in));
			String lineString = null;
			while ((lineString = reader.readLine()) != null) {
				writer.write(lineString);
				System.out.println(lineString);
				writer.newLine();
			}
			return file.getPath();
		} finally {
			if (writer != null)
				writer.close();
			if (reader != null)
				reader.close();
		}
	}

	private static String saveTmp3(InputStream in, String fileName) throws IOException {
		OutputStream outputStream = null;
		try {
			File file = new File("D:\\local\\esb\\data\\rcs_tmp\\" + fileName);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdir();
			}
			outputStream = new FileOutputStream(file);
			byte[] buffer = new byte[200];
			while (in.read(buffer) != -1) {
				outputStream.write(buffer);
			}
			return file.getPath();
		} finally {
			if (outputStream != null)
				outputStream.close();
		}
	}

	private static String saveTmp4(InputStream in, String fileName) throws IOException {
		OutputStream outputStream = null;
		try {
			File file = new File("D:\\local\\esb\\data\\rcs_tmp\\" + fileName);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdir();
			}
			outputStream = new FileOutputStream(file);
			byte[] buffer = new byte[200];

			while (in.read(buffer) != -1) {
				String string = Arrays.toString(buffer);
				System.out.println(Arrays.toString(buffer));
				outputStream.write(getBytes(string));
			}
			return file.getPath();
		} finally {
			if (outputStream != null)
				outputStream.close();
		}
	}

	private static byte[] getBytes(String s) throws IOException {
		if (s == null || !s.endsWith("]") || !s.startsWith("["))
			throw new IOException();
		String buffString = s.substring(1, s.length() - 1);
		String[] buffStrings = buffString.split(",");
		byte[] buffer = new byte[buffStrings.length];
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = Byte.valueOf(buffStrings[i].trim());
		}
		// System.out.print(Arrays.toString(buffStrings));
		return buffer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			InputStream inputStream = new FileInputStream(
					"d:\\local\\esb\\data\\rcsdata\\ds21\\RCSKnowledgeItem\\1.zip");
			saveTmp4(inputStream, "1.txt.zip");
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
