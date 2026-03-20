/*
@author Charles Swain
@date March 20th, 2026
@purpose This program initializes three arrays with random values, calculates their sums manually, and determines which array has the highest sum.
 */

//Directory path
package labs.example.arrays;

//Importing necessary classes
import java.util.Random;

public class ArrayAnalysis {

    public static void main(String[] args) {
        // Initialize arrays with 25 elements each
        int[] arr1 = new int[25];
        int[] arr2 = new int[25];
        int[] arr3 = new int[25];

        // Populate arrays with random values
        populateArray(arr1);
        populateArray(arr2);
        populateArray(arr3);

        // Calculate sums manually using our custom method
        int sum1 = calculateSum(arr1);
        int sum2 = calculateSum(arr2);
        int sum3 = calculateSum(arr3);

        // Print individual sums
        System.out.println("--- Array Sums ---");
        System.out.println("Sum of arr1: " + sum1);
        System.out.println("Sum of arr2: " + sum2);
        System.out.println("Sum of arr3: " + sum3);

        // Determine which sum is the highest
        if (sum1 >= sum2 && sum1 >= sum3) {
            printResult("arr1", sum1, arr1);
        } else if (sum2 >= sum1 && sum2 >= sum3) {
            printResult("arr2", sum2, arr2);
        } else {
            printResult("arr3", sum3, arr3);
        }
    }

    // Method to calculate the sum of an array manually
    public static int calculateSum(int[] array) {
        int total = 0;
        for (int value : array) {
            total += value;
        }
        return total;
    }

    // Method to populate an array with random values between 1 and 100
    public static void populateArray(int[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100) + 1;
        }
    }

    // Method to print the result of the analysis
    public static void printResult(String name, int total, int[] array) {
        System.out.println("\n--- Array Results ---");
        System.out.println("The array with the highest sum is: " + name);
        System.out.println("Total Value: " + total);
        System.out.print("Array Contents: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + (i < array.length - 1 ? ", " : ""));
        }
        System.out.println();
    }
}