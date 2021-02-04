package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        List<String> list = new ArrayList<>();
        while (fileReader.ready()) {
            String[] strings = fileReader.readLine().split(" ");
            list.addAll(Arrays.asList(strings));
        }

        //...
        StringBuilder result = getLine(list.toArray(new String[list.size()]));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0) return new StringBuilder();
        StringBuilder sb = null;
        //внешний цикл последовательно пробует начать собирать цепочку с первого слова
        for (int i = 0; i < words.length; i++) {
            List<String> listik1 = Arrays.asList(words);
            ArrayList<String> listik = new ArrayList<>(listik1);
            sb = new StringBuilder();
            sb.append(listik.get(i));
            listik.remove(i);
            int limit = 0;
            for (int j = 0; j < words.length; j++) {
                limit += words.length - j;
            }
            int counter = 0;
            int k = 0;
            while (listik.size() > 0) {
                StringBuilder current = new StringBuilder(listik.get(k));
                if (Character.toLowerCase(sb.charAt(0)) == Character.toLowerCase(current.charAt(current.length() - 1))) {
                    current.append(" ");
                    current.append(sb);
                    sb = current;
                    listik.remove(k);
                } else if (Character.toLowerCase(sb.charAt(sb.length() - 1)) == Character.toLowerCase(current.charAt(0))) {
                    sb.append(" ");
                    sb.append(current);
                    listik.remove(k);
                } else {
                    listik.add(listik.get(k));
                    listik.remove(k);
                    counter++;
                    if (counter > limit) break;

                }
            }
        }
        return sb;
    }
}