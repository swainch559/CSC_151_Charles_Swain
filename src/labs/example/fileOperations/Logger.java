/*
@author Charles Swain
@date April 13th, 2026
@purpose This program reads log files, performs various analyses on the log data, and prints the results. It includes tasks such as counting log levels, analyzing memory limit errors, identifying disk space errors with associated IP addresses, and analyzing HTTP access logs for GMT offsets, status codes, response sizes, and unique HTTP methods.
 */

//Directory path
package labs.example.fileOperations;

//Importing necessary classes for file handling, input/output operations, and regular expressions
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logger {

    // Main method to execute the log analysis tasks
    public static void main(String[] args) {
        try {

            // Open the error log file and print its raw contents
            BufferedReader readerForPrinting = openErrorLog();
            String line;
            System.out.println("--- Raw Log Output ---");
            while ((line = readerForPrinting.readLine()) != null) {
                System.out.println(line);
            }
            readerForPrinting.close(); 
            System.out.println("----------------------\n");

            // Open the error log file again to perform various analyses
            BufferedReader file = openErrorLog();
            getCountOfErrorTypes(file);
            file.close();

            BufferedReader file2 = openErrorLog();
            getMemoryLimitExceededCount(file2);
            file2.close(); 

            BufferedReader diskFile = openErrorLog();
            getDiskSpaceErrorsWithIPAddress(diskFile);
            diskFile.close();

            // Open the HTTP access log file to perform analyses specific to HTTP requests and responses
            BufferedReader httpFile1 = openErrorLog("http_access_log");
            getGMTOffset(httpFile1);
            httpFile1.close();

            BufferedReader httpFile2 = openErrorLog("http_access_log");
            getHTTPCodes(httpFile2);
            httpFile2.close();

            BufferedReader httpFile3 = openErrorLog("http_access_log");
            getResponseSizes(httpFile3);
            httpFile3.close();

            BufferedReader httpFile4 = openErrorLog("http_access_log");
            groupHTTPMethodsAndEndPoints(httpFile4);
            httpFile4.close();

        } catch (IOException e) {
            System.err.println("Error processing logs: " + e.getMessage());
        }
    }

    // Method to open the default error log file and return a BufferedReader for reading its contents
    public static BufferedReader openErrorLog() throws FileNotFoundException {
        File logFile = new File("src/labs/example/fileOperations/logs/api_error.log");
        return new BufferedReader(new FileReader(logFile));
    }

    // Overloaded method to open a specific log file based on the provided file name and return a BufferedReader for reading its contents
    public static BufferedReader openErrorLog(String fileName) throws FileNotFoundException {
        String path = "src/labs/example/fileOperations/logs/";
        if (fileName.equals("http_access_log")) {
            path += "http_access.log";
        } else if (fileName.equals("api_error_log")) {
            path += "api_error.log";
        }
        return new BufferedReader(new FileReader(new File(path)));
    }

    // Method to count the occurrences of different log levels (ERROR, WARN, INFO, DEBUG) in the provided log file and print the counts
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

    // Method to count the occurrences of "Memory limit exceeded" errors in the provided log file, extract the associated endpoints, and print the results
    private static void getMemoryLimitExceededCount(BufferedReader file) throws IOException {
        int memoryErrors = 0;
        ArrayList<String> endpoints = new ArrayList<>();
        String line;

        while ((line = file.readLine()) != null) {
            if (line.contains("Memory limit exceeded")) {
                memoryErrors++;
                
                if (line.contains("| Endpoint: ")) {
                    String endpoint = line.substring(line.lastIndexOf("| Endpoint: ") + 12).trim();
                    endpoints.add(endpoint);
                }
            }
        }

        System.out.println("--- Memory Limit Analysis ---");
        System.out.println("Total Memory Limit Failures: " + memoryErrors);
        System.out.println("Affected Endpoints: " + endpoints);
        System.out.println("-----------------------------\n");
    }

    // Method to identify disk space errors in the provided log file and extract the associated IP addresses, then print the results
    private static void getDiskSpaceErrorsWithIPAddress(BufferedReader file) throws IOException {
        String line;
        int lineCount = 1;
        Pattern ipPattern = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
        System.out.println("--- Disk Space Error Report ---");
        while ((line = file.readLine()) != null) {
            if (line.toLowerCase().contains("disk space")) {
                String ipAddress = "Unknown";
                Matcher matcher = ipPattern.matcher(line);
                if (matcher.find()) {
                    ipAddress = matcher.group();
                }
                System.out.println("Disk space error on line " + lineCount + " for IP Address: " + ipAddress);
            }
            lineCount++;
        }
        System.out.println("-------------------------------\n");
    }

    // Method to analyze the GMT offsets in the timestamps of the provided log file, count the occurrences of each unique offset, and print the results
    private static void getGMTOffset(BufferedReader file) throws IOException {
        String line;
        ArrayList<String> offsets = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();
        while ((line = file.readLine()) != null) {
            int start = line.indexOf("[");
            int end = line.indexOf("]");
            if (start != -1 && end != -1) {
                String timestamp = line.substring(start + 1, end);
                String offset = timestamp.substring(timestamp.lastIndexOf(" ") + 1);
                if (!offsets.contains(offset)) {
                    offsets.add(offset);
                    counts.add(1);
                } else {
                    int index = offsets.indexOf(offset);
                    counts.set(index, counts.get(index) + 1);
                }
            }
        }
        System.out.println("--- GMT Offset Analysis ---");
        for (int i = 0; i < offsets.size(); i++) {
            System.out.println("GMT Offset " + offsets.get(i) + " occurs " + counts.get(i) + " times.");
        }
        System.out.println("---------------------------\n");
    }

    // Method to analyze the HTTP status codes in the provided log file and count the occurrences of each category (2xx, 3xx, 4xx, 5xx), then print the results
    private static void getHTTPCodes(BufferedReader file) throws IOException {
        String line;
        int c2xx = 0, c3xx = 0, c4xx = 0, c5xx = 0;
        Pattern pattern = Pattern.compile("\"\\s(\\d{3})\\s");
        while ((line = file.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String code = matcher.group(1);
                if (code.startsWith("2")) c2xx++;
                else if (code.startsWith("3")) c3xx++;
                else if (code.startsWith("4")) c4xx++;
                else if (code.startsWith("5")) c5xx++;
            }
        }
        System.out.println("--- HTTP Status Code Analysis ---");
        System.out.println("5xx Errors: " + c5xx);
        System.out.println("2xx Errors: " + c2xx);
        System.out.println("3xx Errors: " + c3xx);
        System.out.println("4xx Errors: " + c4xx);
        System.out.println("---------------------------------\n");
    }

    // Method to analyze the response sizes in the provided log file, count how many responses exceed a certain size threshold (e.g., 3900 bytes), and print the results
    private static void getResponseSizes(BufferedReader file) throws IOException {
        String line;
        int count = 0;
        Pattern pattern = Pattern.compile("\"\\s\\d{3}\\s(\\d+)");
        while ((line = file.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                try {
                    int size = Integer.parseInt(matcher.group(1));
                    if (size > 3900) count++;
                } catch (NumberFormatException e) {
                }
            }
        }
        System.out.println("--- Response Size Analysis ---");
        System.out.println("Total lines with response size > 3900: " + count);
        System.out.println("------------------------------\n");
    }

    // Method to analyze the HTTP methods and endpoints in the provided log file, identify unique HTTP methods used, and print the results
    private static void groupHTTPMethodsAndEndPoints(BufferedReader file) throws IOException {
        String line;
        ArrayList<String> verbs = new ArrayList<>();
        while ((line = file.readLine()) != null) {
            int firstQuote = line.indexOf("\"");
            int firstSpaceAfterQuote = line.indexOf(" ", firstQuote + 1);
            if (firstQuote != -1 && firstSpaceAfterQuote != -1) {
                String verb = line.substring(firstQuote + 1, firstSpaceAfterQuote);
                if (!verbs.contains(verb) && verb.equals(verb.toUpperCase()) && verb.length() > 2) {
                    verbs.add(verb);
                }
            }
        }
        System.out.println("--- Unique HTTP Methods ---");
        for (String v : verbs) {
            System.out.println(v);
        }
        System.out.println("---------------------------\n");
    }
}