/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import Model.Position;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Peter-Pim
 */
public class Wall extends GameObject {
    public Wall(Color color, Position position) {
        super(color, position);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(position.getPosX(), position.getPosY(),
            gameWindow.getSquareSize(), gameWindow.getSquareSize());
    }

    @Override
    public boolean move() {
        return false;
    }  
}
