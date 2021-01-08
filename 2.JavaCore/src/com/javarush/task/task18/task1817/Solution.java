package com.javarush.task.task18.task1817;

import java.io.*;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream reader = new FileInputStream(args[0]);
        int allCharsCount = 0;
        int spacesCount = 0;
        int currentCharCode;

        while (reader.available() > 0) {
            currentCharCode = reader.read();
            if (currentCharCode == 32) spacesCount++;
            allCharsCount++;
        }
        reader.close();

        double res = 1.0 * spacesCount / allCharsCount * 100;
        System.out.printf("%.2f", res);
    }
}
