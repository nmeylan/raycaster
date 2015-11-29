package com.nmeylan.util;

/**
 * Created by Nicolas on 14/11/2015.
 */
public class Location {
    private double x;
    private double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Location other) {
        return Math.sqrt(
                Math.pow((getX() - other.getX()), 2.0) +
                        Math.pow((getY() - other.getY()), 2.0)
        );
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String toString() {
        return "x: " + getX() + " y: " + getY();
    }

}
