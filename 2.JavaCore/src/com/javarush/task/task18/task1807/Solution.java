package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName;
        int commaCounter = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        while (fileInputStream.available() > 0) {
            if (fileInputStream.read() == 44) commaCounter++;
        }
        fileInputStream.close();


        System.out.println(commaCounter);
    }
}
