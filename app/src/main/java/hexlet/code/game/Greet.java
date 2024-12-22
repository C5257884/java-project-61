package hexlet.code.game;

import hexlet.code.Cli;

public class Greet extends AbstractGame {
    public static final String GREET_MSG = "\nWelcome to the Brain Games!";
    public static final String INPUT_YOUR_NAME = "May I have your name?";
    public static final String HELLO_MSG = "Hello, ";

    public Greet() {
        super("Greet");
    }

    public Greet(String title) {
        super(title);
    }

    /**
     * A simple implementation of a greeting game.
     * This method can be overridden to provide custom behavior for the game.
     * When overriding, ensure that user interaction flow is preserved.
     */
    @Override
    public void play() {
        System.out.println(GREET_MSG);
        setUserName(Cli.inputString(INPUT_YOUR_NAME));
        System.out.println(HELLO_MSG + getUserName() + "!");
    }
}
