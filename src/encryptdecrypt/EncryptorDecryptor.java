package encryptdecrypt;

import encryptdecrypt.strategy.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EncryptorDecryptor {

    private Algorithm coder;
    private String mode, data, out, in;
    private int key;

    public EncryptorDecryptor(Algorithm coder, String mode, String data, String out, String in, int key) {
        this.coder = coder;
        this.mode = mode;
        this.data = data;
        this.out = out;
        this.in = in;
        this.key = key;
    }

    public void start() {
        prepareData();
        processData();
        outputData();
    }

    private void prepareData() {
        if (data.isEmpty() && in != null) {
            try {
                data = readFileAsString(in);
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
    }

    private void processData() {
        key = (mode.equals("enc") ? key : -key);

        data = coder.crypt(data, key);
    }

    private void outputData() {
        if (out != null) {
            try (FileWriter writer = new FileWriter(out)) {
                writer.write(data);
            } catch (IOException e) {
                System.out.println("Error");
            }
        } else
            System.out.println(data);
    }

    private String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
