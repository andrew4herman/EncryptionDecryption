package crypting;

import crypting.strategy.*;

public class Main {

    public static void main(String[] args) {
        CliParser parser = new CliParser(args);
        Cryptor cryptor = new Cryptor(new ShiftCipher());

        String outFilePath = parser.optionOf("-out");
        String inFilePath = parser.optionOf("-in");
        String mode = parser.optionOf("-mode");
        String algorithm = parser.optionOf("-alg");
        String data = parser.optionOrDefault("-data", "");
        int key = Integer.parseInt(parser.optionOrDefault("-key", "0"));

        if ("unicode".equals(algorithm))
            cryptor.setCipher(new UnicodeCipher());

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
