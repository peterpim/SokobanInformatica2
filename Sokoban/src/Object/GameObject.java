package Object;

import Model.Direction;
import Model.Position;
import View.GameWindow;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * @author Peter-Pim
 */
public abstract class GameObject extends JPanel {
    protected Color color;
    protected Position position;
    protected GameWindow gameWindow;
    
    public GameObject(Color color, Position position, GameWindow gameWindow) {
        this.color = color;
        this.position = position;
        this.gameWindow = gameWindow;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public Color getColor() {
      return color;
    }
    
    public void setPosition(Position position) {
        this.position = position;
    }
    
    public Position getPosition() {
        return position;
    }
    
    public abstract void draw(Graphics g);
    
    public boolean move(Direction direction) {
        if(!(checkBoxCollision(direction))) {
            if(this instanceof Player) {
                GameObject currentBox = (Box) position.getNeighbour(direction).getObject();
                if(currentBox.checkBoxCollision(direction) && currentBox.checkOutOfField(direction) &&
                        currentBox.checkWallCollision(direction)) {
                    swapPositions(currentBox, direction);
                    swapPositions(this, direction);
                }
            } else {
                return false;
            }
        } else if(checkOutOfField(direction) && checkWallCollision(direction)) {
            swapPositions(this, direction);
        } else {
            return false;
        }
        gameWindow.repaint();
        return true;
    }
    
    public boolean checkOutOfField(Direction direction) {
        if(position.getNeighbour(direction) != null) {
            return true;
        }
        return false;
    }
    
    public boolean checkBoxCollision(Direction direction) {
        if(!(position.getNeighbour(direction).getObject() instanceof Box)) {
            return true;
        }
        return false;
    }
    
    public boolean checkWallCollision(Direction direction) {
        if(!(position.getNeighbour(direction).getObject() instanceof Wall)) {
            return true;
        }
        return false;
    }
    
    public void swapPositions(GameObject object, Direction direction) {
        Position oldPos = object.getPosition();
        object.setPosition(object.getPosition().getNeighbour(direction));
        object.getPosition().setObject(object);
        oldPos.setObject(null);
    }
}
