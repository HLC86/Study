package com.my.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class HttpConn {

	public static void main(String[] args) {
		try {

			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.86.33.21", 8080));
            String urlStr = "http://www.baidu.com";
            // urlStr = URLEncoder.encode(urlStr);

            URL url = new URL(urlStr);
            URLConnection urlConnection = url.openConnection(proxy);
            urlConnection.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                        urlConnection.getInputStream(), "UTF-8"));

            String str = br.readLine();

            System.out.println(str);
            
            
//            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("123.0.0.1", 8080));
//            URL url = new URL("http://www.yahoo.com");
//            HttpURLConnection uc = (HttpURLConnection)url.openConnection(proxy);
//            uc.connect();

      } catch (Exception ex) {
            ex.printStackTrace();
      }

	}

}
