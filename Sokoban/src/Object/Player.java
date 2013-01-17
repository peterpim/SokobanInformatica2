/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import Model.Position;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author Peter-Pim
 */
public class Player extends GameObject {
    public Player(Color color, Position position) {
        super(color, position);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(position.getPosX(), position.getPosY(),
            gameWindow.getSquareSize(), gameWindow.getSquareSize());
    }

/*
    @Override
    public void keyTyped(KeyEvent e) {
        // Does nothing here.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Does nothing here.
    }
*/

/*
    @Override
    public void keyReleased(KeyEvent e) {
        try {
            switch(e.getKeyCode()) {
                // Speler zelf laten reageren op de KeyEvent
                case KeyEvent.VK_UP:
                    this.move(Direction.NORTH);
                    break;
                case KeyEvent.VK_LEFT:
                    move(Direction.WEST);
                    break;
                case KeyEvent.VK_DOWN:
                    move(Direction.SOUTH);
                    break;
                case KeyEvent.VK_RIGHT:
                    move(Direction.EAST);
                    break;
            }
            // gameRenderer.incrementPlayerScore();
            gameWindow.repaint();
            System.out.println("Repainted");
        } catch(Exception ex) { ex.printStackTrace(); }
    }
*/
}
