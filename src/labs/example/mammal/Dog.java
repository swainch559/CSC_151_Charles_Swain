/*
@author Charles Swain
@date February 12, 2026
@purpose This defines a Dog class that extends the Mammal class.
 */

// Directory path
package labs.example.mammal;

// Import the Mammal class
public class Dog extends Mammal {
    
    // Dog-specific method
    public void bark() {
        System.out.println("The dog says: Woof! Woof!");
    }

    // Override the sit method to provide dog-specific behavior (for demonstration of ovverriding)
    @Override
    public void sit() {
        System.out.println("The dog obediently sits down...");
        super.sit(); 
    }
}
