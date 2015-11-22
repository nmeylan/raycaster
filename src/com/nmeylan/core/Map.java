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

    public boolean isCoordinateOutOfBounds(double x, double y){
        int indexX = valueToIndex(x);
        int indexY = valueToIndex(y);
        return isIndexOutOfBounds(indexX, indexY);
    }

    public boolean isIndexOutOfBounds(int indexX, int indexY){
        return indexX < 0 || indexY < 0 || indexY >= matrix.length || indexX >= matrix[0].length;
    }

    private boolean isAMapElementAt(MapElementEnum mapElement, double x, double y){
        int indexX = valueToIndex(x);
        int indexY = valueToIndex(y);
        return mapElement.getValue() == matrix[indexY][indexX];
    }

    private int valueToIndex(double value){
        int roundedValue = (int) Math.floor(value);
        return roundedValue/ squareSize;
    }
    public int getSquareSize() {
        return squareSize;
    }
}
