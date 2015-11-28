package com.nmeylan.util;

/**
 * Created by Nicolas on 18/11/2015.
 */
public class MathUtil {
    /**
     * This method set angle into bound (0-360)
     *
     * @param angle: an angle in degree.
     * @return the angle in 2kPI
     */
    public static double boundAngle(double angle) {
        if (angle < 0)
            angle += 360;
        else if (angle >= 360)
            angle -= 360;
        return angle;
    }
}
