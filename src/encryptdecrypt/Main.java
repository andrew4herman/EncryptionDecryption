package encryptdecrypt;

import encryptdecrypt.Controllers.CipherController;
import encryptdecrypt.Model.Data;
import encryptdecrypt.View.*;
import encryptdecrypt.cryptors.*;
import encryptdecrypt.strategy.*;
import encryptdecrypt.util.*;

import java.io.IOException;

public class Main {

    private CipherController controller;
    private CliParser parser;

    public Main(CliParser parser) {
        this.parser = parser;

        controller = new CipherController(
                new Data(parser.optionOrDefaultOf("-data", "")),
                new ConsoleOutput()
        );
    }

    public static void main(String[] args) {
        Main main = new Main(new CliParser(args));
        main.execute();
    }

    public void execute() {
        try {
            setData();
            setOutput();
            setCryptor();
        } catch (IOException e) {
            System.out.println("Error");
        }

        controller.updateModel();
        controller.updateView();
    }

    private void setData() throws IOException {
        if (parser.optionOrDefaultOf("-data", "").isEmpty() &&
                parser.optionOf("-in") != null)
            controller.setData(FileReader.readFileAsString(parser.optionOf("-in")));
    }

    private void setOutput() {
        if (parser.optionOf("-out") != null)
            controller.setOutput(new FileOutput(parser.optionOf("-out")));
    }

    private void setCryptor() {
        Cipher cipher = switch (parser.optionOf("-alg")) {
            case "unicode" -> new UnicodeCipher();
            default -> new ShiftCipher();
        };

        int key = Integer.parseInt(parser.optionOrDefaultOf("-key", "0"));

        controller.setCryptor(
               switch (parser.optionOf("-mode")) {
                   case "dec" -> new Decryptor(cipher, key);
                   default -> new Encryptor(cipher, key);
               }
        );
    }
}
