package hexlet.code;

import hexlet.code.game.EvenCheck;
import hexlet.code.game.ExitGame;
import hexlet.code.game.Greet;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;

class MenuTest {

    @Test
    void testMenu() {

        var expMenuItems =
            new MenuItem[] {
                new MenuItem("1", new Greet()),
                new MenuItem("2", new EvenCheck()),
                new MenuItem("0", new ExitGame())
            };

        Menu cutMenu = new Menu(expMenuItems);

        try {
            Field fldItems = Menu.class.getDeclaredField("items");
            fldItems.setAccessible(true);

//            assertTrue(
//                Arrays.deepEquals(expMenuItems, (MenuItem[]) fldItems.get(cutMenu)),
//                "Arrays are not equal");
            assertArrayEquals(expMenuItems, (MenuItem[]) fldItems.get(cutMenu), "Menu items does not match");

        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail(e.getMessage());
        }
    }

//    void assert2DArraysEqual(int[][] expected, int[][] actual) {
//        if (expected.length != actual.length) {
//            fail("Arrays have different row counts");
//        }
//        for (int i = 0; i < expected.length; i++) {
//            assertArrayEquals(expected[i], actual[i], "Row " + i + " does not match");
//        }
//    }
}
