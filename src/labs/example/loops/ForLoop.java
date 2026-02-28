/*
@author Charles Swain
@date February 27, 2026
@purpose This defines a loops class that demonstrates the use of a for loop.
 */

//Directory path
package labs.example.loops;


public class ForLoop {

    public static void main(String[] args) {
        
        // Create an instance of the ForLoop class to call the methods
        ForLoop lab = new ForLoop();

        // Execute the for loop demonstration
        lab.executeForLoop();
        
        // Demonstrate the sumTwoNumbers method and print the result
        int result = lab.sumTwoNumbers(10, 5);
        System.out.println("Summary of numbers 10 and 5 is: " + result);

        // Demonstrate the sumLoopCounter method and print the result
        int loopSum = lab.sumLoopCounter(10);
        System.out.println("The sum of the loop counter is: " + loopSum);

        // Demonstrate the printMultiplicationTable method for the number 5
        System.out.println("Multiplication table for 5:");
        lab.printMultiplicationTable(5);
    }

    // Method to demonstrate a for loop that counts from 0 to 19
    private void executeForLoop() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Loop counter: " + i);
        }
    }

    // Method to sum two numbers and return the result
    private int sumTwoNumbers(int a, int b) {
        return a + b;
    }

    // Method to sum the numbers from 0 to limit-1 using a for loop
    private int sumLoopCounter(int limit) {
        int sum = 0;
        for (int i = 0; i < limit; i++) {
            sum += i;
        }
        return sum;
    }

    // Method to print the multiplication table for a given number
    private void printMultiplicationTable(int number) {
        for (int i = 0; i <= 12; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }
}