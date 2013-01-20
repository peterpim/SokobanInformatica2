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
    
    /*
     * Integer rows, cols, currentLevel, playerScore
     * rows The amount of Positions in the width.
     * cols The amount of Positions in the height.
     * currentLevel The level that is being played.
     * playerScore The amount of steps that the player took.
     */
    int rows = 17;
    int cols = 15;
    int currentLevel = 0;
    int playerScore = 0;
    
    /*
     * position[][] The array in which all positions are placed.
     */
    Position position[][] = new Position[rows][cols];
    
    /*
     * initWorld Initialize the game world.
     * First retrieve the string that belangs to the currentLevel.
     * For each character of the String create an object or not
     * dependable on the character.
     * After an object has been initialized or if there's not character
     * for the current String element, skip a position in the width.
     * When the maximum width has been reached, skip a position in the height
     * and set the width(x) on 0.
     */
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
    
    /*
     * initPositions Create a position for each column.
     * After the positions are created, initialize their neighbours.
     */
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
    
    /*
     * reset Call methods that reset the game world that belongs the the current level.
     * Then call the repaint method in game window.
     */
    public void reset() {
        try {
            destroy();
            resetPlayerScore();
            initPositions();
            initWorld();
            gameWindow.repaint();
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    /*
     * destroy Set the object of every position to null.
     */
    public void destroy() {
        try {
            for(int i = 0; i < gameWindow.getSizeWidth() / gameWindow.getSquareSize(); i++) {
                for(int k = 0; k < gameWindow.getSizeHeight() / gameWindow.getSquareSize(); k++) {
                    position[i][k].setObject(null);
                }
            }
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    /*
     * @param gameWindow The gameWindow to be set in this object.
     */
    public void setGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }
    
    /*
     * @return The gameWindow of this object.
     */
    public GameWindow getGameWindow() {
        return gameWindow;
    }

    /*
     * @return The current playerScore.
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /*
     * incrementPlayerScore Increase the playerScore by 1.
     */
    public void incrementPlayerScore() {
        this.playerScore += 1;
    }

    /*
     * @return currentLevel Return the level we are in.
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /*
     * incrementCurrentLevel Increase the currentLevel by 1.
     */
    public void incrementCurrentLevel() {
        this.currentLevel += 1;
    }
    
    /*
     * resetCurrentLevel Set the currentLevel to 0.
     */
    public void resetCurrentLevel() {
        this.currentLevel = 0;
    }

    /*
     * @return childMode Return a boolean false or true dependable on wether
     * ChildMode is enabled or not.
     */
    public boolean isChildMode() {
        return childMode;
    }

    /*
     * setChildMode If childMode is currently false, set it to true, vice versa.
     */
    public void setChildMode() {
        try {
            if(childMode == false) {
                this.childMode = true;
            } else
                childMode = false;
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    /*
     * resetPlayerScore Set the playerScore to 0.
     */
    public void resetPlayerScore() {
        playerScore = 0;
    }
    
    /*
     * @param row The index for the first array of the position.
     * @param col The index for the second array of the position.
     * @return A position retrieved with the two indexes, from the position array.
     */
    public Position getPosition(int row, int col) {
        return position[row][col];
    }
    
    /*
     * @param value The value to set the amount of columns.
     */
    public void setCols(int value) {
        this.cols = value;
    }
    
    /*
     * @return cols Return the amount of columns.
     */
    public int getCols() {
        return cols;
    }
    
    /*
     * @param value The value to set the amount of Rows.
     */
    public void setRows(int value) {
        this.rows = value;
    }
    
    /*
     * @return rows Return the amount of rows.
     */
    public int getRows() {
        return rows;
    }
}