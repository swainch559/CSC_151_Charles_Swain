/*
@author Charles Swain
@date April 13th, 2026
@purpose This program reads an API error log file, counts the occurrences of different log levels (ERROR, WARN, INFO, DEBUG), and specifically counts how many times "Memory limit exceeded" errors occur while also tracking the affected endpoints. The program demonstrates file handling, string processing, and the use of ArrayLists to store dynamic data.
 */

//Directory path
package labs.example.fileOperations;

//Importing necessary classes for file handling, input/output operations, and ArrayList
import java.io.*;
import java.util.ArrayList;

public class Logger {

    //Main method to execute the log processing operations
    public static void main(String[] args) {
        try {

            // Open the error log file and print its raw contents
            BufferedReader readerForPrinting = openErrorLog();
            String line;

            // Print the raw log output to the console
            System.out.println("--- Raw Log Output ---");
            while ((line = readerForPrinting.readLine()) != null) {
                System.out.println(line);
            }
            readerForPrinting.close(); 
            System.out.println("----------------------\n");

            // Open the error log file again to analyze the log levels and memory limit errors
            BufferedReader file = openErrorLog();
            getCountOfErrorTypes(file);
            file.close();

            // Open the error log file a third time to specifically analyze "Memory limit exceeded" errors and their affected endpoints
            BufferedReader file2 = openErrorLog();
            getMemoryLimitExceededCount(file2);
            file2.close(); 

        } catch (IOException e) {
            System.err.println("Error processing logs: " + e.getMessage());
        }
    }

    // Method to open the API error log file and return a BufferedReader for reading its contents
    public static BufferedReader openErrorLog() throws FileNotFoundException {
        File logFile = new File("src/labs/example/fileOperations/logs/api_error.log");
        return new BufferedReader(new FileReader(logFile));
    }

    // Method to count the occurrences of different log levels (ERROR, WARN, INFO, DEBUG) in the log file and print the results
    public static void getCountOfErrorTypes(BufferedReader file) throws IOException {
        int error = 0, warn = 0, info = 0, debug = 0;
        String line;

        while ((line = file.readLine()) != null) {
            if (line.contains("[ERROR]")) error++;
            if (line.contains("[WARN]")) warn++;
            if (line.contains("[INFO]")) info++;
            if (line.contains("[DEBUG]")) debug++;
        }

        System.out.println("--- Log Level Counts ---");
        System.out.println("Errors: " + error);
        System.out.println("Warnings: " + warn);
        System.out.println("Info: " + info);
        System.out.println("Debug: " + debug);
        System.out.println("------------------------\n");
    }

    // Method to count how many times "Memory limit exceeded" errors occur in the log file and track the affected endpoints, then print the results
    private static void getMemoryLimitExceededCount(BufferedReader file) throws IOException {
        int memoryErrors = 0;
        ArrayList<String> endpoints = new ArrayList<>();
        String line;

        // Read through the log file line by line, counting "Memory limit exceeded" errors and extracting affected endpoints
        while ((line = file.readLine()) != null) {
            if (line.contains("Memory limit exceeded")) {
                memoryErrors++;
                
                if (line.contains("on ")) {
                    String endpoint = line.substring(line.lastIndexOf("on ") + 3);
                    endpoints.add(endpoint);
                }
            }
        }

        System.out.println("--- Memory Limit Analysis ---");
        System.out.println("Total Memory Limit Failures: " + memoryErrors);
        System.out.println("Affected Endpoints: " + endpoints);
        System.out.println("-----------------------------");
    }
}