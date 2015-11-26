package com.nmeylan.core;

import com.nmeylan.enums.KeyCodeEnum;
import com.nmeylan.util.Location;

import java.util.List;

/**
 * Created by Nicolas on 08/11/2015.
 */
public class Player {
    private static final double ROTATION_RATIO = 2;
    private static final double SPEED_RATIO = 2;
    private Location location;
    private double angle;
    private FieldOfView fieldOfView;

    public Player(Location location, double angle, FieldOfView fieldOfView) {
        this.location = location;
        this.angle = angle;
        this.fieldOfView = fieldOfView;
    }

    public void move(List<KeyCodeEnum> keys, double delta) {
        for (KeyCodeEnum key : keys) {
            printLocation();
            switch (key) {
                case LEFT:
                    moveLeft();
                    break;
                case RIGHT:
                    moveRight();
                    break;
                case FORWARD:
                    moveForward();
                    break;
                case BACKWARD:
                    moveBackward();
                    break;
                default:
                    break;
            }
        }
    }

    private void moveLeft() {
        this.angle += 1 * ROTATION_RATIO;
        if (Math.abs(this.angle) == 360)
            this.angle = 0;
    }

    private void moveRight() {
        this.angle -= 1 * ROTATION_RATIO;
        if (Math.abs(this.angle) == 0)
            this.angle = 360;
    }

    private void moveForward() {
        double newX = this.getX() + Math.cos(Math.toRadians(this.angle)) * ((this.isPlayerFacingLeft() ? -1 : 1) * SPEED_RATIO);
        double newY = this.getY() + Math.sin(Math.toRadians(this.angle)) * ((this.isPlayerFacingUp() ? -1 : 1) * SPEED_RATIO);
        this.setX(newX);
        this.setY(newY);
    }

    private void moveBackward() {
        double newX = this.getX() + Math.cos(Math.toRadians(this.angle)) * ((this.isPlayerFacingLeft() ? 1 : -1) * SPEED_RATIO);
        double newY = this.getY() + Math.sin(Math.toRadians(this.angle)) * ((this.isPlayerFacingUp() ? 1 : -1) * SPEED_RATIO);
        this.setX(newX);
        this.setY(newY);
    }

    public void printLocation() {
        System.out.println(String.format("x: " + getX() + ", y: " + getY() + " angle:" + getAngle()));
    }

    public double getX() {
        return getLocation().getX();
    }

    public double getY() {
        return getLocation().getY();
    }

    public void setX(double x) {
        this.getLocation().setX(x);
    }

    public void setY(double y) {
        this.getLocation().setY(y);
    }

    public double getAngle() {
        return angle;
    }

    private boolean isPlayerFacingUp() {
        return angle <= 180;
    }

    private boolean isPlayerFacingLeft() {
        return angle > 90 && angle < 270;
    }

    public Location getLocation() {
        return location;
    }

    public FieldOfView getFieldOfView() {
        return fieldOfView;
    }
}
