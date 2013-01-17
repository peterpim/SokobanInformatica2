/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import Model.Direction;
import Model.Position;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Peter-Pim
 */
public class Player extends GameObject implements KeyListener {
    public Player(Color color, Position position) {
        super(color, position);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(position.getPosX(), position.getPosY(),
            gameWindow.getSquareSize(), gameWindow.getSquareSize());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Does nothing here.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Does nothing here.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            switch(e.getKeyCode()) {
                // Speler zelf laten reageren op de KeyEvent
                case KeyEvent.VK_UP:
                    move(Direction.NORTH);
                    break;
                case KeyEvent.VK_LEFT:
                    move(Direction.NORTH);
                    break;
                case KeyEvent.VK_DOWN:
                    move(Direction.NORTH);
                    break;
                case KeyEvent.VK_RIGHT:
                    move(Direction.NORTH);
                    break;
                case KeyEvent.VK_F5:
                    move(Direction.NORTH);
                    break;
            /*
                case KeyEvent.VK_F6:
                    gameRenderer.incrementCurrentLevel();
                    gameRenderer.reset();
                    break;
            */
            }
            // gameRenderer.incrementPlayerScore();
            gameWindow.repaint();
        } catch(Exception ex) { ex.printStackTrace(); }
    }
}
