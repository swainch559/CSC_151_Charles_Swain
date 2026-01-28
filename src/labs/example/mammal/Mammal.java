/*
@author Charles Swain
@date January 28, 2026
@purpose This defines a Mammal class.
 */
package labs.example.mammal;
public class Mammal {
    
    // 1. Properties (Private)
    private String hairColor;
    private String eyeColor;
    private double bodyTemp;
    private boolean isHibernating;
    private double weight;
    private String habitat;

    // 2.Methods (Public)
    public void run() {
        System.out.println("The mammal is running.");
    }

    public void eat() {
        System.out.println("The mammal is eating.");
    }

    public void sleep() {
        System.out.println("The mammal is sleeping.");
    }

    public void scratch() {
        System.out.println("The mammal is scratching.");
    }
    
    public void breathe() {
        System.out.println("Inhale... exhale...");
    }

    public void makeSound() {
        System.out.println("The mammal makes a sound.");
    }

    public void nurseYoung() {
        System.out.println("Nursing the young.");
    }

    public void groomSelf() {
        System.out.println("Cleaning fur.");
    }

    public void hunt() {
        System.out.println("Searching for food.");
    }
}
