package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        while (reader.ready()) {
            String[] words = reader.readLine().split(" ");
            Pattern pattern = Pattern.compile("\\S*\\d+\\S*");
            for (String word: words) {
                Matcher matcher = pattern.matcher(word);
                if (matcher.matches()) writer.write(word + " ");
            }
        }
        reader.close();
        writer.close();
    }
}
