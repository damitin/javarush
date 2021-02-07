package com.javarush.task.task23.task2305;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution one = new Solution();
        one.innerClasses[0] = one.new InnerClass();
        one.innerClasses[1] = one.new InnerClass();

        Solution two = new Solution();
        two.innerClasses[0] = two.new InnerClass();
        two.innerClasses[1] = two.new InnerClass();

        Solution[] result = new Solution[] {one, two};

        return result;
    }

    public static void main(String[] args) {

    }
}
