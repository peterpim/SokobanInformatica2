/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Direction;
import Model.GameRenderer;
import Model.Position;
import Object.Box;
import Object.GameObject;
import Object.Monster;
import Object.Player;
import Object.Wall;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * @author Peter-Pim
 */
public class GameWindow extends javax.swing.JPanel
    implements KeyListener {
    
    private GameRenderer gameRenderer;
    private ArrayList<Player> players;
    private ArrayList<Monster> monsters;
    
    private int sizeWidth = 680;
    private int sizeHeight = 600;
    private int squareSize = 40;
    
    public GameWindow(GameRenderer gameRenderer) {
        this.gameRenderer = gameRenderer;
        setBackground(Color.BLACK);
        setSize(sizeWidth, sizeHeight);  
        addKeyListener(this);
        setFocusable(true);
        
        initComponents();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
        repaint();
    }
    
    private void draw(Graphics g) {
        int x, y, rows, cols;
        rows = gameRenderer.getRows();
        cols = gameRenderer.getCols();
        for(x = 0; x < rows; x++) {
            for(y = 0; y < cols; y++) {
                Position currentPos = gameRenderer.getPosition(x, y);
                GameObject gameObject = currentPos.getObject();
                g.setColor(Color.CYAN);
                g.drawRect(currentPos.getPosX(), currentPos.getPosY(),
                    squareSize, squareSize);
                if(gameObject instanceof Player) {
                    gameObject.draw(g);
                    players.add((Player) gameObject);
                } else if(gameObject instanceof Monster) {
                    gameObject.draw(g);
                    monsters.add((Monster) gameObject);
                } else if(gameObject instanceof Box) {
                    gameObject.draw(g);
                } else if(gameObject instanceof Wall) {
                    gameObject.draw(g);
                }
            }
        }
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
    public void keyTyped(KeyEvent e) {
        // This method has no implementation.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // This method has no implementation.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                players.get(1).move(Direction.NORTH);
                break;
            case KeyEvent.VK_LEFT:
                players.get(1).move(Direction.WEST);
                break;
            case KeyEvent.VK_DOWN:
                players.get(1).move(Direction.SOUTH);
                break;
            case KeyEvent.VK_RIGHT:
                players.get(1).move(Direction.EAST);
                break;
            case KeyEvent.VK_F5:
                gameRenderer.reset();
                break;
        }
        repaint();
    }
}
