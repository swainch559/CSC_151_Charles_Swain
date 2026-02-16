/*
@author Charles Swain
@date February 16, 2026
@purpose This defines a physics class.
 */

// Directory path
package labs.example.physics;

// Physics class with various physics calculations methods
public class Physics {
    
    // ================================ Constants ================================ 
    final static double GRAVITY = 9.81;
    private final double SPEED_OF_LIGHT_SECONDS = 186282.0;
    private final double KNOWN_DISTANCE_MILES = 92947266.72;

    // ================================  Methods using formulas on chart ================================ 
    //Distance: x = v * t
    public double getDistance(double v, double t) {
        return v * t;
    }

    //Velocity: v = x / t
    public double getVelocity(double x, double t) {
        return x / t;
    }

    //Momentum: p = m * v
    public double getMomentum(double m, double v) {
        return m * v;
    }

    //Force: f = m * a
    public double getForce(double m, double a) {
        return m * a;
    }

    //Work: w = f * d
    public double getWork(double f, double d) {
        return f * d;
    }

    //Kinetic Energy: ke = 1/2 * m * v^2
    public double getKineticEnergy(double m, double v) {
        return 0.5 * m * Math.pow(v, 2);
    }

    //Potential Energy: pe = m * g * h
    public double getPotentialEnergy(double m, double h) {
        return m * GRAVITY * h;
    }

    // ================================ Angle calculations ================================ 
    //Calculates the angle 
    public double calculateAngleDegrees(double sideA, double sideB) {
        double radians = Math.atan2(sideA, sideB); 
        return Math.toDegrees(radians);
    }

    //Log invalid angle info
    public void logInvalidAngleInfo(double angle) {
        System.out.println("Logging the angle " + angle + " degrees. This is not a right angle.");
    }

    //Log valid 3-4-5 info
    public void logValidAngleInfo(double angle) {
        System.out.println("Logging the angle " + angle + " degrees. This is a valid 3-4-5 triangle");
    }

    // ================================  Sun to Earth calculations ================================ 
    // Method to calculate the speed of light in miles per hour
    public double getLightSpeedInMPH() {
        return SPEED_OF_LIGHT_SECONDS * 3600;
    }

    // Method to calculate the time it takes for light to travel from the Sun to the Earth in hours
    public double getTimeFromSunToEarthInHours() {
        return getKnownDistanceFromSunToEarth() / getLightSpeedInMPH();
    }

    // Method to calculate the distance Sun to the Earth in miles
    public double getKnownDistanceFromSunToEarth() {
        return KNOWN_DISTANCE_MILES;
    }

    // Method to log invalid distance information
    public void logEarthToSunInvalidDistance() {
        System.out.println("The calculated distance is invalid.");
    }
}