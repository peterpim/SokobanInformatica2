
package Model;

import Object.Box;
import Object.Monster;
import Object.Player;
import Object.Wall;
import Object.GameObject;
import View.GameWindow;
import View.MenuWindow;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 * @author Peter-Pim
 */
public class GameRenderer extends JFrame {
    private GameWindow gameWindow;
    private MenuWindow menuWindow;
    private Manager manager;
    private CreateAndReadXML xml;
    
    private final int rows = 17;
    private final int cols = 15;
    private final int sqSize = 40;
    
    Position position[][] = new Position[rows][cols];

    public GameRenderer() {
        try {
            gameWindow = new GameWindow();
            manager = new Manager(this);
            menuWindow = new MenuWindow(manager);
            xml = new CreateAndReadXML();

            setSize(850, 650);
            setLocationRelativeTo(null);
            setTitle("Pacman");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setVisible(true);

            add(gameWindow, BorderLayout.CENTER);
            add(menuWindow, BorderLayout.EAST);
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    public void initPositions() {
        try {
            for(int x = 0; x < rows; x++) {
                for(int y = 0; y < cols; y++) {
                    position[x][y] = new Position(x*sqSize, y*sqSize);
                }
            }
            for(int x = 0; x < rows; x++) {
                for(int y = 0; y < cols; y++) {
                    for(Direction d : Direction.values()) {
                        Position neighbour = null;
                        switch(d) {
                            case NORTH: if(!(y-1<0)) { neighbour = position[x][y - 1]; } break;
                            case WEST: if(!(x-1<0)) { neighbour = position[x - 1][y]; } break;
                            case SOUTH: if(!(y+1>cols-1)) { neighbour = position[x][y + 1]; } break;
                            case EAST: if(!(x+1>rows-1)) { neighbour = position[x + 1][y]; } break;
                            case NONE: break;
                            default: throw new IllegalArgumentException("GameRender initPositions: " +
                                " Could not create neighbour for position at coords " + x + "," + y);
                        }
                        position[x][y].setNeighbour(d, neighbour);
                    }
                }
            }
            gameWindow.setPositions(this.position);
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    public void initWorld() {
        try {
            int x = 0, y = 0, i;
            String map = xml.getMap(manager.getCurrentLevel());
            
            for(i = 0; i < map.length(); i++) {
                char item = map.charAt(i);
                if(item == 'n') {
                    x = 0;
                    y += 1;
                } else if(item == 'w') {
                    Wall wall = new Wall(Color.DARK_GRAY, position[x][y], manager);
                    position[x][y].setObject(wall);
                    x += 1;
                } else if(item == 'b') {
                    Box box = new Box(Color.YELLOW, position[x][y], manager);
                    position[x][y].setObject(box);
                    x += 1;
                } else if(item == 'p') {
                    Player player = new Player(Color.BLUE, position[x][y], manager);
                    position[x][y].setObject(player);
                    x += 1;
                } else if(item == 'm') {
                    Monster monster = new Monster(Color.PINK, position[x][y], manager);
                    position[x][y].setObject(monster);
                    x += 1;
                } else if(item == ' ') {
                    x += 1;
                }
            }
            gameWindow.repaint();
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    private void destroy() {
        try {
            for(int x = 0; x < rows; x++) {
                for(int y = 0; y < cols; y++) {
                    position[x][y].setObject(null);
                }
            }
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    public void reset() {
        try {
            destroy();
            manager.resetPlayerScore();
            initPositions();
            initWorld();
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    public Position getPosition(int row, int col) {
        return position[row][col];
    }
    
    public Position[][] getPositions() {
        return position;
    }
    
    public Manager getManager() {
        return manager;
    }
    
    public GameWindow getGameWindow() {
        return gameWindow;
    }
    
    public MenuWindow getMenuWindow() {
        return menuWindow;
    }
}