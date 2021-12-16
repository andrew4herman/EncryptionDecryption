package crypting;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        CryptConfiguration config;
        config = new CryptConfiguration(new CliParser(args));
        Cryptor cryptor = new Cryptor(config.getCipher());

        try {
            String inputData = getInputData(config);
            String cryptedData = cryptData(config, cryptor, inputData);
            writeCryptedData(config.getOutFile(), cryptedData);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    private static String getInputData(CryptConfiguration config) throws IOException {
        return config.getData() == null ?
                FileReaderWriter.readFrom(config.getInFile()) :
                config.getData();
    }

    private static String cryptData(CryptConfiguration config, Cryptor cryptor, String data) {
        return "dec".equals(config.getMode()) ?
                cryptor.decrypt(data, config.getKey()) :
                cryptor.encrypt(data, config.getKey());
    }

    private static void writeCryptedData(String filepath, String cryptedData) throws IOException {
        if (filepath != null) {
            FileReaderWriter.writeTo(filepath, cryptedData);
        } else {
            System.out.println(cryptedData);
        }
    }
}
