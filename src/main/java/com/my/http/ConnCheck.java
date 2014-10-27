package com.my.http;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class ConnCheck {
    private static boolean test(String proxyHost, int port, String destination) {
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, port));
            URL url = new URL(destination);
            URLConnection urlConnection = url.openConnection(proxy);
            urlConnection.getInputStream().read();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static void main(String[] args) {

        try (BufferedReader dReader = new BufferedReader(new InputStreamReader(new FileInputStream("destination.txt")));
                BufferedReader pReader = new BufferedReader(new InputStreamReader(new FileInputStream("proxy.txt")))) {
            String destination;
            while ((destination = dReader.readLine()) != null) {
                String proxy;
                while ((proxy = pReader.readLine()) != null) {
                    String[] arr = proxy.split(":");
                    String host = arr[0];
                    int port = Integer.parseInt(arr[1]);
                    if (test(host, port, destination)) {
                        System.out.println(String.format("OK:-%s:%d-%s", host, port, destination));
                    } else {
                        System.out.println(String.format("FAILED:-%s:%d-%s", host, port, destination));
                    }
                }
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
