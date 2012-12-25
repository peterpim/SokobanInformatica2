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
public class Sokoban extends JFrame {

    private static Sokoban sokoban;
    
    private GameRenderer gameRenderer = null;
    private GameWindow gameWindow = null;
    private MenuWindow menuWindow = null;
    
    private int sizeWidth = 850;
    private int sizeHeight = 630;
    
    public static void main(String[] args) {
        sokoban = new Sokoban();
    }
    
    public Sokoban() {
        setSize(sizeWidth, sizeHeight);
        setLocationRelativeTo(null);
        setTitle("Sokoban");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        
        gameRenderer = new GameRenderer();
        
        buildWindows();
    }
    
    public void buildWindows() {
        gameWindow = new GameWindow(gameRenderer);
        menuWindow = new MenuWindow(gameRenderer);
        
        gameRenderer.setGameWindow(gameWindow);
        gameRenderer.initPositions();
        gameRenderer.initWorld();
        
        add(gameWindow, BorderLayout.CENTER);
        add(menuWindow, BorderLayout.EAST);
    }
    
    public void setSizeWidth(int value) {
        this.sizeWidth = value;
    }
    
    public int getSizeWidth() {
        return sizeWidth;
    }
    
    public void setSizeHeight(int value) {
        this.sizeHeight = value;
    }
    
    public int getSizeHeight() {
        return sizeHeight;
    }
    
    public void setGameRenderer(GameRenderer gameRenderer) {
        this.gameRenderer = gameRenderer;
    }
    
    public GameRenderer getGameRenderer() {
        return gameRenderer;
    }
}