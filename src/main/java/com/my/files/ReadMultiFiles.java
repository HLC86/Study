package com.my.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class ReadMultiFiles {

	public static void main(String[] args) {
		try {
			ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("1.dat.zip"));
			ZipEntry entry = null;
			int i = 0;
			while ((entry = zipInputStream.getNextEntry()) != null) {

				BufferedReader bReader = new BufferedReader(new InputStreamReader(zipInputStream, "UTF8"));
				File file = new File(i++ + ".xml");
//				if(file.exists()) {
//					file.delete();
//				}
				BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),
						"UTF8"));
				String line = null;
				while ((line = bReader.readLine()) != null) {
					bWriter.write(line);
					bWriter.newLine();
				}

				// DocumentBuilderFactory domFactory =
				// DocumentBuilderFactory.newInstance();
				// domFactory.setNamespaceAware(true);
				// DocumentBuilder builder = domFactory.newDocumentBuilder();
				// Document doc = builder.parse(zipInputStream);
				// // nodes = doc.getElementsByTagName("concept");
				// System.out.println(getDomainName(doc));

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// } catch (SAXException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (ParserConfigurationException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	private static String getDomainName(Document doc) {
		NodeList nodeList = doc.getElementsByTagName("itemMeta");
		String domainName = null;
		if (nodeList.getLength() < 1) {
			return null;
		}
		nodeList = nodeList.item(0).getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			String name = nodeList.item(i).getLocalName();
			if (name != null && name.equals("profile")) {
				domainName = nodeList.item(i).getTextContent();
			}
		}

		if (domainName == null) {
			return domainName;
		}

		Pattern p = Pattern.compile("KI-(.*?)(-product)*?");
		Matcher m = p.matcher(domainName);
		if (m.matches())
			return m.group(1);
		return null;
	}

	public static void test() {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		Future<?> resFuture = null;
		for (int i = 0; i < 10; i++) {
			resFuture = executor.submit(read());
			// System.out.println(Thread.currentThread().getName() + ": " + i);
		}

		if (resFuture != null) {
			try {
				resFuture.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(".................");
		System.out.println(executor.isTerminated());
		System.out.println(executor.isShutdown());
		// executor.submit(read());
	}

	private static Runnable read() {
		return new Runnable() {

			@Override
			public void run() {
				Random r = new Random();
				System.out.println(Thread.currentThread().getName() + ": " + r.nextInt());
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
	}
}
