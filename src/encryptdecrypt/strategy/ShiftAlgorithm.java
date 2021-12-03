package encryptdecrypt.strategy;

/**
 * <p>
 * Concrete strategy in Strategy pattern. <br/>
 * Implementation of Algorithm interface, that change data by <br/>
 * shifting each letter up/down of the alphabet (a-z & A-Z).
 * </p>
 */
public class ShiftAlgorithm implements Algorithm {

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
        char upper = 'z', lower = 'a';

        for (char c : data.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (Character.isUpperCase(c)) {
                    upper = 'Z';
                    lower = 'A';
                } else {
                    upper = 'z';
                    lower = 'a';
                }

                c = (char) (c + (key % 26));
                c = (char) ((c > upper) ? (c - 26) : (c < lower ? c + 26 : c));
            }

            result.append(c);
        }

        return result.toString();
    }

}
