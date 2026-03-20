/*
@author Charles Swain
@date March 20th, 2026
@purpose This defines a class to compare two arrays for length and value equality without using built-in methods.
 */

//Directory path
package labs.example.arrays;

//Importing necessary classes
import java.util.Arrays;

public class ArrayComparison {

    public static void main(String[] args) {

        // Initialize two arrays for comparison
        int[] firstArray = {10, 20, 30, 40, 50};
        int[] secondArray = {10, 20, 25, 40, 50};

        // Display the contents of both arrays
        System.out.println("First Array: " + Arrays.toString(firstArray));
        System.out.println("Second Array: " + Arrays.toString(secondArray));

        //Check for Length
        boolean sameLength = (firstArray.length == secondArray.length);
        
        if (sameLength) {
            System.out.println("Yes, these arrays are the same length.");
        } else {
            System.out.println("No, these arrays are not the same length.");
        }

        //Check for Equality
        boolean sameValues = checkEquality(firstArray, secondArray);

        if (sameValues) {
            System.out.println("Yes, these arrays do contain the same values.");
        } else {
            System.out.println("No, these arrays do not contain the same values.");
        }
    }

    // Method to check if two arrays are equal in terms of values
    public static boolean checkEquality(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        // Iterate through each index and compare values
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}