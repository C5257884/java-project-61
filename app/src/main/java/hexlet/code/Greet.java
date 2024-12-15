package hexlet.code;

public class Greet extends AbstractGame {
    Greet(int index) {
        super(index, "Greet");
    }
    @Override
    public void play() {
        System.out.println("My index: " + index + " my title: " + title);
    }
}
