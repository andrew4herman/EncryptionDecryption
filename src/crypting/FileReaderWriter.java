package crypting;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderWriter {

    public static String readFrom(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void writeTo(String fileName, String data) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write(data);
    }
}
