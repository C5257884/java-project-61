package hexlet.code;

import hexlet.code.game.Calculator;
import hexlet.code.game.EvenCheck;
import hexlet.code.game.Exit;
import hexlet.code.game.GCD;
import hexlet.code.game.Greet;
import hexlet.code.game.PrimeNumber;
import hexlet.code.game.Progression;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        var input = new Scanner(System.in);

        Menu menu = new Menu(
            new MenuItem[] {
                new MenuItem("1", new Greet(input)),
                new MenuItem("2", new EvenCheck(input)),
                new MenuItem("3", new Calculator(input)),
                new MenuItem("4", new GCD(input)),
                new MenuItem("5", new Progression(input)),
                new MenuItem("6", new PrimeNumber(input)),
                new MenuItem("0", new Exit())
            },
            input
        );

        try {
            menu.showItems();
            menu.getUserChoice().action(MenuItem.ACTION_EXEC);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
