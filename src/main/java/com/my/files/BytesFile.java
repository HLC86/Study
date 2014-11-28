package com.my.files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Xiaoming Wang on 2014/11/25.
 */
public class BytesFile {
    public static void main(String[] args) throws IOException {
        InputStream is = Files.newInputStream(Paths.get("/tmp/flow/c2851dd780f54cd1bb4733f965f94a9b"));
        ByteArrayInputStream ba = (ByteArrayInputStream)is;
        BufferedReader reader = new BufferedReader(new InputStreamReader(ba));
        System.out.println(reader.readLine());
    }
}
