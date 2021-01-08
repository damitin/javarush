package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = "";
        String secondFileName = "";
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        readDataFromFileByStringToArrayList(firstFileName, allLines);
        readDataFromFileByStringToArrayList(secondFileName, forRemoveLines);

        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public synchronized void joinData() throws CorruptedDataException {
        if (doesFirstContainAllStringsFromSecond(allLines, forRemoveLines)) {
            deleteSecondListStringsFromFirstList(allLines, forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

    public static void readDataFromFileByStringToArrayList (String fileName, List<String> list) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        try {
            while (reader.ready()) {
                list.add(reader.readLine());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static boolean doesFirstContainAllStringsFromSecond (List<String> first, List<String> second) {
        for (String temp: second) {
            if (!first.contains(temp)) return false;
        }
        return true;
    }

    public static void deleteSecondListStringsFromFirstList (List<String> first, List<String> second) {
        for (String temp : second) {
            first.remove(temp);
        }
    }
}
