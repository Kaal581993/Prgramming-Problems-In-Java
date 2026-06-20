//package exception_handling.intermediate.try_with_resources;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class ReadMultipleFiles {
//
//    public static void main(String[] args) {
//
//        try {
//                        FileReader fr = new FileReader("textfile.txt");
//                        BufferedReader br = new BufferedReader(fr);
//
//                        br.readLine();
//
//                        System.out.println(br);
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//}


/**
 * the provided code does not solve the problem. Here are the
 * issues with the code snippet:
 *
 * No Try-with-Resources Syntax: The code uses a standard try-catch block.
 * The FileReader and BufferedReader are initialized inside the try block
 * but are never closed. Try-with-resources automatically closes resources
 * implementing AutoCloseable when exiting the block.
 *
 * Only Reads One File: The code only instantiates a single FileReader for
 * "textfile.txt", whereas the problem specifically asks to read multiple files.
 * Prints the Object instead of Content: The statement System.out.println(br);
 *
 * prints the string representation of the BufferedReader object
 * (e.g., java.io.BufferedReader@1a2b3c) rather than the content of the file.
 * */


//Correct Solution:


package exception_handling.intermediate.try_with_resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadMultipleFiles {

    public static void main(String[] args) {
        String file1 = "file1.txt";
        String file2 = "file2.txt";

        // Declare resources inside the try(...) block separated by a semicolon.
        // Both resources will be automatically closed in the reverse order of their creation.
        try (FileReader fr1 = new FileReader(file1);
             BufferedReader br1 = new BufferedReader(fr1);
             FileReader fr2 = new FileReader(file2);
             BufferedReader br2 = new BufferedReader(fr2)) {

            System.out.println("Reading " + file1 + ":");
            String line;
            while ((line = br1.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("\nReading " + file2 + ":");
            while ((line = br2.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }
}