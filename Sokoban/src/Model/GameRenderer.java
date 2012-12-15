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
    Position position[][] = new Position[38][35];
    
    boolean kindMode = false;
    
    int currentLevel = 1;
    int playerScore = 0;
    
    String map = null;
    
    public GameRenderer() { }
    
    public void initWorld() {
        int squares = (gameWindow.getSizeWidth() / gameWindow.getSquareSize()) *
                (gameWindow.getSizeHeight() / gameWindow.getSquareSize());
        int x = 0;
        int y = 0;
        for(int i = 0; i < squares; i++) {
            x += gameWindow.getSquareSize();
            if(x >= 760) { x = 0; y += gameWindow.getSquareSize(); }
        }
    }
    
    public void initPositions() {
        int rows = gameWindow.getSizeWidth() / gameWindow.getSquareSize();
        int cols = gameWindow.getSizeHeight() / gameWindow.getSquareSize();
        
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < cols; y++) {
                position[x][y] = new Position(x * gameWindow.getSquareSize(),
                        y * gameWindow.getSquareSize());
                position[x][y].setNeighbour(Direction.NORTH, position[x][y + 1]);
                position[x][y].setNeighbour(Direction.WEST, position[x - 1][y]);
                position[x][y].setNeighbour(Direction.SOUTH, position[x][y - 1]);
                position[x][y].setNeighbour(Direction.EAST, position[x + 1][y]);
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
