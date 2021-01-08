package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()) {
            String currentLine = reader.readLine();
            String name = currentLine.replaceAll("\\d", "").trim();
            String date = currentLine.replaceAll(name, "").trim();
            Date date1 = new SimpleDateFormat("d M y").parse(date);
            PEOPLE.add(new Person(name, date1));
        }
        reader.close();

    }
}
