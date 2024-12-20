package hexlet.code.game;

import hexlet.code.Cli;

public class Greet extends AbstractGame {
    public static final String GREET_MSG = "Welcome to the Brain Games!";
    public static final String INPUT_YOUR_NAME = "May I have your name?";
    public static final String HELLO_MSG = "Hello, ";

    public Greet(int gameHotPoint) {
        super(gameHotPoint, "Greet");
    }

    public Greet(int gameHotPoint, String title) {
        super(gameHotPoint, title);
    }

    @Override
    public void play() {
        System.out.println(GREET_MSG);
        userName = Cli.inputString(INPUT_YOUR_NAME);
        System.out.println(HELLO_MSG + userName);
    }
}
