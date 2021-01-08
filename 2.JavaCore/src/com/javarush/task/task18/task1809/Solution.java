package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        fileInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);
        for (int i = bytes.length - 1; i >= 0; i--) {
            fileOutputStream.write(bytes[i]);
        }
        fileOutputStream.close();
    }
}
