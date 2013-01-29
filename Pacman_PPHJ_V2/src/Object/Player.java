/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import Model.Manager;
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
    public Player(Color color, Position position, Manager manager) {
        super(color, position, manager);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(position.getX(), position.getY(), 40, 40);
    }

    @Override
    public void keyTyped(KeyEvent e) {    }

    @Override
    public void keyPressed(KeyEvent e) {    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
