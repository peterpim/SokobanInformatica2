/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Object.Box;
import Object.Monster;
import Object.Player;
import Object.Wall;
import View.GameWindow;
import java.awt.Color;

/**
 *
 * @author Peter-Pim
 */
public class GameRenderer {
    GameWindow gameWindow;
    CreateAndReadXML xmlReader  = new CreateAndReadXML();
    
    boolean childMode = false;
    
    int rows = 17;
    int cols = 15;
    int currentLevel = 0;
    int playerScore = 0;
    
    Position position[][] = new Position[rows][cols];
    
    public void initWorld() {
        try {
            int x, y;
            x = 0;
            y = 0;
            String map;
            map = xmlReader.getMap(getCurrentLevel());

            for(int i = 0; i < map.length(); i++) {
                char currentItem = map.charAt(i);
                if(currentItem == 'n') {
                    x = 0;
                    y += 1;
                } else if(currentItem == 'w') {
                    Wall wall = new Wall(Color.DARK_GRAY, position[x][y], gameWindow);
                    position[x][y].setObject(wall);
                    x += 1;
                } else if(currentItem == 'b') {
                    Box box = new Box(Color.YELLOW, position[x][y], gameWindow);
                    position[x][y].setObject(box);
                    x += 1;
                } else if(currentItem == 'p') {
                    Player player = new Player(Color.BLUE, position[x][y], gameWindow);
                    gameWindow.addPlayer(player);
                    position[x][y].setObject(player);
                    x += 1;
                } else if(currentItem == 'm') {
                    Monster monster = new Monster(Color.PINK, position[x][y], gameWindow);
                    position[x][y].setObject(monster);
                    x += 1;
                } else if(currentItem == ' ') {
                    x += 1;
                }
            }
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    public void initPositions() {
        try {
            for(int x = 0; x < rows; x++) {
                for(int y = 0; y < cols; y++) {
                    position[x][y] = new Position(x * 40, y * 40);
                }
            }
        } catch(Exception e) { e.printStackTrace(); }
        try {
            for(int x = 0; x < rows; x++) {
                for(int y = 0; y < cols; y++) {
                    if(!(y - 1 < 0)) {
                        position[x][y].setNeighbour(Direction.NORTH, position[x][y - 1]);
                    }
                    if(!(x - 1 < 0)) {
                        position[x][y].setNeighbour(Direction.WEST, position[x - 1][y]);
                    }
                    if(!(y + 1 >= cols)) {
                        position[x][y].setNeighbour(Direction.SOUTH, position[x][y + 1]);
                    }
                    if(!(x + 1 >= rows)) {
                        position[x][y].setNeighbour(Direction.EAST, position[x + 1][y]);
                    }
                }
            }
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    public void reset() {
        try {
            destroy();
            resetPlayerScore();
            initPositions();
            initWorld();
            gameWindow.repaint();
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    public void destroy() {
        try {
            for(int i = 0; i < gameWindow.getSizeWidth() / gameWindow.getSquareSize(); i++) {
                for(int k = 0; k < gameWindow.getSizeHeight() / gameWindow.getSquareSize(); k++) {
                    position[i][k].setObject(null);
                }
            }
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    public void setGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }
    
    public GameWindow getGameWindow() {
        return gameWindow;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void incrementPlayerScore() {
        this.playerScore += 1;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void incrementCurrentLevel() {
        this.currentLevel += 1;
    }
    
    public void resetCurrentLevel() {
        this.currentLevel = 0;
    }

    public boolean isChildMode() {
        return childMode;
    }

    public void setChildMode() {
        try {
            if(childMode == false) {
                this.childMode = true;
            } else
                childMode = false;
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    public void resetPlayerScore() {
        playerScore = 0;
    }
    
    public Position getPosition(int row, int col) {
        return position[row][col];
    }
    
    public void setCols(int value) {
        this.cols = value;
    }
    
    public int getCols() {
        return cols;
    }
    
    public void setRows(int value) {
        this.rows = value;
    }
    
    public int getRows() {
        return rows;
    }
}