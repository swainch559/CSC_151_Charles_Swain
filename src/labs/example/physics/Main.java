/*
@author Charles Swain
@date February 16, 2026
@purpose This defines the main class.
 */

// Directory path
package labs.example.physics;

// Import the Physics class
public class Main {
    public static void main(String[] args) {

        //Instantiate the Physics class
        Physics calc = new Physics();

        // Variables for the angle calculations
        double calculatedAngle = calc.calculateAngleDegrees(3, 4);
        double roundedAngle = Math.round(calculatedAngle * 100.0) / 100.0;

        // Variables for the sun to earth calculations
        double velocity = calc.getLightSpeedInMPH();
        double time = calc.getTimeFromSunToEarthInHours();
        double distance = calc.getDistance(velocity, time);
        double KnownDistance = calc.getKnownDistanceFromSunToEarth();

        //Perform some physics calculations and print results
        System.out.println("--- Physics Calculations ---");
        System.out.println("Distance: " + calc.getDistance(60, 2) + " miles");
        System.out.println("Velocity: " + calc.getVelocity(120, 2) + " mph");
        System.out.println("Momentum: " + calc.getMomentum(10, 5) + " kg m/s");
        System.out.println("Force: " + calc.getForce(10, 9.8) + " kg m/s^2");
        System.out.println("Work: " + calc.getWork(50, 10) + " Joules");
        System.out.println("Kinetic Energy: " + calc.getKineticEnergy(15, 4) + " Joules");
        System.out.printf("Potential Energy: %.2f Joules%n", calc.getPotentialEnergy(10, 5));

        // Check if the calculated angle is a right angle, log the appropriate information, and print the results
        System.out.println("--- Angle Calculation ---");
        System.out.printf("Calculated Angle: %.2f degrees%n", calculatedAngle);
        if (roundedAngle > 37 || roundedAngle < 36.87) {
            calc.logInvalidAngleInfo(roundedAngle);
        } else {
            calc.logValidAngleInfo(roundedAngle);
        }

        // Check if the calculated distance from the sun to the earth is valid, log the appropriate information, and print the results
        System.out.println("--- Sun to Earth Calculation ---");
        System.out.printf("Calculated Distance: %.2f miles%n", distance);
        if (distance < KnownDistance) {
            calc.logEarthToSunInvalidDistance();
        } else {
            System.out.printf("Known Distance: %.2f miles is equal to the calculated distance.%n", KnownDistance);
        }
    }
}