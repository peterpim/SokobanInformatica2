package Object;

import Model.Position;
import View.GameWindow;
import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Peter-Pim
 */
public abstract class GameObject {
    protected Color color;
    protected Position position;
    protected GameWindow gameWindow;
    
    public GameObject(Color color, Position position) {
        this.color = color;
        this.position = position;
    }
    
    public Color getColor() {
        return color;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public GameWindow getGameWindow() {
        return gameWindow;
    }
    
    public void setGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }
    
    public abstract void draw(Graphics g);
    
    public abstract boolean move();
    
    public boolean checkOutOfField() {
        return false;
    }
    
    public boolean checkWallCollision() {
        return false;
    }
}
