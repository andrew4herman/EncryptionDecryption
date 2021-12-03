package encryptdecrypt.strategy;

/**
 * Abstract strategy in Strategy pattern.
 * Base class for algorithms
 * Contains single method to encrypt and decrypt data.
 */
public interface Algorithm {

    /**
     * <p>
     * Gets a String and returns it's encrypted/decrypted version.
     * </p>
     *
     * @param data is the raw text we need to process;
     * @param key  is the value of shifting each letter up/down.
     *             Must be >0 for encoding and <0 for decoding;
     * @return a new String that represents coded/encoded data;
     */
    String crypt(String data, int key);

}
