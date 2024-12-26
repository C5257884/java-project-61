package hexlet.code.game;

//import hexlet.code.Cli;

public class Greet extends AbstractGame {
//    private static final String GREET_MSG = "\nWelcome to the Brain Games!";
//    private static final String INPUT_YOUR_NAME = "May I have your name?";
//    private static final String HELLO_MSG = "Hello, ";


    @Override
    protected void generateGameParams() {
    }

    @Override
    protected String getCorrectAnswer() {
        return "";
    }

    @Override
    protected String inputActalAnswer() {
        return "";
    }


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
        handShake();
    }
}
