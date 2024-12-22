package hexlet.code;

public class Menu {
    public static final String MENU_TITLE = "Please enter the game number and press Enter.";
    public static final String CHOICE_MSG = "Your choice: ";
    private static final int MAX_WRONG_CHOICE_NUM = 3;
    private final MenuItem[] items;

    public Menu(MenuItem[] items) {
        this.items = items;
    }

    public void showItems() {

        System.out.println(MENU_TITLE);
        for (var item : items) {
            System.out.println(item.key + " - " + item.getDescription());
        }
    }

    public MenuItem getUserChoice() throws Exception {

        var countTry = 0;
        do {
            var itemKey = Cli.inputString(CHOICE_MSG);

            for (var item : items) {
                if (item.key.equals(itemKey)) {
                    return item;
                }
            }
            System.out.println("Wrong choice, please try again");
            countTry++;
        } while (countTry < MAX_WRONG_CHOICE_NUM);
        throw new Exception("And again - wrong! Try again later!");
    }
}
