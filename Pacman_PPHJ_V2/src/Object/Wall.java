/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import Model.Manager;
import Model.Position;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Peter-Pim
 */
public class Wall extends GameObject {
    public Wall(Color color, Position position, Manager manager) {
        super(color, position, manager);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(position.getX(), position.getY(), 40, 40);
    }
}
