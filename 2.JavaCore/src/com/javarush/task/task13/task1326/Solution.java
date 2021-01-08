package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fullFileName = reader.readLine();

        reader.close();

        List<Integer> inputEvenList = new ArrayList<>();

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fullFileName)));
        String line;
        while ((line = fileReader.readLine()) != null) {
            int i = Integer.parseInt(line);
            if (i % 2 == 0) inputEvenList.add(i);
        }

        fileReader.close();

        Collections.sort(inputEvenList);

        for (Integer temp : inputEvenList) {
            System.out.println(temp);
        }
    }
}
