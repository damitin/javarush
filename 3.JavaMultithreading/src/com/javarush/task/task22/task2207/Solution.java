package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        ArrayList<String> words = new ArrayList<>();
        while (fileReader.ready()) {
            String[] currentLine = fileReader.readLine().split(" ");
            words.addAll(Arrays.asList(currentLine));
        }

        fileReader.close();

        for (int i = 0; i < words.size(); i++) {
            for (int j = 1; j < words.size(); ) {
                StringBuilder stringBuilder = new StringBuilder(words.get(j));
                if (words.get(i).equals(stringBuilder.reverse().toString()) && i != j) {
                    Pair pair = new Pair();
                    pair.first = words.get(i);
                    pair.second = words.get(j);
                    result.add(pair);
                    words.remove(j);
                    words.remove(i);
                    if (words.size() <= 1) break;
                } else {
                    j++;
                }
            }
        }


    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
