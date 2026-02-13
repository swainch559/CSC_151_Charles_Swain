/*
@author Charles Swain
@date February 12, 2026
@purpose This defines a physics class.
 */

// Directory path
package labs.example.physics;

// Physics class with various physics calculations methods
public class Physics {
    
    //Constant for Gravity
    final static double GRAVITY = 9.81;

    //Methods using formulas on chart
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
}