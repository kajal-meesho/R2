/**
 * A utility class that provides Caesar cipher encoding and decoding.
 *
 * <p>The {@code encode} method shifts each letter in the input string by a given
 * number of positions in the alphabet, wrapping around. The {@code decode} method
 * is the inverse operation, implemented by delegating to {@code encode} with
 * a negated shift value, because a Caesar cipher is symmetric.
 */
public class CaesarCipher {

    /**
     * Encodes the given text using a Caesar cipher with the specified shift.
     *
     * @param text  the plaintext to encode (may be {@code null})
     * @param shift the number of positions to shift each letter (positive for forward)
     * @return the encoded string, or {@code null} if input was {@code null}
     */
    public static String encode(String text, int shift) {
        if (text == null) return null;
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + shift) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     * Decodes a Caesar cipher encoded string by applying a negative shift.
     *
     * <p>This method simply delegates to {@link #encode(String, int)} with the
     * shift negated, because the Caesar cipher is symmetric: applying a shift
     * of {@code -k} reverses the effect of a shift of {@code k}.
     *
     * @param text  the encoded text to decode (may be {@code null})
     * @param shift the shift that was originally used for encoding
     * @return the decoded plaintext, or {@code null} if input was {@code null}
     */
    public static String decode(String text, int shift) {
        // Delegating to encode with negated shift reverses the transformation.
        return encode(text, -shift);
    }
}