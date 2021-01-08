package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.ParseException;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    if ((args.length - 1) % 3 != 0)
                        throw new IllegalArgumentException("Неверное количество аргументов");

                    String name;
                    Date bd;
                    for (int i = 1; i < args.length; i = i + 3) {
                        name = args[i];
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        bd = dateFormat.parse(args[i + 2]);
                        if (args[i + 1].equals("м")) {
                            Person cur = Person.createMale(name, bd);
                            allPeople.add(cur);
                            System.out.println(allPeople.size() - 1);
                        } else if (args[i + 1].equals("ж")) {
                            Person cur = Person.createFemale(name, bd);
                            allPeople.add(cur);
                            System.out.println(allPeople.size() - 1);
                        }
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    if ((args.length - 1) % 4 != 0)
                        throw new IllegalArgumentException("Неверное количество аргументов");
                    for (int i = 1; i < args.length; i = i + 4) {
                        String id = args[i];
                        int idie = Integer.parseInt(id);
                        Person cur = allPeople.get(idie);
                        String name = args[i + 1];
                        cur.setName(name);
                        Sex sex = null;
                        if (args[i + 2] == "м") {
                            sex = Sex.MALE;
                        } else if (args[i + 2] == "ж") {
                            sex = Sex.FEMALE;
                        }
                        cur.setSex(sex);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        Date bd = dateFormat.parse(args[i + 3]);
                        cur.setBirthDate(bd);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        Person cur = allPeople.get(id);
                        cur.setBirthDate(null);
                        cur.setSex(null);
                        cur.setName(null);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        Person cur = allPeople.get(id);

                        Date parsedDate = cur.getBirthDate();
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        String destDate = sdfDestination.format(parsedDate);
                        Sex sex = cur.getSex();
                        String s = null;
                        if (sex.equals(Sex.MALE)) {
                            s = "м";
                        } else if (sex.equals(Sex.FEMALE)) {
                            s = "ж";
                        }
                        System.out.println(cur.getName() + " " + s + " " + destDate);
                    }
                    break;
                }
        }

    }
}
