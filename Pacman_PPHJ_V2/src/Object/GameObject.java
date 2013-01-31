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
        if(!manager.getPaused()) {
            try {
                Position neighbourPos = this.position.getNeighbour(d);
                GameObject obj = neighbourPos.getObject();
                if(obj == null) {
                    swapPositions(this, d);
                } else if(obj instanceof Wall) {
                    return false;
                }
                if(this instanceof Player) {
                    if(obj instanceof Box) {
                        if(obj.move(d)) {
                            swapPositions(this, d);
                        }
                    }
                } else if(this instanceof Box) {
                    if(manager.getChildmode()) {
                        if(obj instanceof Box) {
                            if(obj.move(d)) {
                                swapPositions(this, d);
                            }
                        }
                    }
                }
            } catch(Exception e) { e.printStackTrace(); }
            return true;
        } else {
            return false;
        }
    }
    
    public void swapPositions(GameObject object, Direction direction) {
        try {
            Position oldPos = object.getPosition();
            object.setPosition(object.getPosition().getNeighbour(direction));
            object.getPosition().setObject(object);
            oldPos.setObject(null);
            if(this instanceof Player) {
                manager.incrementPlayerScore();
            }
            manager.paint();
        } catch(Exception e) { e.printStackTrace(); }
    }
}