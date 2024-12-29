package hexlet.code.game;

import java.util.Scanner;

public final class Greet implements Game {
    private final Scanner input;

    /**
     * CONSTRUCTOR.
     * @param inputScaner - object Scaner for user input
     */
    public Greet(Scanner inputScaner) {
        this.input = inputScaner;
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

    /**
     * Method return Game description.
     * @return game description
     */
    @Override
    public String getDescription() {
        return "Greet";
    }

}
