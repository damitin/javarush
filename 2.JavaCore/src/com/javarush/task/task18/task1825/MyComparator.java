package com.javarush.task.task18.task1825;

import java.util.Comparator;

public class MyComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String [] arr1 = o1.split("\\.");
        String [] arr2 = o2.split("\\.");
        int a = Integer.parseInt(arr1[arr1.length-1].substring(4));
        int b = Integer.parseInt(arr2[arr1.length-1].substring(4));
        return Integer.compare(a,b);
    }
}
