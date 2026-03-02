/*
@author Charles Swain
@date March 2nd, 2026
@purpose This class creates, displays, and sorts arrays
 */

//Directory path
package labs.example.arrays;

//This class contains the main method to run the program.
public class Main {
    public static void main(String[] args) {

        // Create an instance of ArrayOperations to use its methods
        ArrayOperations ops = new ArrayOperations();
        
        // Create and display a new array with a default value of 5
        ops.createNewArray(5);
        
        // Create and sort a new array using Bubble Sort
        System.out.println("\n--- Starting Bubble Sort ---");

        // Create an unsorted array of integers
        int[] myUnsortedArray = new int[50];
        
        // Fill the unsorted array with values in reverse order
        for (int i = 0; i < myUnsortedArray.length; i++) {
            myUnsortedArray[i] = 50 - i;
        }

        // Sort the array using the Bubble Sort method
        ops.sortArray(myUnsortedArray);

        // Get and display the days of the week and months of the year
        ops.getDaysAndMonths();
    }
}