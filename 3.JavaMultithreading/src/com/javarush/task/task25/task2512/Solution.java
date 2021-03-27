package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<String> exceptions = new ArrayList<>();
        while (e != null) {
            exceptions.add(0, e.toString());
            e = e.getCause();
        }

        for (String current : exceptions) {
            System.out.println(current);
        }
    }

    public static void main(String[] args) throws Exception {

    }
}
