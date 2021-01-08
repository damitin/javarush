package com.javarush.task.task18.task1824;

import java.io.*;
import java.util.ArrayList;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        ArrayList<FileInputStream> streams = new ArrayList<>();

        while (true) {
            try {
                fileName = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                streams.add(fileInputStream);
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                for (FileInputStream stream : streams) {
                    try {
                        stream.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                break;
            }

        }
    }
}
