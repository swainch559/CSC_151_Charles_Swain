/*
@author Charles Swain
@date March 2nd, 2026
@purpose This class contains methods to create, display, sort, and process arrays.
 */

//Directory path
package labs.example.arrays;

//This class contains methods to create, display, sort, and process arrays.
public class ArrayOperations {

    // Method to create and display a new array
    public void createNewArray(int defaultValue) {
        int[] myArray = new int[10];

        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = defaultValue + i;
        }

        displayArray(myArray);
    }

    // Helper method to display the contents of an array
    private void displayArray(int[] arrayToPrint) {
        System.out.println("--- Displaying Array ---");
        System.out.println("I created a new array and it now has " + arrayToPrint.length + " items in it.");
        System.out.println("The array items and their values are listed below: ");
        
        for (int i = 0; i < arrayToPrint.length; i++) {
            System.out.print(arrayToPrint[i] + " ");
        }
        System.out.println();
    }

    // Method to sort an array using Bubble Sort
    public void sortArray(int[] unsortedArray) {
        int n = unsortedArray.length;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (unsortedArray[j - 1] > unsortedArray[j]) {
                    temp = unsortedArray[j - 1];
                    unsortedArray[j - 1] = unsortedArray[j];
                    unsortedArray[j] = temp;
                }
            }
        }

        System.out.println("The array has been sorted using Bubble Sort:");
        for (int value : unsortedArray) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Method to get and display the days of the week and months of the year
    public void getDaysAndMonths() {
        System.out.println();
        System.out.println("--- Days in Each Month ---");
        String[] months = {
            "January", "February", "March", "April", "May", "June", 
            "July", "August", "September", "October", "November", "December"
        };

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 0; i < months.length; i++) {
            System.out.println("There are " + days[i] + " days in " + months[i]);
        }
    }
}