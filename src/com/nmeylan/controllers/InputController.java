package com.nmeylan.controllers;

import com.nmeylan.enums.KeyCodeEnum;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 07/11/2015.
 */
public class InputController implements KeyListener {

    private List<KeyCodeEnum> keys;

    public InputController(){
        this.keys = new ArrayList<KeyCodeEnum>();
    }

    public void clearKeys(){
        this.keys.clear();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyCodeEnum.LEFT.getValue()) {
            this.keys.add(KeyCodeEnum.LEFT);
        } else if (e.getKeyCode() == KeyCodeEnum.RIGHT.getValue()) {
            this.keys.add(KeyCodeEnum.RIGHT);
        } else if (e.getKeyCode() == KeyCodeEnum.FORWARD.getValue()) {
            this.keys.add(KeyCodeEnum.FORWARD);
        }else if (e.getKeyCode() == KeyCodeEnum.BACKWARD.getValue()) {
            this.keys.add(KeyCodeEnum.BACKWARD);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public List<KeyCodeEnum> getKeys() {
        return keys;
    }
}
