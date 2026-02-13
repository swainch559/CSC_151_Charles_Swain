/*
@author Charles Swain
@date February 12, 2026
@purpose This calls the methods defined in the Mammal class.
 */

// Directory path
package labs.example.mammal;

// Import the Mammal class
public class Main {
    public static void main(String[] args) {

        // Creates an instance of the Dog class (was mammal)
        Dog myDog = new Dog();

        // Call methods
        System.out.println("\n--- Methods ---");
        myDog.run();
        myDog.eat();
        myDog.sleep();
        myDog.scratch();
        myDog.breathe();
        myDog.makeSound();
        myDog.nurseYoung();
        myDog.groomSelf();
        myDog.hunt();
        myDog.getMammalDetails();
        
        // Dog-specific actions with sitting override
        System.out.println("\nDog specific actions:");
        myDog.bark();
        System.out.println("\nStarts sitting...");
        myDog.sit();
        int leg1 = myDog.walk(3);
        int leg2 = myDog.walk(4);
        myDog.navigate(leg1, leg2);
        myDog.displayNavigation();
    }
}