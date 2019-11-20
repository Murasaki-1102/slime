package app;

import java.util.Scanner;

import actor.Actor;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello Slime!");
        System.out.println("please tell your name!");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        Actor slime = new Actor(name, 100, 30);
        System.out.println("Your name!! " + slime.name);

    }
}