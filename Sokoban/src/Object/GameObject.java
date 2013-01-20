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
    
    /*
     * Constructor of GameObject.
     * @param color The color the gameobject must assume.
     * @param position The position the gameobject must assume.
     * @param gameWindow Use this to set the gameWindow of the object.
     */
    public GameObject(Color color, Position position, GameWindow gameWindow) {
        this.color = color;
        this.position = position;
        this.gameWindow = gameWindow;
    }
    
    /*
     * @param color The new color for the gameobject.
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
    /*
     * @return color The current color of the gameobject.
     */
    public Color getColor() {
      return color;
    }
    
    /*
     * @param position The new position for the gameobject.
     */
    public void setPosition(Position position) {
        this.position = position;
    }
    
    /*
     * return position Returns the position of the gameobject.
     */
    public Position getPosition() {
        return position;
    }
    
    /*
     * Draw the object into the gameWindow.
     * @param g The graphics component we use.
     * This class is abstract and overridden in the subclasses.
     */
    public abstract void draw(Graphics g);
    
    /*
     * The move method, moves an object in the game.
     * @param direction The direction the gameobject is supposed to move in.
     * First create a neighbourPosition in the direction.
     * If the object is an instance of Player, then see if there's a box
     * in the way that can be moved.
     * If the is no collision with another entity or empty space, the object will
     * move.
     * If the object is an instance of box, check of there's a neighbouring object.
     * If the neighbouring object is a box and childmode is enabled, try to move
     * that box.
     * If there's no neighbouring object, move this object(the current box).
     * If the object is not an instance of Box nor Player, so if it collides with
     * another entity or open space. If not, move the object.
     * @return true If the object did move.
     * @return false If the object did not move.
     */
    public boolean move(Direction direction) {
        try {
            Position neighbourPos = this.getPosition().getNeighbour(direction);
            if(this instanceof Player) {
                if(neighbourPos.getObject() instanceof Box) {
                    GameObject box = (Box) neighbourPos.getObject();
                    if(box.move(direction)) {
                        swapPositions(this, direction);
                        return true;
                    }
                } else if(checkEntityCollision(direction)) {
                    swapPositions(this, direction);
                    return true;
                }
            } else if(this instanceof Box) {
                GameObject object = neighbourPos.getObject();
                if(object == null) {
                    swapPositions(this, direction);
                    return true;
                } else if(object instanceof Box && gameWindow.getGameRenderer().isChildMode()) {
                    if(object.move(direction)) {
                        swapPositions(this, direction);
                        return true;
                    }
                }
            } else {
                if(checkEntityCollision(direction)) {
                    swapPositions(this, direction);
                    return true;
                }
            }
        } catch(Exception e) { e.printStackTrace(); }
        return false;
    }
    
    /*
     * checkBoxCollision look for a Box object in the specified direction.
     * @param direction The direction to check the collision in.
     * @return true If there is no Box object.
     * @return false If the is a Box object.
     */
    public boolean checkBoxCollision(Direction direction) {
        try {
            if(!(position.getNeighbour(direction).getObject() instanceof Box)) {
                return true;
            }
        } catch(Exception e) { e.printStackTrace(); }
        return false;
    }
    
    /*
     * checkEntityCollision look for an entity or empty space in the specified direction.
     * @param direction The direction to check the collision in.
     * @return true If there is no collision.
     * @return false If there is a collision.
     */
    public boolean checkEntityCollision(Direction direction) {
        try {
            if(position.getNeighbour(direction) == null) { return false; }
            GameObject obj = position.getNeighbour(direction).getObject();
            if(obj == null) { return true; }
            String c = obj.getClass().getSimpleName();
            switch(c) {
                case "Wall": return false;
                case "Box": return false;
                case "Monster": return false;
            }
        } catch(Exception e) { e.printStackTrace(); }
        return true;
    }
    
    /*
     * swapPosiitions Change the position of an object to a new position.
     * @param object The object which's position is to be changed.
     * @param direction The direction of the position where the object is to
     * be placed on.
     * Create a Position oldPos.
     * Set the new position for the object.
     * Set the object on the position.
     * Remove the object from the old position(oldPos).
     * At last call the repaint method from the gamewindow.
     */
    public void swapPositions(GameObject object, Direction direction) {
        try {
            Position oldPos = object.getPosition();
            object.setPosition(object.getPosition().getNeighbour(direction));
            object.getPosition().setObject(object);
            oldPos.setObject(null);
            gameWindow.repaint();
        } catch(Exception e) { e.printStackTrace(); }
    }
}
