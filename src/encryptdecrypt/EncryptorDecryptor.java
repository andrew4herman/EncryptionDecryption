package encryptdecrypt;

import encryptdecrypt.strategy.*;
import encryptdecrypt.util.ReaderWriter;

import java.io.IOException;

public class EncryptorDecryptor {

    private final Algorithm coder;
    private final String mode, out, in;
    private final int key;
    private String data;

    public EncryptorDecryptor(Algorithm coder, String mode, String data, String out, String in, int key) {
        this.coder = coder;
        this.mode = mode;
        this.data = data;
        this.out = out;
        this.in = in;
        this.key = key;
    }

    public void start() {
        try {
            prepareData();
            processData();
            outputData();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    private void prepareData() throws IOException {
        if (data.isEmpty() && in != null)
            data = ReaderWriter.readFileAsString(in);
    }

    private void processData() {
        data = coder.crypt(
                data,
                mode.equals("enc") ? key : -key
        );
    }

    private void outputData() throws IOException {
        ReaderWriter.outputData(data, out);
    }
}
