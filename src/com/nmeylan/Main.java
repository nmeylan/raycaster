package com.nmeylan;

import com.nmeylan.constants.MapConstants;
import com.nmeylan.controllers.FrameController;
import com.nmeylan.controllers.InputController;
import com.nmeylan.core.FieldOfView;
import com.nmeylan.core.Map;
import com.nmeylan.core.Player;
import com.nmeylan.core.RayCaster;
import com.nmeylan.core.game.GameLoop;
import com.nmeylan.graphic.DrawingComponent;
import com.nmeylan.graphic.RayCasterLoop;
import com.nmeylan.util.Location;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Player player = new Player(new Location(400, 400), 90, new FieldOfView());
        Map map = new Map(MapConstants.DEFAULT_MATRIX, 64);
        RayCaster rayCaster = new RayCaster(player, map);
        DrawingComponent drawingPanel = new DrawingComponent();
        InputController inputController = new InputController();
        GameLoop gameLoop = new RayCasterLoop(rayCaster, drawingPanel, inputController, player);
        FrameController frameController = new FrameController(gameLoop);
        GameFrame gameFrame = new GameFrame(inputController, frameController, drawingPanel);

        gameLoop.start();
    }
}
