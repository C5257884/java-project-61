package hexlet.code;


/**
 * Класс предназначен для хранения пунктов меню.
 * Выводи пункты меню на экран, запрашивает у пользователя выбор пункта меню.
 */
public final class Menu {
    public static final String MENU_TITLE = "Please enter the game number and press Enter.";
    public static final String CHOICE_MSG = "Your choice: ";
    private static final int MAX_WRONG_CHOICE_NUM = 3;
    private final MenuItem[] items;

    public Menu(MenuItem[] menuItems) {
        items = menuItems;
    }

    public void showItems() {

        System.out.println(MENU_TITLE);
        for (var item : items) {
            System.out.println(item.getKey() + " - " + item.getDescription());
        }
    }

    public MenuItem getUserChoice() throws Exception {

        var countTry = 0;
        do {
            var itemKey = Cli.inputString(CHOICE_MSG);

            for (var item : items) {
                if (item.getKey().equals(itemKey)) {
                    return item;
                }
            }
            System.out.println("Wrong choice, please try again");
            countTry++;
        } while (countTry < MAX_WRONG_CHOICE_NUM);
        throw new Exception("And again - wrong! Try again later!");
    }
}
