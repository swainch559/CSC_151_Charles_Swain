/*
@author Charles Swain
@date February 4, 2026
@purpose This calls the methods defined in the Mammal class.
 */
package labs.example.mammal;
public class Main {
    public static void main(String[] args) {

        // 1. Creates an instance (Object) of the Mammal class
        Mammal myMammal = new Mammal();

        // 2. Call methods
        System.out.println("\n--- Methods ---");
        myMammal.run();
        myMammal.eat();
        myMammal.sleep();
        myMammal.scratch();
        myMammal.breathe();
        myMammal.makeSound();
        myMammal.nurseYoung();
        myMammal.groomSelf();
        myMammal.hunt();
        myMammal.getMammalDetails();
        System.out.println("\nStarts sitting...");
        myMammal.sit();
        int leg1 = myMammal.walk(3);
        int leg2 = myMammal.walk(4);
        myMammal.navigate(leg1, leg2);
        myMammal.displayNavigation();
    }
}