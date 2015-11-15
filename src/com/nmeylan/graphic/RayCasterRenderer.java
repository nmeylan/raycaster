package com.nmeylan.graphic;

import com.nmeylan.core.RayCaster;
import com.nmeylan.core.game.GameRenderer;

import java.util.Set;

/**
 * Created by Nicolas on 15/11/2015.
 */
public class RayCasterRenderer implements GameRenderer {

    private DrawingComponent drawingComponent;
    private RayCaster rayCaster;

    public RayCasterRenderer(RayCaster rayCaster, DrawingComponent drawingComponent) {
        this.drawingComponent = drawingComponent;
        this.rayCaster = rayCaster;
    }

    @Override
    public void render(double delta) {
        Set<Ray> rays = rayCaster.cast();
        drawingComponent.setRaysToDraw(rays);
        drawingComponent.repaint();

    }
}
