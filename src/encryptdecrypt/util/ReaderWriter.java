package encryptdecrypt.util;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReaderWriter {

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void outputData(String data, String outFile) throws IOException {
        if (outFile != null) {
            FileWriter writer = new FileWriter(outFile);
            writer.write(data);
        } else System.out.println(data);
    }
}
