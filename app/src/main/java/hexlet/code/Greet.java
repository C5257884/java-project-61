package hexlet.code;

public class Greet extends AbstractGame {
    public static final String GREET_MSG = "Welcome to the Brain Games!";
    public static final String INPUT_YOUR_NAME = "May I have your name?";
    public static final String HELLO_MSG = "Hello, ";

    Greet(int gameHotPoint) {
        super(gameHotPoint, "Greet");
    }
    Greet(int gameHotPoint, String title) {
        super(gameHotPoint, title);
    }

    @Override
    public void play() {
        System.out.println(GREET_MSG);
        userName = Cli.getUserName(INPUT_YOUR_NAME);
        System.out.println(HELLO_MSG + userName);
    }
}
