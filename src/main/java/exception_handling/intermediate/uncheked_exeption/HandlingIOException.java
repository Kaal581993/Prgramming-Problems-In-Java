package exception_handling.intermediate.uncheked_exeption;

import java.io.FileReader;
import java.io.IOException;

public class HandlingIOException {

    public static void main(String[] args) throws IOException {
        // The try-catch block is removed; main propagates the exception using throws
        readFile("non_existent_file.txt");
    }

    public static void readFile(String fileName) throws IOException {
        // FileReader constructor throws FileNotFoundException (subclass of IOException)
        // read() method throws IOException
        FileReader reader = new FileReader(fileName);
        reader.read();
        reader.close();
    }
}