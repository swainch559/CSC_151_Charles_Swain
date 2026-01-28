/*
@author Charles Swain
@date January 28, 2026
@purpose This calls the methods defined in the Mammal class.
 */
package labs.example.mammal;
public class Main {
    public static void main(String[] args) {

        // 1. Creates an instance (Object) of the Mammal class
        Mammal myMammal = new Mammal();

        // 2. Call methods
        System.out.println("--- Methods ---");
        myMammal.run();
        myMammal.eat();
        myMammal.sleep();
        myMammal.scratch();
        myMammal.breathe();
        myMammal.makeSound();
        myMammal.nurseYoung();
        myMammal.groomSelf();
        myMammal.hunt();
    }
}