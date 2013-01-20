/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Direction;
import Model.GameRenderer;
import Model.Position;
import Object.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * @author Peter-Pim
 */
public class GameWindow extends javax.swing.JPanel implements KeyListener {
    private GameRenderer gameRenderer;
    /*
     * ArrayList<Player> players
     * A List for each Player object that is in the game. 
     * If the game is to be expanded, it could be used for
     * multiplayer purposes.
     */
    private ArrayList<Player> players = new ArrayList<>();
    
    /*
     * Integer sizeWidth, sizeHeight, squareSize
     * Define the width and height of the panel that the playfield will be in.
     * Define the size(width and height) for each field, that the game objects
     * will be drawn in.
     */
    private int sizeWidth = 680;
    private int sizeHeight = 600;
    private int squareSize = 40;
    
    /*
     * Constructor of GameWindow
     * Initialize the GameWindow panel.
     * Set the focus here in this panel, as the KeyListener is in this panel,
     * which is required to move the Player object.
     */
    public GameWindow(GameRenderer gameRenderer) {
        try {
            this.gameRenderer = gameRenderer;

            setBackground(Color.BLACK);
            setSize(sizeWidth, sizeHeight);
            
            setFocusable(true);
            addKeyListener(this);
            requestFocus();
            
            initComponents();
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    /*
     * @return gameRender object of GameRenderer that is initialized in this class.
     */
    public GameRenderer getGameRenderer() {
        return gameRenderer;
    }
    
    /*
     * @param gameRenderer The gameRenderer to be set in this object.
     */
    public void setGameRenderer(GameRenderer gameRenderer) {
        this.gameRenderer = gameRenderer;
    }
    
    /*
     * The paintComponent used for drawing in the gameWindow.
     * @param g The graphics component we use.
     */
    @Override
    public void paintComponent(Graphics g) {
        try {
            super.paintComponent(g);
            draw(g);
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    /*
     * The drawing of the 'game world', the fields and objects are drawn with this
     * method.
     * @param g The graphics component we use.
     */
    private void draw(Graphics g) {
        try {
            int x, y, rows, cols;
            rows = gameRenderer.getRows();
            cols = gameRenderer.getCols();
            for(x = 0; x < rows; x++) {
                for(y = 0; y < cols; y++) {
                    Position currentPos = gameRenderer.getPosition(x, y);
                    currentPos.draw(g);
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
    
    /*
     * @param sizeWidth The width in pixels we want to give our gameWindow.
     */
    public void setSizeWidth(int sizeWidth) {
        this.sizeWidth = sizeWidth;
    }

    /*
     * @return sizeWidth Returns the current width of the gameWindow.
     */
    public int getSizeWidth() {
        return sizeWidth;
    }
    
    /*
     * @param sizeHeight The height in pixels we want to give our gameWindow.
     */
    public void setSizeHeight(int sizeHeight) {
        this.sizeHeight = sizeHeight;
    }

    /*
     * @return sizeHeight Returns the current height of the gameWindow.
     */
    public int getSizeHeight() {
        return sizeHeight;
    }
    
    /*
     * @param squareSize The size of the square(width&height) 
     * we want to give our gameWindow.
     */
    public void setSquareSize(int squareSize) {
        this.squareSize = squareSize;
    }
    
    /*
     * @return Returns the current square size of gameWindow.
     */
    public int getSquareSize() {
        return squareSize;
    }
    
    /*
     * @param player Add a player to our list of Player objects in gameWindow.
     */
    public void addPlayer(Player player) {
        players.add(player);
    }
    
    /*
     * @param value The index of the ArrayList we want the object of.
     * @return The Player object retrieved from the ArrayList.
     */
    public Player getPlayer(int value){
        return players.get(value);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) { /* KeyPressed method is not used. */ }

    @Override
    public void keyPressed(KeyEvent e) { /* KeyPressed method is not used. */ }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    players.get(0).move(Direction.NORTH);
                    break;
                case KeyEvent.VK_LEFT:
                    players.get(0).move(Direction.WEST);
                    break;
                case KeyEvent.VK_DOWN:
                    players.get(0).move(Direction.SOUTH);
                    break;
                case KeyEvent.VK_RIGHT:
                    players.get(0).move(Direction.EAST);
                    break;
                case KeyEvent.VK_F5:
                    players.clear();
                    gameRenderer.reset();
                    break;
                case KeyEvent.VK_F6:
                    gameRenderer.incrementCurrentLevel();
                    players.clear();
                    gameRenderer.reset();
                    break;
  
            }
            gameRenderer.incrementPlayerScore();
            repaint();
        } catch(Exception ex) { ex.printStackTrace(); }
    }
}