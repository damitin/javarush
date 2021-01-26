package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    void move(){
        for (Horse horse : horses) {
            horse.move();
        }
    }

    void print(){
        for(Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = horses.get(0);
        for (Horse horse : horses) {
            if (horse.getDistance() > winner.getDistance()) winner = horse;
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + this.getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("first", 3, 0));
        horses.add(new Horse("second", 3, 0));
        horses.add(new Horse("third", 3, 0));

        game = new Hippodrome(horses);
        game.run();
        game.printWinner();

    }
}
