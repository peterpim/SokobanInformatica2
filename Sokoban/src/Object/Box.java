package Object;

import Model.Position;
import View.GameWindow;
import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Peter-Pim
 */
public class Box extends GameObject {
    public Box(Color color, Position position, GameWindow gameWindow) {
        super(color, position, gameWindow);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(position.getPosX(), position.getPosY(),
            gameWindow.getSquareSize(), gameWindow.getSquareSize());
    }
}
