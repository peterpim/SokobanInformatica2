/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.GameWindow;

/**
 *
 * @author Peter-Pim
 */
public class GameRenderer {
    GameWindow gameWindow;
    
    boolean kindMode = false;
    
    int rows = 15;
    int cols = 15;
    int currentLevel = 1;
    int playerScore = 0;
    
    Position position[][] = new Position[rows][cols];
    String map = null;
    
    public GameRenderer() {
        initPositions();
        initWorld();
    }
    
    public void initWorld() {
        int squares = rows * cols;
        int x = 0;
        int y = 0;
        for(int i = 0; i < squares; i++) {
            x += 20;
            if(x >= rows * 40) { x = 0; y += 40; }
        }
    }
    
    public void initPositions() {       
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < cols; y++) {
                position[x][y] = new Position(x * 40, y * 40);
                if(y + 1 < cols) {
                    position[x][y].setNeighbour(Direction.NORTH, position[x][y + 1]);
                }
                if(x - 1 >= 0) {
                    position[x][y].setNeighbour(Direction.WEST, position[x - 1][y]);
                }
                if(y - 1 >= 0) {
                    position[x][y].setNeighbour(Direction.SOUTH, position[x][y - 1]);
                }
                if(x + 1 < rows) {
                    position[x][y].setNeighbour(Direction.EAST, position[x + 1][y]);
                }
            }
        }
    }
    
    public void reset() {
        destroy();
        initPositions();
        initWorld();
        gameWindow.repaint();
    }
    
    public void destroy() {
        for(int i = 0; i < gameWindow.getSizeWidth() / gameWindow.getSquareSize(); i++) {
            for(int k = 0; k < gameWindow.getSizeHeight() / gameWindow.getSquareSize(); k++) {
                position[i][k].setObject(null);
            }
        }
    }
    
    public void setGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }
    
    public GameWindow getGameWindow() {
        return gameWindow;
    }
    
    public Position getPosition(int row, int col) {
        return position[row][col];
    }
}
