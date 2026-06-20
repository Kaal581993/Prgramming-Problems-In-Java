package exception_handling.intermediate.advance.interview_problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReadEmployeeRecord {

    public static void main(String[] args) {
        String baseDir = "/home/kaal/Documents/Java Coding Test/src/main/java/exception_handling/intermediate/advance/interview_problems/";
        
        System.out.println("--- Test 1: Reading Valid CSV ---");
        try {
            readCSVToMap(baseDir + "employees.csv");
        } catch (Exception e) {
            System.err.println("Unexpected Error: " + e.getMessage());
        }

        System.out.println("\n--- Test 2: Reading CSV with Missing Header ---");
        try {
            readCSVToMap(baseDir + "employees_missing_header.csv");
        } catch (MissingColumnException | InvalidSalaryException | InvalidAgeException | IOException e) {
            System.err.println("Caught Expected Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        System.out.println("\n--- Test 3: Reading CSV with Missing Column Value ---");
        try {
            readCSVToMap(baseDir + "employees_missing_col.csv");
        } catch (MissingColumnException | InvalidSalaryException | InvalidAgeException | IOException e) {
            System.err.println("Caught Expected Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        System.out.println("\n--- Test 4: Reading CSV with Invalid Salary ---");
        try {
            readCSVToMap(baseDir + "employees_invalid_salary.csv");
        } catch (MissingColumnException | InvalidSalaryException | InvalidAgeException | IOException e) {
            System.err.println("Caught Expected Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        System.out.println("\n--- Test 5: Reading CSV with Invalid Age ---");
        try {
            readCSVToMap(baseDir + "employees_invalid_age.csv");
        } catch (MissingColumnException | InvalidSalaryException | InvalidAgeException | IOException e) {
            System.err.println("Caught Expected Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    public static Map<String, List<String>> readCSVToMap(String filePath) 
            throws IOException, MissingColumnException, InvalidSalaryException, InvalidAgeException {

        Map<String, List<String>> csvData = new LinkedHashMap<>();
        List<String> headers = new ArrayList<>();
        List<String> requiredHeaders = List.of("Name", "employee_id", "Salary", "Department", "Age");

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            boolean isHeader = true;
            int lineNumber = 0;

            while ((line = bufferedReader.readLine()) != null) {
                lineNumber++;
                if (line.trim().isEmpty()) continue; // Skip empty lines

                String[] fields = line.split(",", -1); // Keep empty trailing fields

                if (isHeader) {
                    // Initialize the map keys with the headers
                    for (String field : fields) {
                        String headerName = field.trim();
                        headers.add(headerName);
                        csvData.put(headerName, new ArrayList<>());
                    }

                    // Validate that all required headers are present (case-insensitive check)
                    for (String required : requiredHeaders) {
                        boolean found = false;
                        for (String header : headers) {
                            if (header.equalsIgnoreCase(required)) {
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            throw new MissingColumnException("Missing required column header: '" + required + "'");
                        }
                    }
                    isHeader = false;
                } else {
                    // Validate record length against headers length
                    if (fields.length < headers.size()) {
                        throw new MissingColumnException("Line " + lineNumber + ": Record has " + fields.length 
                                + " values, but expected " + headers.size());
                    }

                    // Temporary storage to prevent partial additions if validation fails
                    String[] rowValues = new String[headers.size()];

                    for (int i = 0; i < headers.size(); i++) {
                        String header = headers.get(i);
                        String value = fields[i].trim();

                        // Check if a required column is empty/missing
                        boolean isRequiredField = false;
                        for (String req : requiredHeaders) {
                            if (header.equalsIgnoreCase(req)) {
                                isRequiredField = true;
                                break;
                            }
                        }
                        if (isRequiredField && value.isEmpty()) {
                            throw new MissingColumnException("Line " + lineNumber + ": Missing value for required column '" + header + "'");
                        }

                        // Validate Salary
                        if (header.equalsIgnoreCase("Salary")) {
                            try {
                                int salary = Integer.parseInt(value);
                                if (salary < 0) {
                                    throw new InvalidSalaryException("Line " + lineNumber + ": Salary cannot be less than 0: " + salary);
                                }
                            } catch (NumberFormatException nfe) {
                                throw new InvalidSalaryException("Line " + lineNumber + ": Invalid salary format (must be an integer): '" + value + "'");
                            }
                        }

                        // Validate Age
                        if (header.equalsIgnoreCase("Age")) {
                            try {
                                int age = Integer.parseInt(value);
                                if (age < 18) {
                                    throw new InvalidAgeException("Line " + lineNumber + ": Age must be 18 or older: " + age);
                                }
                            } catch (NumberFormatException nfe) {
                                throw new InvalidAgeException("Line " + lineNumber + ": Invalid age format (must be an integer): '" + value + "'");
                            }
                        }

                        rowValues[i] = value;
                    }

                    // If all fields of the row passed validation, add to the main map
                    for (int i = 0; i < headers.size(); i++) {
                        csvData.get(headers.get(i)).add(rowValues[i]);
                    }
                }
            }
        }

        System.out.println("Import Successful: " + csvData);
        return csvData;
    }
}

// Custom exception classes
class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class MissingColumnException extends Exception {
    public MissingColumnException(String message) {
        super(message);
    }
}