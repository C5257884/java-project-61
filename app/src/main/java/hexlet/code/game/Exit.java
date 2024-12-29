package hexlet.code.game;

public final class Exit implements Game {

    @Override
    public void play() {
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "Exit";
    }
}
