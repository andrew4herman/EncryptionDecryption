package encryptdecrypt;

import encryptdecrypt.cryptors.AbstractCryptor;
import encryptdecrypt.cryptors.ConcreteCryptor;
import encryptdecrypt.parsers.CliParser;
import encryptdecrypt.strategy.ShiftAlgorithm;
import encryptdecrypt.strategy.UnicodeAlgorithm;

public class Main {

    public static void main(String[] args) {
        CliParser parser = new CliParser(args);

        AbstractCryptor cryptor = new ConcreteCryptor(
                parser.optionValueOrDefault("-alg", "shift")
                        .equals("shift") ? new ShiftAlgorithm() : new UnicodeAlgorithm(),

                parser.optionValueOrDefault("-mode", "enc"),
                parser.optionValueOrDefault("-data", ""),
                parser.optionValue("-out"),
                parser.optionValue("-in"),
                Integer.parseInt(parser.optionValueOrDefault("-key", "0"))
        );

        cryptor.start();
    }
}
