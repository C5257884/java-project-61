package hexlet.code.game;

import java.util.Scanner;

public class Greet implements Game {
    private final Scanner input;

    public Greet(Scanner input) {
        this.input = input;
    }

    /**
     * A simple implementation of a greeting game.
     */
    @Override
    public void play() {

        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name?");

        var userName = input.nextLine();
        System.out.println("Hello, " + userName + "!");
    }

    @Override
    public String getDescription() {
        return "Greet";
    }

}
