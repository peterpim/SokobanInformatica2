package Object;

import Model.Direction;
import Model.Manager;
import Model.Position;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * @author Peter-Pim
 */
public abstract class GameObject extends JPanel {
    protected Color color;
    protected Position position;
    protected Manager manager;
    
    public GameObject(Color color, Position position, Manager manager) {
        this.color = color;
        this.position = position;
        this.manager = manager;
    }
    
    public void setPosition(Position position) {
        this.position = position;
    }
    
    public Position getPosition() {
        return position;
    }
    
    public abstract void draw(Graphics g);
    
    public boolean move(Direction d) {
        try {
            Position neighbourPos = this.position.getNeighbour(d);
            if(neighbourPos.getObject() == null) {
                swapPositions(this, d);
            }
        } catch(Exception e) { e.printStackTrace(); }
        return true;
    }
    
    public void swapPositions(GameObject object, Direction direction) {
        try {
            Position oldPos = object.getPosition();
            object.setPosition(object.getPosition().getNeighbour(direction));
            object.getPosition().setObject(object);
            oldPos.setObject(null);
            manager.paint();
        } catch(Exception e) { e.printStackTrace(); }
    }
}