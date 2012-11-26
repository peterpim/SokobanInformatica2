/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import View.GameWindow;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Peter-Pim
 */
public class Wall extends GameObject {
    public Wall(Position position, Color color) {
        super(position, color);
    }

    @Override
    public void draw(Graphics g, Color color) {
        g.setColor(color);
        g.fillRect(this.position.getX(), this.position.getY(),
                window.getSquareSize(), window.getSquareSize());
        g.setColor(Color.BLACK);
        g.drawRect(this.position.getX(), this.position.getY(),
                window.getSquareSize(), window.getSquareSize());
    }

    @Override
    public boolean move(Direction direction) { return false; }

}
