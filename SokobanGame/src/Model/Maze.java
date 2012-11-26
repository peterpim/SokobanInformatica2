/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import View.GameWindow;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Peter-Pim
 */
public class Maze {
    private int TOTAL_BOXES;
    private int LEVEL = 1;
    private String CURRENT_MAP;

    private GameWindow window;
    private Direction direction;
    private Maps maps;
    private Game game;
    private ArrayList<Position> teleports = new ArrayList<Position>();
    private Position position[][] = new Position[15]
            [11];

    public Maze() {
        maps = new Maps();
        maps.setMaze(this);
    }

    public void setGameWindow(GameWindow window) {
        this.window = window;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setBoxes(int value) {
        if(TOTAL_BOXES + value == 0) {
            setLevel(1);
        }
        TOTAL_BOXES += value;
    }

    public int getBoxes() {
        return TOTAL_BOXES;
    }

    public void setLevel(int value) {
        if(value != 0) {
        LEVEL += value;
        } else if(value == 0) {
            LEVEL = 1;
        }
    }

    public void initPositions() {
        for(int i = 0; i < window.getRows(); i++) {
            for(int k = 0; k < window.getCols(); k++) {
                position[i][k] = new Position(i * 50, k * 50);
            }
        }
        for(int r = 0; r < position.length; r++) {
            for(int k = 0; k < position[r].length; k++) {
                setNeighbours(r, k);
            }
        }
    }

    public void setNeighbours(int ROW, int COL) {
        if(!(position[ROW][COL].getY() - 50 < 0)) {
            position[ROW][COL].setInMap(direction.NORTH, position[ROW][COL -1]);
        } else
            position[ROW][COL].setInMap(direction.NORTH, null);
        if(!(position[ROW][COL].getX() - 50 < 0)) {
            position[ROW][COL].setInMap(direction.WEST, position[ROW - 1][COL]);
        } else
            position[ROW][COL].setInMap(direction.WEST, null);
        if(!(position[ROW][COL].getY() + 50 > 500)) {
            position[ROW][COL].setInMap(direction.SOUTH, position[ROW][COL + 1]);
        } else
            position[ROW][COL].setInMap(direction.SOUTH, null);
        if(!(position[ROW][COL].getX() + 50 > 700)) {
            position[ROW][COL].setInMap(direction.EAST, position[ROW + 1][COL]);
        } else
            position[ROW][COL].setInMap(direction.EAST, null);
    }

    public void reset() {
        destroy();
        initPositions();
        initWorld();
        window.repaint();
    }

    public void destroy() {
        for(int i = 0; i < window.getRows(); i++) {
            for(int k = 0; k < window.getCols(); k++) {
                TOTAL_BOXES = 0;
                position[i][k].setObject(null);
                if(position[i][k].getEndField() == true) {
                    position[i][k].setEndField(false);
                    position[i][k].setTeleportDest(null);
                    position[i][k].setTeleport(false);
                }
            }
        }
    }

    public void initWorld() {
        int y = 0;
        int x = 0;

        CURRENT_MAP = maps.getMap(LEVEL);
        Position teleportDest = null;
        Position teleportPos = null;
        Position portalPos = null;

        for(int i = 0; i < CURRENT_MAP.length(); i++) {
            char letter = CURRENT_MAP.charAt(i);

            if(letter == '\n') {
                y += window.getSquareSize();
                x = 0;
            } else if(letter == 'p') {
                Character currentCharacter = new Character(this.getPosition(x / 50, y / 50), Color.BLUE);
                getPosition(x / 50, y / 50).setObject(currentCharacter);
                window.setCharacter(currentCharacter);
                currentCharacter.setGameWindow(window);
                currentCharacter.setMaze(this);
                x += window.getSquareSize();
            } else if (letter == 'b') {
                Box currentBox = new Box(this.getPosition(x / 50, y / 50), new Color(200,100,30));
                getPosition(x / 50, y / 50).setObject(currentBox);
                setBoxes(+1);
                currentBox.setGameWindow(window);
                currentBox.setMaze(this);
                currentBox.setGame(game);
                x += window.getSquareSize();
            } else if (letter == 'e') {
                getPosition(x / 50, y / 50).setEndField(true);
                x += window.getSquareSize();
            } else if (letter == ' ') {
                x += window.getSquareSize();
            } else if (letter == 'w') {
                Wall currentWall = new Wall(getPosition(x / 50, y / 50), Color.DARK_GRAY);
                getPosition(x / 50, y / 50).setObject(currentWall);
                currentWall.setGameWindow(window);
                x += window.getSquareSize();
            } else if (letter == 't') {
                teleportPos = getPosition(x / 50, y / 50);
                teleports.add(teleportPos);
                teleportPos.setTeleport(true);
                if(teleportDest != null) {
                    teleportPos.setTeleportDest(teleportDest);
                }
                x += window.getSquareSize();
            } else if (letter == 'o') {
                portalPos = getPosition(x / 50, y / 50);
                portalPos.setPortal(true);
                x += window.getSquareSize();
            } else if (letter == 'd') {
                teleportDest = getPosition(x / 50, y / 50);
                if(teleportPos != null) {
                    for(int t = 0; t < teleports.size(); t++) {
                        teleports.get(t).setTeleportDest(teleportDest);
                    }
                }
                x += window.getSquareSize();
            }
        }
    }

    public Position getPosition(int ROW, int COL) {
        return position[ROW][COL];
    }
}
