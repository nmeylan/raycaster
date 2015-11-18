package com.nmeylan.core;

import com.nmeylan.graphic.Ray;
import com.nmeylan.util.Location;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Nicolas on 14/11/2015.
 *
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
        double projectionCenterY = (getFieldOfView().getHeight() / 2);
        double angle = (player.getAngle() + getFieldOfView().getVisionAngle() / 2);
        double relativeAngle = getFieldOfView().getVisionAngle() /2;
        double rayHeight;
        while (i < getFieldOfView().getWidth()) {
            rayHeight = castSingleRay(angle, relativeAngle);
            rays.add(new Ray(new Location(i, projectionCenterY - rayHeight/2), rayHeight));
            angle -= getFieldOfView().getAngleBetweenSubSequentRays();
            relativeAngle -= getFieldOfView().getAngleBetweenSubSequentRays();
            i += 1;
        }

        return rays;
    }

    private double castSingleRay(double angle, double relativeAngle) {
        double distortedDistanceToWall = findDistanceToWall(findHorizontalIntersection(angle), findVerticalIntersection(angle));
        double distanceToWall = distortedDistanceToWall * Math.cos(Math.toRadians(relativeAngle));
        return map.getSquareSize() / distanceToWall * getFieldOfView().getDistanceFromProjectionPlane();
    }

    /**
     *  Find distance to Wall.
     */

    private double findDistanceToWall(Location locationA, Location locationB){
        double distanceA = player.getLocation().distanceTo(locationA);
        double distanceB = player.getLocation().distanceTo(locationB);
        return distanceA < distanceB ? distanceA : distanceB;
    }

    /**
     *  Find intersection to wall.
     */


    private Location findHorizontalIntersection(double angle) {
        double intersectionX, intersectionY, ya, xa;
        intersectionY = Math.floor(player.getY() / map.getSquareSize()) * map.getSquareSize();
        intersectionY += isRayFacingUp(angle) ? -1 : map.getSquareSize();
        intersectionX = player.getX() + (player.getY() - intersectionY) / Math.tan(Math.toRadians(angle));

        while (!map.isAWallAt(intersectionX, intersectionY)) {
            ya = isRayFacingUp(angle) ? -map.getSquareSize() : map.getSquareSize();
            xa = map.getSquareSize() / Math.tan(Math.toRadians(angle));

            intersectionX += xa;
            intersectionY += ya;
        }
        return new Location(intersectionX, intersectionY);
    }

    private Location findVerticalIntersection(double angle) {
        double intersectionX, intersectionY, ya, xa;
        intersectionX = Math.floor(player.getX() / map.getSquareSize()) * map.getSquareSize();
        intersectionX += isRayFacingLeft(angle) ? -1 : map.getSquareSize();
        intersectionY = player.getY() + (player.getX() - intersectionX) * Math.tan(Math.toRadians(angle));

        while (!map.isAWallAt(intersectionX, intersectionY)) {
            xa = isRayFacingLeft(angle) ? -map.getSquareSize() : map.getSquareSize();
            ya = map.getSquareSize() / Math.tan(Math.toRadians(angle));

            intersectionX += xa;
            intersectionY += ya;
        }
        return new Location(intersectionX, intersectionY);
    }

    private boolean isRayFacingUp(double angle) {
        return angle <= 180;
    }

    private boolean isRayFacingLeft(double angle) {
        return angle > 90 && angle < 270;
    }


    private FieldOfView getFieldOfView() {
        return player.getFieldOfView();
    }
}
