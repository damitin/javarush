package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter (Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String nextString = fileScanner.nextLine();
            String[] personDetails = nextString.split(" ", 4);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d M y", Locale.ENGLISH);
            Date date = simpleDateFormat.parse(personDetails[3]);

            return new Person(personDetails[1], personDetails[2], personDetails[0], date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
