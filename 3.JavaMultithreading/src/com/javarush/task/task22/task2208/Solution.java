package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        /*Map<String, String> maps = new HashMap<>();
        maps.put("name", "Ivanov");
        maps.put("country", "Ukraine");
        maps.put("city", "Kiev");
        maps.put("age", null);

        System.out.println(getQuery(maps));*/
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue() != null) {
                sb.append(" and ");
                sb.append(entry.getKey() + " = '" + entry.getValue() + "'");
            }
        }
        sb.delete(0, 5);
        return sb.toString();
    }
}
