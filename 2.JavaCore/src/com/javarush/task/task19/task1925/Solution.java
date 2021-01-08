package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder stringBuilder = new StringBuilder();
        String prefix = "";
        while (reader.ready()) {
            String[] words = reader.readLine().split(" ");
            for (String word : words) {
                if (word.length() > 6) {
                    stringBuilder.append(prefix);
                    prefix = ",";
                    stringBuilder.append(word);
                }
            }
        }
        reader.close();
        writer.write(stringBuilder.toString());
        writer.close();
    }
}
