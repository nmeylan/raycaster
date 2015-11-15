package com.nmeylan.graphic;

import com.nmeylan.util.Location;

/**
 * Created by Nicolas on 15/11/2015.
 */
public class Ray {
    private Location origin;
    private double height;

    public Ray(Location origin, double height) {
        this.origin = origin;
        this.height = height;
    }

    public Location getOrigin() {
        return origin;
    }

    public double getHeight() {
        return height;
    }
}
