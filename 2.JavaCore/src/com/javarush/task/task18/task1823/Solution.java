package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")) {
            ReadThread thread = new ReadThread(fileName);
            thread.start();
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;
        private ArrayList<Integer> list = new ArrayList<>();
        public ReadThread(String fileName) throws IOException {
            //implement constructor body
            this.fileName = fileName;
            FileInputStream fileInputStream = new FileInputStream(fileName);
            while (fileInputStream.available() > 0) {
                list.add(fileInputStream.read());
            }
            fileInputStream.close();
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            int element = list.get(0);
            for (Integer x : list) if (Collections.frequency(list, x) > Collections.frequency(list, element)) element = x;
            synchronized (resultMap) {
                resultMap.put(fileName, element);
            }
        }



    }
}
