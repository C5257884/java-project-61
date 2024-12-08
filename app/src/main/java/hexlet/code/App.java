package hexlet.code;

public class App {
    public static final String GREET_MSG = "Welcome to the Brain Games!";
    public static final String CHOICE_MSG = "Your choice: ";

    public static void main(String[] args) {
        Game[] gamesList = {
            new EvenCheckGame(1),
            new ExitGame(0)
        };

        // Displays a list of games for user selection
        for (Game game : gamesList) {
            game.outDescription();
        }

        var index = Cli.inputGameNumber(CHOICE_MSG);

        gamesList[index].play();

    }
}
