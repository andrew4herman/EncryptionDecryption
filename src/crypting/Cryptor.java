package crypting;

import crypting.strategy.Cipher;

public record Cryptor(Cipher cipher) {

    public String encrypt(String data, int key) {
        return cipher.crypt(data, key);
    }

    public String decrypt(String data, int key) {
        return cipher.crypt(data, -key);
    }
}
