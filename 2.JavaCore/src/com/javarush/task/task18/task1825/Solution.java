package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        ArrayList<String> fileNames = new ArrayList<>();

        while (!(fileName = reader.readLine()).equals("end")) {
            fileNames.add(fileName);
        }

        MyComparator myComparator = new MyComparator();

        Collections.sort(fileNames, myComparator);

        String finalFileName = fileNames.get(0).substring(0, fileNames.get(0).lastIndexOf(".part"));

        FileOutputStream fileOutputStream = new FileOutputStream(finalFileName);
        for (String currentFileName : fileNames) {
            FileInputStream fileInputStream = new FileInputStream(currentFileName);
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            fileInputStream.close();
            fileOutputStream.write(bytes);
        }
        fileOutputStream.close();

    }
}
