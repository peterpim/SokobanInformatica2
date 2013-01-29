
package Model;

import Object.GameObject;
import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

/**
 * @author Peter-Pim
 */
public class Position {
    private HashMap<Direction, Position> neighbours;

    private GameObject gameObject;
    
    private int x, y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        neighbours = new HashMap<>();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setObject(GameObject object) {
        this.gameObject = object;
    }
    
    public GameObject getObject() {
        if(gameObject == null) {
            return null;
        }
        return gameObject;
    }
    
    public void setNeighbour(Direction direction, Position position) {
        neighbours.put(direction, position);
    }
    
    public Position getNeighbour(Direction direction) {
        if(neighbours.get(direction) == null) {
            return null;
        }
        return neighbours.get(direction);
    }
    
    public void draw(Graphics g) {
        try {
            if(getObject() == null) {
                g.setColor(Color.BLUE);
                g.drawRect(x, y, 40, 40);
            } else {
                getObject().draw(g);
            }
        } catch(Exception e) { e.printStackTrace(); }
    }
}