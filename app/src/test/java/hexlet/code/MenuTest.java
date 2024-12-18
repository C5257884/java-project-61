package hexlet.code;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class MenuTest {

    @Test
    void testMenu() {
        Menu cutMenu = new Menu(
            new MenuItem[] {
                new MenuItem(0, new Greet(1)),
                new MenuItem(1, new EvenCheckGame(2)),
                new MenuItem(2, new ExitGame(0))
            });


        try {
            Field fldScrPosToHotPointMapping = Menu.class.getDeclaredField("screenPosToHotPointMapping");
            fldScrPosToHotPointMapping.setAccessible(true);

            int[][] expScreenPosToHotPointMapping = new int[][] {{0, 1}, {1, 2}, {2, 0}};

            assertTrue(
                Arrays.deepEquals(expScreenPosToHotPointMapping, (int[][]) fldScrPosToHotPointMapping.get(cutMenu)),
                "Arrays are not equal");

            assert2DArraysEqual(expScreenPosToHotPointMapping,
                (int[][]) fldScrPosToHotPointMapping.get(cutMenu)); //, "Arrays are not equal");
        } catch (NoSuchFieldException e1) {
            assertTrue(e1 == null);     //##Q Если мы тут - тест не удался, как написать ?
        } catch (IllegalAccessException e2) {
            assertTrue(e2 == null);     //##Q Если мы тут - тест не удался, как написать ?
        }
    }

    void assert2DArraysEqual(int[][] expected, int[][] actual) {
        if (expected.length != actual.length) {
            fail("Arrays have different row counts");
        }
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], "Row " + i + " does not match");
        }
    }
}
