package encryptdecrypt.cryptors;

import encryptdecrypt.strategy.Cipher;

public abstract class Cryptor {

    private Cipher cipher;
    private int key;

    public Cryptor(Cipher cipher, int key) {
        this.cipher = cipher;
        this.key = key;
    }

    public String crypt(String data) {
        return cipher.crypt(data, key);
    }
}
