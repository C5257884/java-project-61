package hexlet.code;

import hexlet.code.game.Game;
import lombok.Getter;

public final class MenuItem {
    public static final String ACTION_EXEC = "execute";
    @Getter
    private final String key;
    private final Game game;

    public MenuItem(String newKey, Game newGame) {
        key = newKey;
        game = newGame;
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

