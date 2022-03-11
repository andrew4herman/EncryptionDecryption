package crypting;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Util class for reading and writing files
 */
public class FileReaderWriter {

    private FileReaderWriter() {
        throw new IllegalStateException();
    }

    /**
     * Reads the contents of a file into a string
     *
     * @param fileName The name of the file to read from.
     * @return A String with a content of file.
     */
    public static String readFrom(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    /**
     * Write the given data to the given file
     *
     * @param fileName The name of the file to write to.
     * @param data     The data to be written to the file.
     */
    public static void writeTo(String fileName, String data) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write(data);
    }
}
