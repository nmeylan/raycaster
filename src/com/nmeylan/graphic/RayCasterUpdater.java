package com.nmeylan.graphic;

import com.nmeylan.controllers.InputController;
import com.nmeylan.core.Player;
import com.nmeylan.core.game.GameUpdater;


/**
 * Created by Nicolas on 15/11/2015.
 */
public class RayCasterUpdater implements GameUpdater {
    private InputController inputController;
    private Player player;

    public RayCasterUpdater(InputController inputController, Player player) {
        this.inputController = inputController;
        this.player = player;
    }

    @Override
    public void update(double delta) {
        player.move(inputController.getKeys(), delta);
        inputController.clearKeys();
    }
}
