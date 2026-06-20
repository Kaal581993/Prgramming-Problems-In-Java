package exception_handling.intermediate.try_with_resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderDemo {

    public static void main(String[] args) {
        String filePath = "/home/kaal/.gemini/antigravity/scratch/exception_handling/intermediate/try_with_resources/students.csv";
        System.out.println("--- Reading CSV File: " + filePath + " ---");
        readCSV(filePath);
    }

    public static void readCSV(String filePath) {
        // Step 1: Declare resources inside the try-with-resources statement
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            int lineNumber = 0;

            // Step 2: Read line-by-line
            while ((line = bufferedReader.readLine()) != null) {
                lineNumber++;

                // Step 3: Parse fields using split(",")
                String[] fields = line.split(",");

                // Step 4: Process the fields
                if (lineNumber == 1) {
                    System.out.print("[Header] ");
                } else {
                    System.out.print("Record #" + (lineNumber - 1) + ": ");
                }

                for (int i = 0; i < fields.length; i++) {
                    System.out.print(
                            fields[i]
                                    .trim()
                                    + (i < fields.length - 1 ? " | " : "")
                    );
                }
                System.out.println();
            }

        } catch (IOException e) {
            // Step 5: Handle exception gracefully
            System.err.println(
                    "An error occurred while reading the CSV file: " +
                            e.getMessage());
        }
    }
}