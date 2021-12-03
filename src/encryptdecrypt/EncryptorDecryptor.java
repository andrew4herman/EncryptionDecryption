package encryptdecrypt;

import encryptdecrypt.strategy.Algorithm;
import encryptdecrypt.strategy.ShiftAlgorithm;
import encryptdecrypt.strategy.UnicodeAlgorithm;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EncryptorDecryptor {

    private Algorithm coder;
    private String mode, data, out, in;
    private int key;

    private void setCoder(String type) {
        switch (type) {
            case "shift":
                coder = new ShiftAlgorithm();
                break;
            case "unicode":
                coder = new UnicodeAlgorithm();
                break;
        }
    }

    public EncryptorDecryptor() {
        coder = new ShiftAlgorithm();
        mode = "enc";
        data = "";
        key = 0;
    }

    public void start(String[] args) {
        parseArgs(args);

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

    private void parseArgs(String[] args) {
        for (int i = 0; i < args.length; i = i + 2) {
            switch (args[i]) {
                case "-mode":
                    this.mode = args[i + 1];
                    break;
                case "-key":
                    this.key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    this.data = args[i + 1];
                    break;
                case "-out":
                    this.out = args[i + 1];
                    break;
                case "-in":
                    this.in = args[i + 1];
                    break;
                case "-alg":
                    setCoder(args[i + 1]);
            }
        }
    }

    private String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
