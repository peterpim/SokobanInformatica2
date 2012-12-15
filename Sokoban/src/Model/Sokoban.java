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

    private static Sokoban game;
    
    private GameWindow gameWindow;
    private MenuWindow menuWindow;
    private GameRenderer gameRenderer;
    
    private int sizeWidth = 850;
    private int sizeHeight = 700;
    
    public static void main(String[] args) {
        game = new Sokoban();
    }
    
    public Sokoban() {
        gameRenderer = new GameRenderer();
        gameWindow = new GameWindow();
        menuWindow = new MenuWindow();
        
        gameRenderer.setGameWindow(gameWindow);
        
        setSize(sizeWidth, sizeHeight);
        setLocationRelativeTo(null);
        setTitle("Sokoban");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        buildWindows();
    }
    
    public void buildWindows() {
        gameWindow.setSokoban(game);
        menuWindow.setSokoban(game);
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