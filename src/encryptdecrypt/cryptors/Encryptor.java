package encryptdecrypt.cryptors;

import encryptdecrypt.strategy.Cipher;

public class Encryptor extends Cryptor{

    public Encryptor(Cipher cipher, int key) {
        super(cipher, key);
    }

    @Override
    public String crypt(String data) {
        return super.crypt(data);
    }
}
