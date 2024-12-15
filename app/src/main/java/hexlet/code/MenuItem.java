package hexlet.code;

public class MenuItem {
    protected Integer key;
    public final Game game;

    MenuItem(Integer key, Game game) {
        this.key = key;
        this.game = game;
    }
}
