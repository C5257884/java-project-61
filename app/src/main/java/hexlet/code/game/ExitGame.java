package hexlet.code.game;

public class ExitGame extends AbstractGame {
    public ExitGame(int gameHotPoint) {
        super(gameHotPoint, "Exit");
    }

    @Override
    public void play() {
//        super.play();
        System.out.println("My index: " + gameHotPoint + " my title: " + title);

        System.exit(0);
    }
}
