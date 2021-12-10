package crypting;

import crypting.strategy.Cipher;

public class Cryptor {

    private Cipher cipher;

    public Cryptor(Cipher cipher) {
        this.cipher = cipher;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public String encrypt(String data, int key) {
        return cipher.crypt(data, key);
    }

    public String decrypt(String data, int key) {
        return cipher.crypt(data, -key);
    }
}
