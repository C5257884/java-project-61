package hexlet.code;

import hexlet.code.game.CalculatorGame;
import hexlet.code.game.EvenCheckGame;
import hexlet.code.game.ExitGame;
import hexlet.code.game.GCDGame;
import hexlet.code.game.Greet;
import hexlet.code.game.PrimeNumberGame;
import hexlet.code.game.ProgressionGame;

public class App {

    public static void main(String[] args) {

        Menu menu = new Menu(
            new MenuItem[] {
                new MenuItem(0, new Greet(1)),
                new MenuItem(1, new EvenCheckGame(2)),
                new MenuItem(2, new CalculatorGame(3)),
                new MenuItem(3, new GCDGame(4)),
                new MenuItem(4, new ProgressionGame(5)),
                new MenuItem(5, new PrimeNumberGame(6)),
                new MenuItem(6, new ExitGame(0))
            });

        var nextStepLoop = true;

        do {
            try {
                menu.showItems();
                menu.getItem().game.play();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                nextStepLoop = false;
            }
        } while (nextStepLoop);
    }
}
