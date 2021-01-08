package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileOutputStream fileOutputStream1 = new FileOutputStream(fileName1);
        FileInputStream fileInputStream2 = new FileInputStream(fileName2);

        byte[] bytes = new byte[fileInputStream2.available()];
        fileInputStream2.read(bytes);
        fileOutputStream1.write(bytes);
        fileInputStream2.close();

        fileOutputStream1 = new FileOutputStream(fileName1, true);
        FileInputStream fileInputStream3 = new FileInputStream(fileName3);
        bytes = new byte[fileInputStream3.available()];
        fileInputStream3.read(bytes);
        fileOutputStream1.write(bytes);
        fileInputStream3.close();
        fileOutputStream1.close();


    }
}
