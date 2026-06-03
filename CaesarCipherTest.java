import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Round-trip tests for CaesarCipher.encode and decode.
 *
 * The test verifies that decoding an encoded string recovers the original text.
 * This demonstrates that decode is the correct inverse of encode.
 */
class CaesarCipherTest {

    @Test
    void roundTripHelloWorld() {
        String original = "Hello, World!";
        int shift = 3;
        assertEquals(original, CaesarCipher.decode(CaesarCipher.encode(original, shift), shift));
    }

    @Test
    void roundTripWithWrapAround() {
        String original = "Zebra XYZ";
        int shift = 5;
        assertEquals(original, CaesarCipher.decode(CaesarCipher.encode(original, shift), shift));
    }

    @Test
    void roundTripEmptyString() {
        String original = "";
        int shift = 10;
        assertEquals(original, CaesarCipher.decode(CaesarCipher.encode(original, shift), shift));
    }

    @Test
    void roundTripNullInput() {
        assertNull(CaesarCipher.decode(CaesarCipher.encode(null, 1), 1));
    }

    @Test
    void roundTripNonAlphabetic() {
        String original = "123 !@#";
        int shift = 7;
        assertEquals(original, CaesarCipher.decode(CaesarCipher.encode(original, shift), shift));
    }
}