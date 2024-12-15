package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private MenuItem[] items;   // testOnly #TODO delete before PR
    private Map<Integer, MenuItem> menuItems;


    public Menu(MenuItem[] items) {
        this.items = items;
        menuItems = new HashMap<Integer, MenuItem>();
        for (var item : items) {
            menuItems.put(item.key, item);
        }
    }

    public void showItems() {

        menuItems.forEach((key, game) -> game.game.outDescription());
//        for (var menuItem : menuItems.get(1)) {
//            System.out.println("" + key + " - " + menuItems.get(key).game.);
//        }
    }

    public MenuItem getItem() {

        var index = Cli.inputGameNumber(App.CHOICE_MSG);

        var menuItem =  menuItems.get(index);

        return menuItem;
    }
}
