package com.nmeylan.core;

import com.nmeylan.graphic.Ray;
import com.nmeylan.util.Location;
import com.nmeylan.util.MathUtil;

import java.awt.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Nicolas on 14/11/2015.
 * <p>
 * This class "cast" rays that will be drawn by the RaysDrawer class.
 */
public class RayCaster {
    private Player player;
    private Map map;

    public RayCaster(Player player, Map map) {
        this.player = player;
        this.map = map;
    }

    public Set<Ray> cast() {
        Set<Ray> rays = new LinkedHashSet<Ray>();
        double i = 0;
        double angle = (player.getAngle() + getFieldOfView().getVisionAngle() / 2);
        double relativeAngle = getFieldOfView().getVisionAngle() / 2;
        while (i < getFieldOfView().getWidth()) {
            rays.add(castSingleRay(MathUtil.boundAngle(angle), relativeAngle, i));
            angle -= getFieldOfView().getAngleBetweenSubSequentRays();
            relativeAngle -= getFieldOfView().getAngleBetweenSubSequentRays();
            i += 1;
        }

        return rays;
    }

    private Ray castSingleRay(double angle, double relativeAngle, double rayXCoordinate) {
        Location horizontalIntersection = findHorizontalIntersection(angle);
        Location verticalIntersection = findVerticalIntersection(angle);
        double distortedDistanceToWall;
        double distanceA = player.getLocation().distanceTo(horizontalIntersection);
        double distanceB = player.getLocation().distanceTo(verticalIntersection);
        Color color;
        if (distanceA < distanceB){
            distortedDistanceToWall = distanceA;
            color = Color.gray;
        }
        else{
            distortedDistanceToWall = distanceB;
            color = Color.darkGray;
        }
        double distanceToWall = distortedDistanceToWall * Math.cos(Math.toRadians(relativeAngle));
        double rayHeight = map.getSquareSize() / distanceToWall * getFieldOfView().getDistanceFromProjectionPlane();
        double projectionCenterY = (getFieldOfView().getHeight() / 2);
        return new Ray(new Location(rayXCoordinate, projectionCenterY - rayHeight / 2), rayHeight, color);
    }

    /**
     * Find intersection to wall.
     */


    private Location findHorizontalIntersection(double angle) {
        if (angle == 0 || angle == 180) {
            return new Location(Double.MAX_VALUE, Double.MAX_VALUE);
        }
        double intersectionX, intersectionY, ya, xa;
        intersectionY = Math.floor(player.getY() / map.getSquareSize()) * map.getSquareSize();
        intersectionY += isRayFacingUp(angle) ? -1 : map.getSquareSize();
        intersectionX = player.getX() + (intersectionY - player.getY()) / Math.tan(Math.toRadians(angle));

        ya = isRayFacingUp(angle) ? -map.getSquareSize() : map.getSquareSize();
        xa = map.getSquareSize() / Math.tan(Math.toRadians(angle));
        return findIntersection(intersectionX, intersectionY, ya, xa);
    }

    private Location findVerticalIntersection(double angle) {
        if (angle == 90 || angle == 270) {
            return new Location(Double.MAX_VALUE, Double.MAX_VALUE);
        }
        double intersectionX, intersectionY, ya, xa;
        intersectionX = Math.floor(player.getX() / map.getSquareSize()) * map.getSquareSize();
        intersectionX += isRayFacingLeft(angle) ? -1 : map.getSquareSize();
        intersectionY = player.getY() + (intersectionX - player.getX()) * Math.tan(Math.toRadians(angle));

        xa = isRayFacingLeft(angle) ? -map.getSquareSize() : map.getSquareSize();
        ya = map.getSquareSize() * Math.tan(Math.toRadians(angle));
        return findIntersection(intersectionX, intersectionY, ya, xa);
    }

    private Location findIntersection(double intersectionX, double intersectionY, double ya, double xa) {
        boolean outOfBounds = map.isCoordinateOutOfBounds(intersectionX, intersectionY);
        while (!outOfBounds && !map.isAWallAt(intersectionX, intersectionY)) {
            intersectionX += xa;
            intersectionY += ya;
            outOfBounds = map.isCoordinateOutOfBounds(intersectionX, intersectionY);
        }
        if (outOfBounds) {
            return new Location(Double.MAX_VALUE, Double.MAX_VALUE);
        } else {
            return new Location(intersectionX, intersectionY);
        }
    }

    private boolean isRayFacingUp(double angle) {
        return angle > 0 && angle < 180;
    }

    private boolean isRayFacingLeft(double angle) {
        return angle >= 90 && angle < 270;
    }


    private FieldOfView getFieldOfView() {
        return player.getFieldOfView();
    }
}
