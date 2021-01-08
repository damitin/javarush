package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int count = 0;
        while (fileInputStream.available() > 0) {
            int currentChar = fileInputStream.read();
            if ((currentChar >= 97 && currentChar <= 122)||(currentChar >= 65 && currentChar <= 90)){
                count++;
            }
        }
        fileInputStream.close();
        System.out.println(count);
    }
}
