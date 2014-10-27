package com.my.files;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by Xiaoming Wang on 2014/10/22.
 */
public class ReadChar {
    public static void main(String[] args) {
        try {
//            ZipInputStream zip = new ZipInputStream(new FileInputStream("test.zip"), Charset.forName("UTF-8"));
//            ZipEntry entry = zip.getNextEntry();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(zip));
//            System.out.println(reader.readLine());
//            System.out.println("风采");

            //ZipFile file = new ZipFile("test.zip");
            //ZipEntry entry = (ZipEntry)file.getEntries().nextElement();
            //BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(entry)));
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("2.txt"), Charset.defaultCharset()));
            System.out.println(reader.readLine());
            //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("1.txt"), "UTF-16"));
            //writer.write(reader.readLine());
            //writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
