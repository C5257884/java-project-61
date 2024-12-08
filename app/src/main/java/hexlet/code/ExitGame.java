package hexlet.code;

public class ExitGame extends AbstractGame {
    ExitGame(int index) {
        super(index, "Exit");
    }

    @Override
    public void play() {
//        super.play();
        System.exit(0);
    }
}
