package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader fReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fWriter = new BufferedWriter(new FileWriter(fileName2));

        while (fReader.ready()) {
            String currentString = fReader.readLine().replaceAll("\\.", "!");
            fWriter.write(currentString);
        }
        fReader.close();
        fWriter.close();
    }
}
