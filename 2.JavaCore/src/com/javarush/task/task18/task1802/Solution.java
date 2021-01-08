package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName;
        int min = 256;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available() > 0) {
            int currentByte = fileInputStream.read();
            min = currentByte < min ? currentByte : min;
        }
        fileInputStream.close();
        System.out.println(min);
    }
}
