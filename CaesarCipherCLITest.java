import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the CLI interface of CaesarCipher (main method).
 */
class CaesarCipherCLITest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testEncodeCli() {
        CaesarCipher.main(new String[]{"encode", "Hello, World!", "3"});
        assertEquals("Khoor, Zruog!", outContent.toString().trim());
    }

    @Test
    void testDecodeCli() {
        CaesarCipher.main(new String[]{"decode", "Khoor, Zruog!", "3"});
        assertEquals("Hello, World!", outContent.toString().trim());
    }

    @Test
    void testInvalidOperation() {
        CaesarCipher.main(new String[]{"compress", "Hello", "1"});
        assertEquals("Operation must be 'encode' or 'decode'.", outContent.toString().trim());
    }

    @Test
    void testMissingArguments() {
        CaesarCipher.main(new String[]{"encode"});
        assertEquals("Usage: java CaesarCipher encode|decode \"text\" <shift>", outContent.toString().trim());
    }

    @Test
    void testInvalidShift() {
        CaesarCipher.main(new String[]{"encode", "Hello", "abc"});
        assertEquals("Shift must be an integer.", outContent.toString().trim());
    }
}