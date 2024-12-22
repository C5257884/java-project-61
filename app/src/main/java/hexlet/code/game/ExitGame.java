package hexlet.code.game;

public class ExitGame extends AbstractGame {
    public ExitGame() {
        super("Exit");
    }

    @Override
    public final void play() {
        System.exit(0);
    }
}
