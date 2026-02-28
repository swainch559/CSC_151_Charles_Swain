/*
@author Charles Swain
@date February 27, 2026
@purpose This defines a loops class that demonstrates the use of a while loop.
 */

//Directoy path
package labs.example.loops;


public class WhileLoop {

    // Main method to execute the while loop demonstration
    public static void main(String[] args) {

        // Create an instance of the WhileLoop class to call the method
        WhileLoop lab = new WhileLoop();
        
        // Execute the while loop demonstration
        lab.executeWhileLoop();
    }

    // Method to demonstrate a while loop that counts from 0 to 9
    private void executeWhileLoop() {
        int counter = 0;

        while (counter < 10) {
            counter++;
        }

        System.out.println("The number of iterations is: " + counter + 
                           ". The loop is now complete.");
    }
}