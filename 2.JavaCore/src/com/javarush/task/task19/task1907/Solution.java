package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
        Pattern pattern = Pattern.compile("\\bworld\\b");
        int count = 0;
        while (reader1.ready()) {
            Matcher matcher = pattern.matcher(reader1.readLine());
            while (matcher.find()) {
                count++;
            }
        }
        reader1.close();
        System.out.println(count);

    }
}
