package hexlet.code;

import hexlet.code.game.PrimeNumber;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class PrimeNumberTest {

    @Test
    void testIsPrime() {

        Path path = Paths.get("src/test/resources/TDC_PrimeNumberGameTest.txt");

        try {
            // Чтение содержимого файла с тестовыми данными
            String content = Files.readString(path);

            // Преобразование строки в массив целых чисел
            int[] primeNumbers = Arrays.stream(content.split(",\\s*|\\s*,\\s*|,\\s*\\R\\s*"))
                .mapToInt(Integer::parseInt)
                .toArray();

            PrimeNumber cutGame = new PrimeNumber();

            Method methIsPrime;

            methIsPrime = PrimeNumber.class.getDeclaredMethod("isPrime", int.class);
            methIsPrime.setAccessible(true);

            for (var prime : primeNumbers) {
                assertTrue((boolean) methIsPrime.invoke(cutGame, prime),
                    "Error in Primerity of " + prime + " determination");
            }

        } catch (IOException e) {
            fail("Ошибка при чтении файла с тестовыми данными: " + e.getMessage());
        } catch (NumberFormatException e) {
            fail("Ошибка в тестовых данных: " + e.getMessage());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail(e.getMessage());
        }
    }
}

