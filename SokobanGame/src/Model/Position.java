/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.HashMap;

/**
 *
 * @author Peter-Pim
 */
public class Position {
    private GameObject object;
    private Position teleportDest;
    private HashMap<Direction, Position> positionNeighbour;

    private int POS_X;
    private int POS_Y;
    private boolean isEndField = false;
    private boolean isTeleport = false;
    private boolean isPortal = false;

    public Position(int XCOORD, int YCOORD) {
        POS_X = XCOORD;
        POS_Y = YCOORD;
        positionNeighbour = new HashMap<Direction, Position>();
    }

    public void setObject(GameObject object) {
        this.object = object;
    }

    public void setEndField(boolean value) {
        this.isEndField = true;
    }

    public void setPortal(boolean value) {
        this.isPortal = true;
    }

    public void setInMap(Direction direction, Position position) {
        positionNeighbour.put(direction, position);
    }

    public Position getFromMap(Direction direction) {
        return positionNeighbour.get(direction);
    }

    public boolean getEndField() {
        return isEndField;
    }

    public boolean getPortal() {
        return isPortal;
    }

    public void setTeleportDest(Position position) {
        this.teleportDest = position;
    }

    public Position getTeleportDest() {
        return teleportDest;
    }

    public void setTeleport(boolean value) {
        this.isTeleport = true;
    }

    public boolean getTeleport() {
        return isTeleport;
    }

    public GameObject getObject() {
            return object;
    }

    public int getX() {
        return POS_X;
    }

    public int getY() {
        return POS_Y;
    }
}
