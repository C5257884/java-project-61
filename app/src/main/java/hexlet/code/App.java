package hexlet.code;

import hexlet.code.game.Calculator;
import hexlet.code.game.EvenCheck;
import hexlet.code.game.ExitGame;
import hexlet.code.game.GCD;
import hexlet.code.game.Greet;
import hexlet.code.game.PrimeNumber;
import hexlet.code.game.Progression;

public class App {

    public static void main(String[] args) {

        Menu menu = new Menu(
            new MenuItem[] {
                new MenuItem("1", new Greet()),
                new MenuItem("2", new EvenCheck()),
                new MenuItem("3", new Calculator()),
                new MenuItem("4", new GCD()),
                new MenuItem("5", new Progression()),
                new MenuItem("6", new PrimeNumber()),
                new MenuItem("0", new ExitGame())
            });

        try {
            menu.showItems();
            menu.getUserChoice().action(MenuItem.ACTION_EXEC);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
