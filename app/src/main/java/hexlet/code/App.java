package hexlet.code;

public class App {

    public static void main(String[] args) {

        Menu menu = new Menu(
            new MenuItem[] {
                new MenuItem(0, new Greet(1)),
                new MenuItem(1, new EvenCheckGame(2)),
                new MenuItem(2, new ExitGame(0))
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
