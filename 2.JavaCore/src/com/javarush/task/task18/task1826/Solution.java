package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args[0].equals("-e")) encrypt(args[1], args[2]);
        if (args[0].equals("-d")) decrypt(args[1], args[2]);
    }

    public static void encrypt (String fileName1, String fileName2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName1);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        fileInputStream.close();

        byte zeroByteValue = bytes[0];

        for (int i = 0; i < bytes.length; i++) {
            if (i == bytes.length - 1) {
                bytes[i] = zeroByteValue;
            } else bytes[i] = bytes[i + 1];
        }

        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }

    public static void decrypt (String fileName1, String fileName2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName1);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        fileInputStream.close();

        byte lastByteValue = bytes[bytes.length - 1];

        for (int i = bytes.length - 1; i >= 0; i--) {
            if (i == 0) {
                bytes[i] = lastByteValue;
            } else bytes[i] = bytes[i - 1];
        }

        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }

}
