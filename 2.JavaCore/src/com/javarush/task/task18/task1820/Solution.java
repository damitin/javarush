package com.javarush.task.task18.task1820;

import java.io.*;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        reader = new BufferedReader(new FileReader(fileName1));
        String fileContent = reader.readLine();
        reader.close();

        String[] values = fileContent.split("\\s+");

        String result = "";
        for (String currentValue : values) {
            result += Math.round(Double.parseDouble(currentValue)) + " ";
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        writer.write(result);
        writer.close();
    }
}
