package crypting.strategy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnicodeCipherTest {

    private static UnicodeCipher unicodeCipher;

    @BeforeAll
    static void beforeAll() {
        unicodeCipher = new UnicodeCipher();
    }

    @Test
    void crypt() {
        //given
        String data = "aAzZ!2";
        String expected = "bB{[\"3";
        int key = 1;

        //when
        String result = unicodeCipher.crypt(data, key);

        //then
        assertEquals(expected, result);
    }
}
