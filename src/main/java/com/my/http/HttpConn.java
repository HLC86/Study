package com.my.http;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class HttpConn {

	public static void main(String[] args) {
		RestReqWithXml();
	}

	private static void RestReqWithXml() {

		try (InputStream is = new FileInputStream("request.xml")) {
			byte[] buffer = new byte[255];
			URL url = new URL("http://10.43.152.184/EANService/V2/EAN");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml");
			OutputStream oStream = conn.getOutputStream();
			int n = 0;
			while ((n = is.read(buffer)) > 0) {
				oStream.write(buffer, 0, n);
			}
			oStream.flush();
			conn.connect();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

			String str = null;
			System.out.println(conn.getResponseCode());
			while ((str = br.readLine()) != null)
				System.out.println(str);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void basic() {
		try {

			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.86.33.21", 8080));
			String urlStr = "http://www.baidu.com";
			// urlStr = URLEncoder.encode(urlStr);

			URL url = new URL(urlStr);
			URLConnection urlConnection = url.openConnection(proxy);
			urlConnection.connect();

			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

			String str = br.readLine();

			System.out.println(str);

			// Proxy proxy = new Proxy(Proxy.Type.HTTP, new
			// InetSocketAddress("123.0.0.1", 8080));
			// URL url = new URL("http://www.yahoo.com");
			// HttpURLConnection uc =
			// (HttpURLConnection)url.openConnection(proxy);
			// uc.connect();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
