package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName;
        ArrayList<Integer> bytes = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        while (fileInputStream.available() > 0) {
            bytes.add(fileInputStream.read());
        }

        fileInputStream.close();

        Collections.sort(bytes);

        LinkedHashSet<Integer> noDuplicates = new LinkedHashSet<>(bytes);

        for (Integer integer : noDuplicates) {
            System.out.print(integer + " ");
        }
    }
}
