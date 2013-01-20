/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.GameWindow;
import View.MenuWindow;
import java.awt.BorderLayout;
import javax.swing.JFrame;
/**
 *
 * @author Peter-Pim
 */
public class Pacman extends JFrame {
    private static Pacman sokoban; // sokoban is static as it belangs to the Class, 
                                   //   not he object instance.
    
    private GameRenderer gameRenderer = null;
    private GameWindow gameWindow = null;
    private MenuWindow menuWindow = null;
    
    /*
     * Integer sizeWidth, sizeHeight
     * The size in width and height for this Frame.
     */
    private int sizeWidth = 850;
    private int sizeHeight = 630;
    
    /*
     * The main method, create the main object.
     */
    public static void main(String[] args) {
        sokoban = new Pacman();
    }
    
    /*
     * Constructor for the main Class.
     * Initialize the main window in which the panels are created.
     * Create a new renderer for the game.
     * Call the method buildWindows to create the gamewindow and the
     * menuwindow. Set this Frame to visible so that it can be seen
     * together with it's two panels.
     */
    public Pacman() {
        try {
            setSize(sizeWidth, sizeHeight);
            setLocationRelativeTo(null);
            setTitle("Sokoban");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);

            gameRenderer = new GameRenderer();

            buildWindows();

            setVisible(true);
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    /*
     * buildWindows method
     * Initialize the positions and world in the gameRenderer.
     * Build the gamewindow and menuwindow panels.
     */
    public void buildWindows() {
        try {
            gameWindow = new GameWindow(gameRenderer);
            menuWindow = new MenuWindow(gameRenderer);

            gameRenderer.setGameWindow(gameWindow);
            gameRenderer.initPositions();
            gameRenderer.initWorld();

            add(gameWindow, BorderLayout.CENTER);
            add(menuWindow, BorderLayout.EAST);
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    /*
     * @param value The value for the width of the Frame to be set.
     */
    public void setSizeWidth(int value) {
        this.sizeWidth = value;
    }
    
    /*
     * @return the width of the Frame.
     */
    public int getSizeWidth() {
        return sizeWidth;
    }
    
    /*
     * @param value The value for the height of the Frame to be set.
     */
    public void setSizeHeight(int value) {
        this.sizeHeight = value;
    }
    
    /*
     * @return the height of the Frame.
     */
    public int getSizeHeight() {
        return sizeHeight;
    }
    
    /*
     * @param gameRenderer The gamerenderer to be set in this class.
     */
    public void setGameRenderer(GameRenderer gameRenderer) {
        this.gameRenderer = gameRenderer;
    }
    
    /*
     * @return Returns the gamerenderer object.
     */
    public GameRenderer getGameRenderer() {
        return gameRenderer;
    }
}