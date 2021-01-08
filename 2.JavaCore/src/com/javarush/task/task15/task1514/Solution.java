package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(2.0, "qwe");
        labels.put(3.0, "qwe3");
        labels.put(4.0, "qwe4");
        labels.put(5.0, "qwe5");
        labels.put(6.0, "qwe6");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
