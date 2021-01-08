package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        try {
            reset();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static CanFly result;

    public static void reset() throws IOException {
        //add your code here - добавьте код тут
        String type = "";
        int passNum = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            type = reader.readLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        if (type.equals("helicopter")) {
            result = new Helicopter();
        } else if (type.equals("plane")) {
            try {
                passNum = Integer.parseInt(reader.readLine());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            result = new Plane(passNum);
        }
        reader.close();
    }
}
