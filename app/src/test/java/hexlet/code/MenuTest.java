package hexlet.code;

import hexlet.code.game.EvenCheck;
import hexlet.code.game.Exit;
import hexlet.code.game.Greet;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;

class MenuTest {

    @Test
    void testMenu() {

        var input = new Scanner(System.in);

        var expMenuItems =
            new MenuItem[] {
                new MenuItem("1", new Greet(input)),
                new MenuItem("2", new EvenCheck(input)),
                new MenuItem("0", new Exit())
            };

        Menu cutMenu = new Menu(expMenuItems, input);

        try {
            Field fldItems = Menu.class.getDeclaredField("items");
            fldItems.setAccessible(true);

            assertArrayEquals(expMenuItems, (MenuItem[]) fldItems.get(cutMenu), "Menu items does not match");

        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail(e.getMessage());
        }
    }
}
