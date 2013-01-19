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
    private ArrayList<Player> players = new ArrayList<>();
    
    private int sizeWidth = 680;
    private int sizeHeight = 600;
    private int squareSize = 40;
    
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
    
    public GameRenderer getGameRenderer() {
        return gameRenderer;
    }
    
    public void setGameRenderer(GameRenderer gameRenderer) {
        this.gameRenderer = gameRenderer;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        try {
            super.paintComponent(g);
            draw(g);
        } catch(Exception e) { e.printStackTrace(); }
    }
    
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
    
    public void setSizeWidth(int sizeWidth) {
        this.sizeWidth = sizeWidth;
    }

    public int getSizeWidth() {
        return sizeWidth;
    }
    
    public void setSizeHeight(int sizeHeight) {
        this.sizeHeight = sizeHeight;
    }

    public int getSizeHeight() {
        return sizeHeight;
    }
    
    public void setSquareSize(int squareSize) {
        this.squareSize = squareSize;
    }
    
    public int getSquareSize() {
        return squareSize;
    }
    
    public void addPlayer(Player player) {
        players.add(player);
    }
    
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