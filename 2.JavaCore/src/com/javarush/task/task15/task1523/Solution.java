package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {

    public Solution (){}

    protected Solution (String name) {}

    Solution (String name, int age) {}

    private Solution (String name, int age, boolean sex) {}

    public static void main(String[] args) {

    }
}

