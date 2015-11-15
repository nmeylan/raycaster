package com.nmeylan.enums;

/**
 * Created by Nicolas on 08/11/2015.
 */
public enum MapElementEnum {
    WALL(1),
    VOID(0);

    private int value;

    private MapElementEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
