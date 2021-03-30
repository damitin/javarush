package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
//        Integer[] arr = new Integer[]{3, 2, 5, 2, 7, 10};
//        sort(arr);

    }

    public static Integer[] sort(Integer[] array) {
        Double mediana = calculateMediana(array);
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double distance1 = Math.abs(mediana - o1.intValue());
                double distance2 = Math.abs(mediana - o2.intValue());
                return (int) (distance1 - distance2) * 10;
            }
        });

        return array;
    }

    public static Double calculateMediana(Integer[] array) {
        //отсортировать по возрастанию
        Arrays.sort(array);

        //вычислить медиану
        double mediana;
        if (array.length % 2 == 1)
        {
            mediana = array[(array.length - 1) / 2];
        } else {
            mediana = 0.5 * (array[array.length / 2] + array[array.length / 2 - 1]);
        }
        return mediana;
    }
}