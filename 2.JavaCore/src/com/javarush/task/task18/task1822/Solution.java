package com.javarush.task.task18.task1822;

import java.io.*;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader = new BufferedReader(new FileReader(fileName));
        String currentLine;
        while (reader.ready()) {
            currentLine = reader.readLine();
            if (currentLine.startsWith(args[0] + " ")) {
                reader.close();
                System.out.println(currentLine);
                break;
            }
        }
    }
}
