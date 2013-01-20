/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import Model.Position;
import View.GameWindow;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Peter-Pim
 */
public class Player extends GameObject {
    /*
     * Constructor of Player.
     * Pressume the color, position and gameWindow from it's superclass.
     */
    public Player(Color color, Position position, GameWindow gameWindow) {
        super(color, position, gameWindow);
    }
    
    /*
     * Draw the object into the gameWindow.
     * @param g The graphics component we use.
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(position.getPosX(), position.getPosY(),
            gameWindow.getSquareSize(), gameWindow.getSquareSize());
    }
}
