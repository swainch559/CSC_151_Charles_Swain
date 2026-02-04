/*
@author Charles Swain
@date February 4, 2026
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
    private double totalDistance;
    private double angleTheta;

    // 2. Constructor
    public Mammal() {
        this.hairColor = "Brown";
        this.eyeColor = "Hazel";
        this.bodyTemp = 98.6;
        this.isHibernating = false;
        this.weight = 45.5;
        this.habitat = "Forest";
    }

    // 3. Methods
    public void getMammalDetails() {
        System.out.println("\n--- Mammal Details ---");
        System.out.println("Hair Color: " + hairColor);
        System.out.println("Eye Color: " + eyeColor);
        System.out.println("Body Temp: " + bodyTemp);
        System.out.println("Habitat: " + habitat);
        System.out.println("Weight: " + weight + "kg");
    }

    public void sit() {
        System.out.println("The mammal is now sitting...");
        try {
            Thread.sleep(15000); 
        } catch (InterruptedException e) {
            System.out.println("The sit was interrupted!");
        }
        stand();
    }

    public void stand() {
        System.out.println("The mammal is no longer sitting. It is now standing and barking: Woof! Woof!");
    }

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

    public int walk(int miles) {
    System.out.println("The mammal walks " + miles + " miles.");
    return miles;
    }

    public void navigate(int sideA, int sideB) {
    this.totalDistance = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
    double radians = Math.atan2(sideA, sideB); 
    this.angleTheta = Math.toDegrees(radians);
    }

    public void displayNavigation() {
    String formattedDistance = String.format("%.2f", totalDistance);
    String formattedAngle = String.format("%.2f", angleTheta);
    System.out.println("\n--- Movement Calculations Results ---");
    System.out.println("Straight-line Distance: " + formattedDistance + " miles");
    System.out.println("Angle at longest leg: " + formattedAngle + " degrees");
    }
}
