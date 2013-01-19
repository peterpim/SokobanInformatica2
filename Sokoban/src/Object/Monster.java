package Object;

import Model.Position;
import Model.TimerClass;
import View.GameWindow;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Timer;

/**
 * @author Peter-Pim
 */
public class Monster extends GameObject {
    public Monster(Color color, Position position, GameWindow gameWindow) {
        super(color, position, gameWindow);
        Timer timer = new Timer(1000, new TimerClass(this, gameWindow));
        timer.start();
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(position.getPosX(), position.getPosY(),
            gameWindow.getSquareSize(), gameWindow.getSquareSize());
    }
}