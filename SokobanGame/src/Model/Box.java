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
public class Box extends GameObject {
    public Box(Position position, Color color) {
        super(position, color);
    }

    @Override
    public void draw(Graphics g, Color color) {
        if(position.getEndField() == true) {
            g.setColor(Color.GREEN);
            g.fillRoundRect(this.position.getX(), this.position.getY(), window.getSquareSize(),
                    window.getSquareSize(), 10, 10);
        } else
        g.setColor(color);
        g.fillRoundRect(this.position.getX(), this.position.getY(), window.getSquareSize(),
                    window.getSquareSize(), 10, 10);
        g.setColor(new Color(224, 128, 32));
            g.drawRoundRect(this.position.getX(), this.position.getY(), window.getSquareSize(),
                    window.getSquareSize(), 10, 10);
    }

    @Override
    public boolean move(Direction direction) {
        if(position.getFromMap(direction).getObject() instanceof Box) {
            if(game.getChildMode() == true) {
                Box currentBox = (Box) position.getFromMap(direction).getObject();
                if(currentBox.getPosition().getFromMap(direction).getObject() == null) {
                    if(currentBox.move(direction)) {
                        return true;
                    }
                }
            }
        } else if(position.getFromMap(direction).getObject() == null) {
            Position oldPos = this.position;
            Position newPos = position.getFromMap(direction);
            if(startMove(direction, newPos)) {
                if(oldPos.getEndField() == true) {maze.setBoxes(+1); }
                if(newPos.getEndField() == true) {maze.setBoxes(-1); }
                    return true;
            }
        }
        return false;
    }
}
