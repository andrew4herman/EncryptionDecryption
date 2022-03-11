package crypting;

import crypting.strategy.ShiftCipher;
import crypting.strategy.UnicodeCipher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CryptorTest {

    private Cryptor cryptor;

    @Test
    void encrypt() {
        //given
        cryptor = new Cryptor(new ShiftCipher());
        String data = "aAzZ!2";
        String expected = "bBaA!2";
        int key = 1;

        //when
        String result = cryptor.encrypt(data, key);

        //then
        assertEquals(expected, result);
    }

    @Test
    void decrypt() {
        //given
        cryptor = new Cryptor(new UnicodeCipher());
        String data = "bB{[\"3";
        String expected = "aAzZ!2";
        int key = 1;

        //when
        String result = cryptor.decrypt(data, key);

        //then
        assertEquals(expected, result);
    }
}
