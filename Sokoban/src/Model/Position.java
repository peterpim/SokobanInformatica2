package Model;

import Object.GameObject;
import Object.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

/**
 *
 * @author Peter-Pim
 */
public class Position {
    private GameObject object = null;
    /*
     * HashMap<Direction, Position> positionNeighbour;
     * This Map contains all the position of the position.
     */
    private HashMap<Direction, Position> positionNeighbour = 
            new HashMap<Direction, Position>();
    
    /*
     * Integer posX, posY
     * The x and y position of this position.
     */
    private int posX;
    private int posY;
    
    /*
     * Constructor of the Position.
     * @param xCoord the x coordinate for the position.
     * @param yCoord the y coordinate for the position.
     * 
     */
    public Position(int xCoord, int yCoord) {
        this.posX = xCoord;
        this.posY = yCoord;
    }
    
    /*
     * @param object The new gameobject for this position.
     */
    public void setObject(GameObject object) {
        this.object = object;
    }
    
    /*
     * @return The current object of the position.
     */
    public GameObject getObject() {
        return object;
    }
    
    /*
     * @param direction The direct in which to set the neighbouring position.
     * @param position The position which is to be the neighbour.
     */
    public void setNeighbour(Direction direction, Position position) {
        positionNeighbour.put(direction, position);
    }
    
    /*
     * @param direction The direction from which to retrieve a neighbour.
     * @return The position retrieved from the HashMap with the direction key.
     */
    public Position getNeighbour(Direction direction) {
        return positionNeighbour.get(direction);
    }
    
    /*
     * @return The x coordinate of the position.
     */
    public int getPosX() {
        return posX;
    }
    
    /*
     * @return The y coordinate of the position.
     */
    public int getPosY() {
        return posY;
    }
    
    /*
     * Draw the position's object or the position itself.
     * If there is an object on the position, call the draw method
     * in the object. If the position is empty, draw a square.
     * @param g The graphics component we use.
     */
    public void draw(Graphics g) {
        try {
            if(getObject() != null) {
                getObject().draw(g);
            } else {
                g.setColor(Color.CYAN);
                g.drawRect(getPosX(), getPosY(), 40, 40);
            }
        } catch(Exception e) { e.printStackTrace(); }
    }
}
