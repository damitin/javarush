package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        ArrayList<String> fileStrings1 = new ArrayList<>();
        ArrayList<String> fileStrings2 = new ArrayList<>();

        BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader reader2 = new BufferedReader(new FileReader(fileName2));

        while (reader1.ready()) {
            fileStrings1.add(reader1.readLine());
        }
        reader1.close();

        while (reader2.ready()) {
            fileStrings2.add(reader2.readLine());
        }
        reader2.close();

        while (fileStrings1.size() > 0 && fileStrings2.size() > 0) {
            if (fileStrings1.get(0).equals(fileStrings2.get(0))) {
                lines.add(new LineItem(Type.SAME, fileStrings1.get(0)));
                fileStrings1.remove(0);
                fileStrings2.remove(0);
            } else if (fileStrings1.get(1).equals(fileStrings2.get(0))) {
                lines.add(new LineItem(Type.REMOVED, fileStrings1.get(0)));
                fileStrings1.remove(0);
            } else if (fileStrings1.get(0).equals(fileStrings2.get(1))) {
                lines.add(new LineItem(Type.ADDED, fileStrings2.get(0)));
                fileStrings2.remove(0);
            }
        }

        if (fileStrings1.size() > 0) {
            for (String currentString : fileStrings1) {
                lines.add(new LineItem(Type.REMOVED, currentString));
            }
        }
        if (fileStrings2.size() > 0) {
            for (String currentString : fileStrings2) {
                lines.add(new LineItem(Type.ADDED, currentString));
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
