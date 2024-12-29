package hexlet.code.game;

public final class ExitGame extends AbstractGame {
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
    public void play() {
//        System.exit(0);
    }
}
