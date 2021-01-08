package com.javarush.task.task31.task3101;

import java.util.Comparator;

public class MyStringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] string1 = o1.split("/");
        String[] string2 = o2.split("/");
        return string1[string1.length - 1].compareTo(string2[string2.length - 1]);
    }
}
