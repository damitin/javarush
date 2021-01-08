package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String input = outputStream.toString().replace("\r\n", "");
        //String input = outputStream.toString().trim();
        String[] inputElements = input.split(" ");
        int a = Integer.parseInt(inputElements[0]);
        int b = Integer.parseInt(inputElements[2]);
        int result = 0;

        switch (inputElements[1]){
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "*": result = a * b; break;
            case "/": result = a / b; break;
        }
        System.setOut(consoleStream);
        System.out.println(input + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

