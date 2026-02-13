/*
@author Charles Swain
@date February 12, 2026
@purpose This defines the main class.
 */

// Directory path
package labs.example.physics;

// Import the Physics class
public class Main {
    public static void main(String[] args) {

        //Instantiate the Physics class
        Physics calc = new Physics();

        //Perform some physics calculations and print results
        System.out.println("--- Physics Calculations ---");
        System.out.println("Distance: " + calc.getDistance(60, 2) + " miles");
        System.out.println("Velocity: " + calc.getVelocity(120, 2) + " mph");
        System.out.println("Momentum: " + calc.getMomentum(10, 5) + " kg m/s");
        System.out.println("Force: " + calc.getForce(10, 9.8) + " kg m/s^2");
        System.out.println("Work: " + calc.getWork(50, 10) + " Joules");
        System.out.println("Kinetic Energy: " + calc.getKineticEnergy(15, 4) + " Joules");
        System.out.printf("Potential Energy: %.2f Joules%n", calc.getPotentialEnergy(10, 5));
    }
}