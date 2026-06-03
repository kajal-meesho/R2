/**
 * Caesar cipher utility providing encode, decode, and a CLI main method.
 */
public class CaesarCipher {

    /**
     * Encodes the given text by shifting each letter by the specified shift.
     *
     * @param text  the input string (may contain non‑letter characters, which are unchanged)
     * @param shift the shift amount
     * @return the encoded string
     */
    public static String encode(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char base = 'A';
                result.append((char) ((c - base + shift) % 26 + base));
            } else if (Character.isLowerCase(c)) {
                char base = 'a';
                result.append((char) ((c - base + shift) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     * Decodes the given text by shifting each letter by the negation of the shift.
     *
     * @param text  the encoded string
     * @param shift the shift that was used during encoding
     * @return the decoded (original) string
     */
    public static String decode(String text, int shift) {
        return encode(text, -shift);
    }

    /**
     * CLI entry point.
     * Usage: java CaesarCipher encode|decode "text" &lt;shift&gt;
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java CaesarCipher encode|decode \"text\" <shift>");
            return;
        }
        String operation = args[0].toLowerCase();
        String text = args[1];
        int shift;
        try {
            shift = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Shift must be an integer.");
            return;
        }
        String result;
        switch (operation) {
            case "encode":
                result = encode(text, shift);
                break;
            case "decode":
                result = decode(text, shift);
                break;
            default:
                System.out.println("Operation must be 'encode' or 'decode'.");
                return;
        }
        System.out.println(result);
    }
}