/*
@author Charles Swain
@date March 20th, 2026
@purpose This defines a physics class.
 */

//Directory path
package labs.example.arrays;

//Importing necessary classes
import java.util.Scanner;

public class CreditCardValidator {

    public static void main(String[] args) {

        //"Known-Good" numbers:
        // Visa: 4539148302880058
        // MasterCard: 5491621813570005
        
        // Prompt the user to enter a credit card number
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a credit card number to validate: ");
        String cardNumber = input.nextLine();

        // Validate the credit card number using the Mod-10 (Luhn) algorithm
        if (isValidMod10(cardNumber)) {
            System.out.println("Credit Card " + cardNumber + " is valid.");
        } else {
            System.out.println("Credit Card " + cardNumber + " is not valid.");
        }
        
        input.close();
    }

    // Method to validate a credit card number using the Mod-10 (Luhn) algorithm
    public static boolean isValidMod10(String cardNo) {
        int nDigits = cardNo.length();
        int sum = 0;
        boolean isSecond = false;

        // Traverse the string from right to left
        for (int i = nDigits - 1; i >= 0; i--) {

            // Convert char to int
            int d = cardNo.charAt(i) - '0';

            if (isSecond == true) {
                d = d * 2;
            }

            // Add the digits of the product (if it's greater than 9, add the digits together)
            sum += d / 10;
            sum += d % 10;

            // Flip the boolean for the next iteration
            isSecond = !isSecond;
        }

        // The card is valid if the total sum is divisible by 10
        return (sum % 10 == 0);
    }
}