package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int[] charsFreq = new int[256];
        while (fileInputStream.available() > 0) {
            int i = fileInputStream.read();
            charsFreq[i]++;
        }
        fileInputStream.close();
        for (int i = 0; i < 256; i++) {
            if (charsFreq[i] == 0) continue;
            System.out.println((char) i + " " + charsFreq[i]);
        }

    }
}
