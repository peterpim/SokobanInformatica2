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
                if(gameWindow.getGameRenderer().isChildMode() && !currentBox.checkBoxCollision(direction)) {
                    if(currentBox.getPosition().getNeighbour(direction).getObject().move(direction)) {
                        this.move(direction);
                    }
                } else if(currentBox.checkEntityCollision(direction)) {
                    swapPositions(currentBox, direction);
                    swapPositions(this, direction);
                }
            }
        } else if(checkEntityCollision(direction)) {
            swapPositions(this, direction);
        }
        gameWindow.repaint();
        return true;
    }
    
    public boolean checkBoxCollision(Direction direction) {
        if(!(position.getNeighbour(direction).getObject() instanceof Box)) {
            return true;
        }
        return false;
    }
    
    public boolean checkEntityCollision(Direction direction) {
        if(position.getNeighbour(direction) == null) { return false; }
        GameObject obj = position.getNeighbour(direction).getObject();
        System.out.println(obj);
        if(obj == null) { return true; }
        String c = obj.getClass().getSimpleName();
        switch(c) {
            case "Wall": return false;
            case "Box": return false;
            case "Monster": return false;
        }
        return true;
    }
    
    public void swapPositions(GameObject object, Direction direction) {
        Position oldPos = object.getPosition();
        object.setPosition(object.getPosition().getNeighbour(direction));
        object.getPosition().setObject(object);
        oldPos.setObject(null);
    }
}
