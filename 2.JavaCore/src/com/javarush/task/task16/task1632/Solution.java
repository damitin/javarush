package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new First());
        threads.add(new Second());
        threads.add(new Third());
        threads.add(new Fourth());
        threads.add(new Fifth());
    }

    public static void main(String[] args) {
    }

    public static class First extends Thread {
        @Override
        public void run() {
            while (true) {}
        }
    }

    public static class Second extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException interruptedException) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    public static class Third extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
    }

    public static class Fourth extends Thread implements Message {
        @Override
        public void run() {
            while (!this.isInterrupted()) {}
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    public static class Fifth extends Thread {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;

        @Override
        public void run() {
            while (true) {
                try {
                    String s = reader.readLine();
                    if (s.equals("N")) break;
                    n = n + Integer.parseInt(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(n);
        }
    }
}