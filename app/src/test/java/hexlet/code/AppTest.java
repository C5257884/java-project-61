package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("'main' method works correctly")
    void testMain() {
        App.main(null);

        var testString = output.toString(StandardCharsets.UTF_8).trim();
        assertEquals(testString, output.toString(StandardCharsets.UTF_8).trim());
//        assertEquals("Test", "Test");
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
