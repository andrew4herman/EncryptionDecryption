package encryptdecrypt.cryptors;

import encryptdecrypt.strategy.Cipher;

public class Decryptor extends Cryptor{

    public Decryptor(Cipher cipher, int key) {
        super(cipher, -key);
    }

    @Override
    public String crypt(String data) {
        return super.crypt(data);
    }
}
