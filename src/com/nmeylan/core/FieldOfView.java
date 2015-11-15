package com.nmeylan.core;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Nicolas on 08/11/2015.
 */
public class FieldOfView {

    private double visionAngle;
    private Dimension projectionPlaneDimension;

    public FieldOfView() {
        this.visionAngle = 60;
        this.projectionPlaneDimension = new Dimension(320, 200);
    }

    public FieldOfView(double visionAngle, Dimension projectionPlaneDimension) {
        this.visionAngle = visionAngle;
        this.projectionPlaneDimension = projectionPlaneDimension;
    }

    public Point getCenterOfProjectionPlane() {
        return new Point(getWidth() / 2, getHeight() / 2);
    }

    public double getDistanceFromProjectionPlane() {
        double halfVisionRange = getWidth() / 2;
        double halfVisionAngle = visionAngle / 2;
        return halfVisionRange / Math.tan(Math.toRadians(halfVisionAngle));
    }

    public double getAngleBetweenSubSequentRays() {
        return visionAngle / getWidth();
    }

    public int getWidth() {
        return (int) this.projectionPlaneDimension.getWidth();
    }

    public int getHeight() {
        return (int) this.projectionPlaneDimension.getHeight();
    }

    public double getVisionAngle() {
        return visionAngle;
    }
}
