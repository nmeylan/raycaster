package com.nmeylan.enums;

/**
 * Created by Nicolas on 07/11/2015.
 */
public enum KeyCodeEnum {
    LEFT (81),
    RIGHT (68),
    FORWARD (90),
    BACKWARD (83);

    private int value;

    private KeyCodeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
