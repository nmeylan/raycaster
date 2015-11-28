package com.nmeylan.graphic;

import com.nmeylan.util.Location;

import java.awt.*;

/**
 * Created by Nicolas on 15/11/2015.
 */
public class Ray {
    private Location origin;
    private double height;
    private Color color;

    public Ray(Location origin, double height, Color color) {
        this.origin = origin;
        this.height = height;
        this.color = color;
    }

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

    public Color getColor() {
        return color;
    }
}
