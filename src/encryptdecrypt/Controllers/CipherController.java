package encryptdecrypt.Controllers;

import encryptdecrypt.Model.Data;
import encryptdecrypt.View.Output;
import encryptdecrypt.cryptors.Cryptor;

public class CipherController {

    private Data model;
    private Output view;
    private Cryptor cryptor;

    public CipherController(Data model, Output view) {
        this.model = model;
        this.view = view;
    }

    public void setData(String text) {
        this.model = new Data(text);
    }

    public void setOutput(Output view) {
        this.view = view;
    }

    public void setCryptor(Cryptor cryptor) {
        this.cryptor = cryptor;
    }

    public void updateModel() {
        setData(cryptor.crypt(model.text()));
    }

    public void updateView() {
        view.output(model.text());
    }
}
