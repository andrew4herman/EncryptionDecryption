package crypting;

import crypting.strategy.ShiftCipher;
import crypting.strategy.UnicodeCipher;

public class Main {

    private static CliParser parser;
    private static Cryptor cryptor;

    public static void main(String[] args) {
        parser = new CliParser(args);
        cryptor = new Cryptor(new ShiftCipher());

        if ("unicode".equals(parser.optionOf("-alg")))
            cryptor.setCipher(new UnicodeCipher());

        String outFilePath = parser.optionOf("-out");
        String cryptedData = getCryptedOf(readData());

        if (outFilePath != null)
            FileReaderWriter.writeTo(outFilePath, cryptedData);
        else System.out.println(cryptedData);
    }

    private static String readData() {
        String data = parser.optionOrDefault("-data", "");

        if (data.isEmpty() && parser.optionOf("-in") != null)
            data = FileReaderWriter.readFrom(parser.optionOf("-in"));

        return data;
    }

    private static String getCryptedOf(String raw) {
        int key = Integer.parseInt(parser.optionOrDefault("-key", "0"));

        return switch (parser.optionOf("-mode")) {
            case "dec" -> cryptor.decrypt(raw, key);
            default -> cryptor.encrypt(raw, key);
        };
    }
}
