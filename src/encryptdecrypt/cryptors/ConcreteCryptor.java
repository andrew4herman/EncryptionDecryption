package encryptdecrypt.cryptors;

import encryptdecrypt.strategy.Algorithm;
import encryptdecrypt.util.ReaderWriter;

import java.io.IOException;

public class ConcreteCryptor extends AbstractCryptor {

    private final Algorithm coder;
    private final String mode, out, in;
    private final int key;
    private String data;

    public ConcreteCryptor(Algorithm coder, String mode, String data, String out, String in, int key) {
        this.coder = coder;
        this.mode = mode;
        this.data = data;
        this.out = out;
        this.in = in;
        this.key = key;
    }

    @Override
    protected void prepareData() throws IOException {
        if (data.isEmpty() && in != null)
            data = ReaderWriter.readFileAsString(in);
    }

    @Override
    protected void processData() {
        data = coder.crypt(
                data,
                mode.equals("enc") ? key : -key
        );
    }

    @Override
    protected void outputData() throws IOException {
        ReaderWriter.outputData(data, out);
    }
}
