package hexlet.code;

public class ExitGame extends AbstractGame {
    ExitGame(int index) {
        super(index, "Exit");
    }

    @Override
    public void play() {
//        super.play();
        System.out.println("My index: " + index + " my title: " + title);

        System.exit(0);
    }
}
