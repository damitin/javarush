package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName;
        int max = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available() > 0) {
            int currentByte = fileInputStream.read();
            max = currentByte > max ? currentByte : max;
        }
        fileInputStream.close();
        System.out.println(max);
    }
}
