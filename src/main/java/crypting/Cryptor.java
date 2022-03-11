package crypting;

import crypting.strategy.Cipher;

/**
 * Encrypts and decrypts data using the given cipher
 */
public record Cryptor(Cipher cipher) {

    public String encrypt(String data, int key) {
        return cipher.crypt(data, key);
    }

    public String decrypt(String data, int key) {
        return cipher.crypt(data, -key);
    }
}
