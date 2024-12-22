package hexlet.code;

import hexlet.code.game.Game;

public class MenuItem {
    public static final String ACTION_EXEC = "execute";
    public final String key;
    private final Game game;

    public MenuItem(String key, Game game) {
        this.key = key;
        this.game = game;
    }

    public void action(String actionName) {
        if (actionName.equals(MenuItem.ACTION_EXEC)) {
            game.play();
        } else {
            throw new RuntimeException("Invalid action name: " + actionName);
        }
    }

    public String getDescription() {
        return game.getDescription();
    }
}

