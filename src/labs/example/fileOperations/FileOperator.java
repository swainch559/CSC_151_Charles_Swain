/*
@author Charles Swain
@date March 23rd, 2026
@purpose This program reads a CSV file containing student names and their scores in three subjects, calculates the average score for each student, and prints the results.
 */

//Directory path
package labs.example.fileOperations;

//Importing neccesary classes for file handling and input/output operations
import java.io.*;

public class FileOperator {

    // Main method to execute the file operations
    public static void main(String[] args) {

        File csvFile = new File("src/labs/example/fileOperations/files/users.csv");
        File logFile = new File("src/labs/example/fileOperations/logs/csv_error.log");


        // Create the log file if it doesn't exist
        try {
            if (logFile.createNewFile()) {
                System.out.println("Created log file: " + logFile.getName());
            }

        // Catch any IO exceptions that may occur during file creation
        } catch (IOException e) {
            System.out.println("An error occurred creating the log file.");
        }

        // Read the CSV file and process the data
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean isHeader = true;

            // Read each line of the CSV file
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }


                // Split the line into components and parse the scores
                String[] data = line.split(",");
                String name = data[0];
                
                // Parse the scores for math, science, and english
                double math = Double.parseDouble(data[1]);
                double science = Double.parseDouble(data[2]);
                double english = Double.parseDouble(data[3]);
                double average = (math + science + english) / 3;

                // Print the student's name and their average score formatted to two decimal places
                System.out.printf("Student: %s | Average: %.2f%n", name, average);
            }

        // Catch specific exceptions related to file handling and log the errors
        } catch (FileNotFoundException e) {
            System.err.println("Error: users.csv not found at " + csvFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error reading the file.");
        }
    }
}