package com.nmeylan;

import com.nmeylan.controllers.FrameController;
import com.nmeylan.controllers.InputController;
import com.nmeylan.graphic.DrawingComponent;

import javax.swing.*;

/**
 * Created by Nicolas on 07/11/2015.
 */
public class GameFrame extends JFrame {

    private InputController inputController;
    private FrameController frameController;
    private DrawingComponent drawingPanel;

    public GameFrame(InputController inputController, FrameController frameController, DrawingComponent drawingPanel) {
        super();
        this.inputController = inputController;
        this.frameController = frameController;
        this.drawingPanel = drawingPanel;
        this.setSize(320, 400);
        this.addDrawingPanel();
        this.setTitle("Raycaster");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(inputController);
        this.addWindowListener(frameController);
        this.setVisible(true);
    }

    private void addDrawingPanel() {
        this.drawingPanel.setSize(320, 400);

        this.add(this.drawingPanel);
    }

    public DrawingComponent getDrawingPanel() {
        return drawingPanel;
    }
}
