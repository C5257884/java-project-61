package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    public static final String MENU_TITLE = "Please enter the game number and press Enter.";
    public static final String CHOICE_MSG = "Your choice: ";
    // Сопоставление номера игры (пользовательский ввод) - объекту "Игра"
    private final Map<Integer, MenuItem> menuItems;
    // Сопоставление порядкового номера строки меню на экране - номеру игры (пользовательский ввод)
    private final int[][] screenPosToHotPointMapping;

    public Menu(MenuItem[] items) {

        menuItems = new HashMap<Integer, MenuItem>();
        screenPosToHotPointMapping = new int[items.length][2];

        for (var item : items) {
            menuItems.put(item.game.getHotPoint(), item);
            screenPosToHotPointMapping[item.screenPosition][0] = item.screenPosition;
            screenPosToHotPointMapping[item.screenPosition][1] = item.game.getHotPoint();
        }
    }

    public void showItems() {

        System.out.println(MENU_TITLE);

        for (var row : screenPosToHotPointMapping) {
            menuItems.get(row[1]).game.outDescription();
        }
    }

    public MenuItem getItem() throws Exception {

        var countTry = 0;
        do {
            var gameHotPoint = Cli.inputIntNumber(CHOICE_MSG);
            var menuItem = menuItems.get(gameHotPoint);
            if (menuItem != null) {
                return menuItem;
            } else {
                System.out.println("Wrong choice, please try again");
            }
            countTry++;
        } while (countTry < 3);
        throw new Exception("And again - wrong! Try again later!");
    }
}
