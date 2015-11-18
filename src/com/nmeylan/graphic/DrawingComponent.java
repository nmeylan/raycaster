package com.nmeylan.graphic;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nicolas on 15/11/2015.
 */
public class DrawingComponent extends JPanel {

    private Set<Ray> raysToDraw;

    public DrawingComponent() {
        super();
        raysToDraw = new HashSet<Ray>();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int i = 0;
        for(Ray ray: raysToDraw){
            g.setColor(Color.RED);
            g.drawLine((int)Math.floor(ray.getOrigin().getX()), (int)Math.floor(ray.getOrigin().getY()), i, (int)Math.floor(ray.getOrigin().getY()) + (int) Math.floor(ray.getHeight()));
            i++;
        }
    }

    public void setRaysToDraw(Set<Ray> raysToDraw) {
        this.raysToDraw = raysToDraw;
    }

    public Set<Ray> getRaysToDraw() {
        return raysToDraw;
    }
}
