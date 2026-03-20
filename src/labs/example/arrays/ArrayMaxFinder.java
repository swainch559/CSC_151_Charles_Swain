/*
@author Charles Swain
@date March 20th, 2026
@purpose This defines a class to find the maximum value in an array of integers without using built-in methods.
 */

//Directory path
package labs.example.arrays;

//Importing necessary classes
import java.util.Random;

public class ArrayMaxFinder {

    public static void main(String[] args) {

        // Initialize the array with 50 elements
        int[] myArray = new int[50];
        
        // Populate the array with random integers
        Random rand = new Random();

        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = rand.nextInt(1000) + 1;
        }

        // Determine the highest value
        int highestValue = findMax(myArray);

        // Print the result
        System.out.println("The highest value in the myArray object is: " + highestValue);
    }

    // Method to find the maximum value in an array of integers
    public static int findMax(int[] array) {

        if (array.length == 0) return 0;

        int currentMax = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > currentMax) {
                currentMax = array[i];
            }
        }

        return currentMax;
    }
}