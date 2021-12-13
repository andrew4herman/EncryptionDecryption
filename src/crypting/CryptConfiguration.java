package crypting;

import crypting.strategy.Cipher;
import crypting.strategy.ShiftCipher;
import crypting.strategy.UnicodeCipher;

public class CryptConfiguration {

    private final CliParser parser;
    private String outFile, inFile, mode, data;
    private Cipher cipher;
    private int key;

    public CryptConfiguration(CliParser parser) {
        this.parser = parser;
    }

    public void setParameters() throws IllegalArgumentException {
        setOutFile(parser.optionOf("-out"));
        setInFile(parser.optionOf("-in"));
        setMode(parser.optionOrDefault("-mode", "enc"));
        setCipher(parser.optionOrDefault("-alg", "shift"));
        setData(parser.optionOrDefault("-data", ""));
        setKey(parser.optionOrDefault("-key", "0"));
    }

    private void setOutFile(String outFile) throws IllegalArgumentException {
        if (outFile != null && !outFile.endsWith(".txt"))
            throw new IllegalArgumentException("Error. Output file should be in .txt extension.");

        this.outFile = outFile;
    }

    private void setInFile(String inFile) {
        if (inFile != null && !inFile.endsWith(".txt"))
            throw new IllegalArgumentException("Error. Input file should be in .txt extension.");

        this.inFile = inFile;
    }

    private void setMode(String mode) {
        if (!mode.equals("enc") && !mode.equals("dec"))
            throw new IllegalArgumentException(String.format("Error. There is no %s mode.", mode));

        this.mode = mode;
    }

    private void setCipher(String algorithm) throws IllegalArgumentException {
        this.cipher = switch (algorithm) {
            case "unicode" -> new UnicodeCipher();
            case "shift" -> new ShiftCipher();
            default -> throw new IllegalArgumentException(
                    String.format("Error. There is no algorithm type for %s.", algorithm)
            );
        };
    }

    public void setData(String data) {
        this.data = data;
    }

    private void setKey(String _key) throws IllegalArgumentException {
        int key = 0;

        try {
            key = Integer.parseInt(_key);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    String.format("Error. Key %s is not valid. Please write a number.", _key)
            );
        } finally {
            this.key = key;
        }
    }

    public String getOutFile() {
        return outFile;
    }

    public String getInFile() {
        return inFile;
    }

    public String getMode() {
        return mode;
    }

    public String getData() {
        return data;
    }

    public Cipher getCipher() {
        return cipher;
    }

    public int getKey() {
        return key;
    }
}
