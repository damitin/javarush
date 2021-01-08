package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxOccur = 0;
        int valueOfMinByteFreq = 0;
        int valueOfMaxByteFreq = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        while (fileInputStream.available() > 0) {
            int currentByte = fileInputStream.read();
            if (!map.containsKey(currentByte)) {
                map.put(currentByte, 1);
            } else {
                map.put(currentByte, map.get(currentByte) + 1);
            }
        }
        fileInputStream.close();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int currentValue = entry.getValue();
            maxOccur = maxOccur > currentValue ? maxOccur : currentValue;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxOccur) System.out.print(entry.getKey() + " ");
        }
    }
}
