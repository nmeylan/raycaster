package com.nmeylan.graphic;

import com.nmeylan.GameFrame;
import com.nmeylan.controllers.InputController;
import com.nmeylan.core.Player;
import com.nmeylan.core.RayCaster;
import com.nmeylan.core.game.GameLoop;

/**
 * Created by Nicolas on 15/11/2015.
 */
public class RayCasterLoop extends GameLoop {

    private RayCaster rayCaster;
    private DrawingComponent drawingPanel;
    private InputController inputController;
    private Player player;

    public RayCasterLoop(RayCaster rayCaster, DrawingComponent drawingPanel, InputController inputController, Player player) {
        super(new RayCasterUpdater(inputController, player), new RayCasterRenderer(rayCaster, drawingPanel));
        this.rayCaster = rayCaster;
        this.drawingPanel = drawingPanel;
        this.inputController = inputController;
        this.player = player;
    }

}
