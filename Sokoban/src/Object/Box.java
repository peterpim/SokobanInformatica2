package Object;

import Model.Position;
import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Peter-Pim
 */
public class Box extends GameObject {
    public Box(Color color, Position position) {
        super(color, position);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(position.getPosX(), position.getPosY(),
            gameWindow.getSquareSize(), gameWindow.getSquareSize());
    }
}
