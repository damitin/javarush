package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
*/

public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return c;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 0b1111; i++) {
            boolean a = (i & 0b1) != 0;
            boolean b = (i & 0b10) != 0;
            boolean c = (i & 0b100) != 0;
            boolean d = (i & 0b1000) != 0;
            System.out.printf("%-10b %-10b %-10b %-10b = %10b\n", d, c, b, a, calculate(a, b, c, d));
        }

    }
}
