package Model;

import Object.GameObject;
import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

/**
 *
 * @author Peter-Pim
 */
public class Position {
    private GameObject object = null;
    private HashMap<Direction, Position> positionNeighbour;
    
    private int posX;
    private int posY;
    
    public Position(int xCoord, int yCoord) {
        this.posX = xCoord;
        this.posY = yCoord;
        this.positionNeighbour = new HashMap<Direction, Position>();
    }
    
    public void setObject(GameObject object) {
        this.object = object;
    }
    
    public GameObject getObject() {
        return object;
    }
    
    public void setNeighbour(Direction direction, Position position) {
        positionNeighbour.put(direction, position);
    }
    
    public Position getNeighbour(Direction direction) {
        return positionNeighbour.get(direction);
    }
    
    public int getPosX() {
        return posX;
    }
    
    public int getPosY() {
        return posY;
    }
    
    public void draw(Graphics g) {
        if(getObject() != null) {
            getObject().draw(g);
        } else {
            g.setColor(Color.CYAN);
            g.drawRect(getPosX(), getPosY(), 40, 40);
        }
    }
}
