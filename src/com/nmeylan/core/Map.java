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

        if(roundedX < 0){
            roundedX = 1;
        }
        if(roundedY < 0){
            roundedY = 1;
        }
        return mapElement.getValue() == matrix[roundedX / squareSize][roundedY / squareSize];
    }

    public int getSquareSize() {
        return squareSize;
    }
}
