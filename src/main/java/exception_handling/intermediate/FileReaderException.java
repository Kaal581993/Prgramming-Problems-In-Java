//package exception_handling.intermediate;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class FileReaderException {
//    public static void main(String[] args){
//
//
//        try(FileReader fr = new FileReader("textfile.txt");){
//            fr.read();
//
//        }catch (FileNotFoundException fe){
//
//
//            System.out.println("'textfile.txt' not Found");
//        }catch(IOException e){
//            System.out.println("Error reading file: "+e.getMessage());
//        }
//
//
//    }
//}



package exception_handling.intermediate;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderException {
    public static void main(String[] args) {
        // Use try-with-resources to ensure the FileReader is closed automatically
        try (FileReader fr = new FileReader("textfile.txt")) {
            int data = fr.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fr.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: 'textfile.txt' not found.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
