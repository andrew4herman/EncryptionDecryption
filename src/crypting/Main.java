package crypting;

import crypting.strategy.ShiftCipher;
import crypting.strategy.UnicodeCipher;

public class Main {

    public static void main(String[] args) {
        CliParser parser = new CliParser(args);
        Cryptor cryptor;

        String outFilePath = parser.optionOf("-out");
        String inFilePath = parser.optionOf("-in");
        String mode = parser.optionOf("-mode");
        String algorithm = parser.optionOf("-alg");
        String data = parser.optionOrDefault("-data", "");
        int key = Integer.parseInt(parser.optionOrDefault("-key", "0"));

        cryptor = new Cryptor("unicode".equals(algorithm) ?
                new UnicodeCipher() :
                new ShiftCipher()
        );

        if (data.isEmpty() && inFilePath != null)
            data = FileReaderWriter.readFrom(parser.optionOf("-in"));

        String cryptedData = "dec".equals(mode) ?
                cryptor.decrypt(data, key) :
                cryptor.encrypt(data, key);

        if (outFilePath != null)
            FileReaderWriter.writeTo(outFilePath, cryptedData);
        else
            System.out.println(cryptedData);
    }
}
