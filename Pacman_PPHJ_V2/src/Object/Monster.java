package Object;

import Model.Manager;
import Model.Position;
import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Peter-Pim
 */
public class Monster extends GameObject {
    public Monster(Color color, Position position, Manager manager) {
        super(color, position, manager);
    }

    //@Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(position.getX(), position.getY(), 40, 40);
    }
}