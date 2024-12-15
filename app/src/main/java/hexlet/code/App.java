package hexlet.code;

public class App {
    public static final String GREET_MSG = "Welcome to the Brain Games!";
    public static final String CHOICE_MSG = "Your choice: ";

    public static void main(String[] args) {

//        // Creating massive wih games
//        Game[] gamesList = {
//                {1, new Greet(1)},
//                {2, new EvenCheckGame(2)},
//                {0, new ExitGame(0)}
//        };
//
//        // Display a list of games for user selection
//        for (Game game : gamesList) {
//            game.outDescription();
//        }

        Menu menu = new Menu(
            new MenuItem[] {
                new MenuItem(1, new Greet(1)),
                new MenuItem(2, new EvenCheckGame(2)),
                new MenuItem(3, new ExitGame(0))
            });
        menu.showItems();

        menu.getItem().game.play();

//        var index = Cli.inputGameNumber(CHOICE_MSG);

//        gamesList[index].play();

    }
}
