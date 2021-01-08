package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while (fileReader.ready()) {
            String currentLine = fileReader.readLine();
            String[] currentWords = currentLine.split(" ");
            ArrayList<String> currentWordsList = new ArrayList<>(Arrays.asList(currentWords));
            int count = 0;
            for (String word : words) {
                count += Collections.frequency(currentWordsList, word);
            }
            if (count == 2) System.out.println(currentLine);
        }
        fileReader.close();
    }
}
