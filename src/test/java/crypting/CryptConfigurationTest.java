package crypting;

import crypting.strategy.Cipher;
import crypting.strategy.UnicodeCipher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CryptConfigurationTest {

    private CliParser cliParser;
    private CryptConfiguration cryptConfiguration;

    @BeforeEach
    void setUp() {
        cliParser = new CliParser(
                "-in abc.txt -out protected.txt -key 5 -alg unicode".split(" "));
        cryptConfiguration = new CryptConfiguration(cliParser);
    }

    @Test
    void getOutFile() {
        //given
        String expected = "protected.txt";

        //when
        String result = cryptConfiguration.getOutFile();

        //then
        assertEquals(expected, result);
    }

    @Test
    void getInFile() {
        //given
        String expected = "abc.txt";

        //when
        String result = cryptConfiguration.getInFile();

        //then
        assertEquals(expected, result);
    }

    @Test
    void getMode() {
        //given
        String expected = "enc";

        //when
        String result = cryptConfiguration.getMode();

        //then
        assertEquals(expected, result);
    }

    @Test
    void testGetInvalidMode() {
        //given
        cliParser = new CliParser(
                "-mode superMode".split(" "));

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new CryptConfiguration(cliParser));

        //then
        assertEquals("Error. There is no superMode mode.", exception.getMessage());
    }

    @Test
    void getData() {
        //given

        //when
        String result = cryptConfiguration.getData();

        //then
        assertNull(result);
    }

    @Test
    void testGetNotEnteredData() {
        //given
        cliParser = new CliParser(
                "-mode enc -out protected.txt -key 5 -alg unicode".split(" "));
        cryptConfiguration = new CryptConfiguration(cliParser);
        String expected = "";

        //when
        String result = cryptConfiguration.getData();

        //then
        assertEquals("", result);
    }

    @Test
    void getCipher() {
        //given
        Cipher expected = new UnicodeCipher();

        //when
        Cipher result = cryptConfiguration.getCipher();

        //then
        assertEquals(expected.getClass(), result.getClass());
    }

    @Test
    void testGetInvalidCipher() {
        //given
        cliParser = new CliParser(
                "-alg superAlg".split(" "));

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new CryptConfiguration(cliParser));

        //then
        assertEquals("Error. There is no algorithm type for superAlg.", exception.getMessage());
    }

    @Test
    void getKey() {
        //given
        int expected = 5;

        //when
        int result = cryptConfiguration.getKey();

        //then
        assertEquals(expected, result);
    }
}
