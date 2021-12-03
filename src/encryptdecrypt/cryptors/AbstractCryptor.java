package encryptdecrypt.cryptors;

import java.io.IOException;

public abstract class AbstractCryptor {

    public void start() {
        try {
            prepareData();
            processData();
            outputData();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    protected abstract void prepareData() throws IOException;

    protected abstract void processData();

    protected abstract void outputData() throws IOException;
}
