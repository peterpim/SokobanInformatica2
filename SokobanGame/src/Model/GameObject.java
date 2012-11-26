/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import View.GameWindow;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Peter-Pim
 */
public abstract class GameObject {
    protected Position position;
    protected Direction direction;
    protected GameWindow window;
    protected Color color;
    protected Maze maze;
    protected Game game;

    public GameObject(Position position, Color color) {
        this.position = position;
        this.color = color;
    }

    public abstract void draw(Graphics g, Color color);

    public abstract boolean move(Direction direction);


    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public void setGameWindow(GameWindow window) {
        this.window = window;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Position getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public boolean startMove(Direction direction, Position newPos) {
        if(!checkWallCollision(direction) && !(checkOutOfField(position, direction))) {
            if(newPos.getObject() instanceof Box) {
                Box currentBox = (Box) newPos.getObject();
                if(currentBox.move(direction)) {
                    this.move(direction);
                    return true;
                }
            } else if(newPos.getTeleport() == true) {
                newPos = newPos.getTeleportDest();
                if(newPos.getObject() instanceof Box) {
                    if(findSurroundings(newPos, direction) == direction.NO_DIRECTION) {
                        newPos = newPos.getFromMap(direction);
                        replace(newPos);
                        return true;
                    } else
                        newPos = newPos.getFromMap(findSurroundings(newPos, direction));
                        replace(newPos);
                        return true;
                } else
                    replace(newPos);
                    return true;
            } else if(newPos.getObject() == null) {
                newPos = position.getFromMap(direction);
                replace(newPos);
                return true;
            }
        }
        return false;
    }

    public void replace(Position newPos) {
        position.setObject(null);
        position = newPos;
        position.setObject(this);
    }

    public Direction findSurroundings(Position position, Direction direction) {
        if(checkOutOfField(position, direction) == false) {
            if(position.getFromMap(direction).getObject() == null) {
                return direction;
            } else {
                for(Direction d : Direction.values()) {
                    if(position.getFromMap(d).getObject() == null) {
                        return d;
                    }
                }
            }
        }
        return direction.NO_DIRECTION;
    }

    public boolean checkWallCollision(Direction direction) {
        if(position.getFromMap(direction) != null) {
            if(position.getFromMap(direction).getObject() instanceof Wall) {
                return true;
            }
            else {
            return false;
            }
        } else
            return false;
    }

    public boolean checkOutOfField(Position position, Direction direction) {
        if(position.getFromMap(direction) == null) {
            return true;
        } else
            return false;
    }
}
