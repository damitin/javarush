package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/

public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread currentThread : threads) {
            switch (currentThread.getState()) {
                case NEW:
                    currentThread.start();
                    break;
                case WAITING:
                case TIMED_WAITING:
                case BLOCKED:
                    currentThread.interrupt();
                    break;
                case RUNNABLE:
                    currentThread.isInterrupted();
                    break;
                case TERMINATED:
                    System.out.println(currentThread.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
