package crypting;

import crypting.strategy.UnicodeCipher;

public class Main {

    private static CliParser parser;
    private static Cryptor cryptor;

    public static void main(String[] args) {
        parser = new CliParser(args);
        cryptor = new Cryptor();

        if ("unicode".equals(parser.optionOf("-alg")))
            cryptor.setCipher(new UnicodeCipher());

        if (parser.optionOf("-out") != null)
            FileReaderWriter.writeTo(parser.optionOf("-out"), getCryptedData());
        else
            System.out.println(getCryptedData());
    }

    private static String readData() {
        String data = parser.optionOrDefault("-data", "");

        if (data.isEmpty() && parser.optionOf("-in") != null)
            data = FileReaderWriter.readFrom(parser.optionOf("-in"));

        return data;
    }

    private static String getCryptedData() {
        String data = readData();
        int key = Integer.parseInt(parser.optionOrDefault("-key", "0"));

        return switch (parser.optionOrDefault("-mode", "enc")) {
            case "dec" -> cryptor.decrypt(data, key);
            default -> cryptor.encrypt(data, key);
        };
    }
}
