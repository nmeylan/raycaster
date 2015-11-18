package com.nmeylan.core;

import com.nmeylan.enums.MapElementEnum;

/**
 * Created by Nicolas on 08/11/2015.
 */
public class Map {
    private int [][] matrix;
    private int squareSize;

    public Map(int[][] matrix, int squareSize) {
        this.matrix = matrix;
        this.squareSize = squareSize;
    }

    public boolean isAWallAt(double x, double y){
        return isAMapElementAt(MapElementEnum.WALL, x, y);
    }

    private boolean isAMapElementAt(MapElementEnum mapElement, double x, double y){
        int roundedX = (int) Math.floor(x);
        int roundedY =(int) Math.floor(y);
        int indexX = roundedX/ squareSize;
        int indexY = roundedY/ squareSize;

        if(roundedX < 0 || roundedY < 0 || indexX >= matrix.length || indexY >= matrix[0].length){
            return true;
        }
        return mapElement.getValue() == matrix[indexX][indexY];
    }

    public int getSquareSize() {
        return squareSize;
    }
}
