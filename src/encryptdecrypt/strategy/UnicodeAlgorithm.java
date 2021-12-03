package encryptdecrypt.strategy;

/**
 * <p>
 * Concrete strategy in Strategy pattern. <br/>
 * Implementation of Algorithm interface, that change data by <br/>
 * shifting each letter up/down of the Unicode table.
 * </p>
 */
public class UnicodeAlgorithm implements Algorithm {

    /**
     * <p>
     * Gets a String and returns it's encrypted/decrypted version.
     * </p>
     *
     * @param data is the raw text we need to process;
     * @param key  is the number of times moving each letter up/down.
     *             Must be >0 for encoding and <0 for decoding;
     * @return the string with encrypted/decrypted text;
     */
    @Override
    public String crypt(String data, int key) {
        StringBuilder result = new StringBuilder();

        for (char c : data.toCharArray()) {
            c = (char) (c + key);
            result.append(c);
        }

        return result.toString();
    }
}
