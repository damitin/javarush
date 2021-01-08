package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();
        while (reader.ready()) {
            String[] strings = reader.readLine().split(" ");
            if (map.containsKey(strings[0])) {
                map.put(strings[0], map.get(strings[0]) + Double.parseDouble(strings[1]));
            } else {
                map.put(strings[0], Double.parseDouble(strings[1]));
            }
        }
        reader.close();
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}