package hexlet.code;

public class MenuItem {
    protected Integer screenPosition;
    public final Game game;

    MenuItem(Integer screenPosition, Game game) {
        this.screenPosition = screenPosition;
        this.game = game;
    }
}
