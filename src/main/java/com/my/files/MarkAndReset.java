package com.my.files;

import java.io.*;

/**
 * Created by Xiaoming Wang on 2014/11/4.
 */
public class MarkAndReset {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("1.txt")))) {
            reader.read();
            reader.mark(0);
            reader.mark(0);
            reader.read();
            reader.reset();
            reader.reset();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
