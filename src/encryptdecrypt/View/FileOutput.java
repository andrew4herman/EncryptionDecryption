package encryptdecrypt.View;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutput implements Output {

    private String filename;

    public FileOutput(String filename) {
        this.filename = filename;
    }

    @Override
    public void output(String data) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(data);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
