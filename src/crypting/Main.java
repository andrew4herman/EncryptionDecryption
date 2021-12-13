package crypting;

import java.io.IOException;
import java.security.InvalidParameterException;

public class Main {

    public static void main(String[] args) {
        CryptConfiguration config;
        try {
            config = new CryptConfiguration(new CliParser(args));
            config.setParameters();
        } catch (InvalidParameterException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        Cryptor cryptor = new Cryptor(config.getCipher());

        try {
            if (config.getData().isEmpty() && config.getInFile() != null)
                config.setData(FileReaderWriter.readFrom(config.getInFile()));

            String cryptedData = "dec".equals(config.getMode()) ?
                    cryptor.decrypt(config.getData(), config.getKey()) :
                    cryptor.encrypt(config.getData(), config.getKey());

            if (config.getOutFile() != null)
                FileReaderWriter.writeTo(config.getOutFile(), cryptedData);
            else
                System.out.println(cryptedData);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
