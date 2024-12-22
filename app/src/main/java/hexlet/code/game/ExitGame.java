package hexlet.code.game;

public class ExitGame extends AbstractGame {
    public ExitGame() {
        super("Exit");
    }

    @Override
    public void play() {
        System.exit(0);
    }
}
