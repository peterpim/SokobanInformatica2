/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import View.ScoreWindow;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Peter-Pim
 */
public class Character extends GameObject {
    public Character(Position position, Color color) {
        super(position, color);
    }

    private ScoreWindow scoreWindow;
    private int STEPS = 0;

    @Override
    public boolean move(Direction direction) {
        Position newPos = position.getFromMap(direction);
        if(startMove(direction, newPos)) {
            setSteps(1);
            return true;
        }
        return false;
    }

    public void setScoreWindow(ScoreWindow scoreWindow) {
        this.scoreWindow = scoreWindow;
    }

    public void setSteps(int value) {
        this.STEPS += value;
        scoreWindow.editSteps(STEPS);
    }

    @Override
    public void draw(Graphics g, Color color) {
        g.setColor(color);
        g.fillOval(this.position.getX(), this.position.getY(),
                window.getSquareSize(), window.getSquareSize());
        g.setColor(new Color(50, 84, 128));
        g.drawOval(this.position.getX(), this.position.getY(),
                window.getSquareSize(), window.getSquareSize());
    }
}
