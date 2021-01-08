package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher;

        while (reader1.ready()) {
            String[] strings = reader1.readLine().split(" ");
            for (String string : strings) {
                matcher = pattern.matcher(string);
                if (matcher.find()) writer.write(string + " ");
            }
        }
        reader1.close();
        writer.close();
    }
}
