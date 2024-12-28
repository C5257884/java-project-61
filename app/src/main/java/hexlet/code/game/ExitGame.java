package hexlet.code.game;

public class ExitGame extends AbstractGame {
    public ExitGame() {
        super("Exit");
    }

    @Override
    protected String getCorrectAnswer() {
        return "";
    }

    @Override
    protected String inputActualAnswer() {
        return "";
    }

    @Override
    protected void generateGameParams() {

    }

    @Override
    public final void play() {
//        System.exit(0);
    }
}
