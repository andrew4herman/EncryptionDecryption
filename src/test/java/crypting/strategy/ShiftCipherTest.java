package crypting.strategy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShiftCipherTest {

    private static ShiftCipher shiftCipher;

    @BeforeAll
    static void beforeAll() {
        shiftCipher = new ShiftCipher();
    }

    @Test
    void crypt() {
        //given
        String data = "aAzZ!2";
        String expected = "bBaA!2";
        int key = 1;

        //when
        String result = shiftCipher.crypt(data, key);

        //then
        assertEquals(expected, result);
    }
}
