package com.nmeylan.controllers;

import com.nmeylan.core.game.GameLoop;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by Nicolas on 15/11/2015.
 */
public class FrameController implements WindowListener {

    private GameLoop gameLoop;

    public FrameController(GameLoop gameLoop){
        this.gameLoop = gameLoop;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("close");
        gameLoop.stop();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
