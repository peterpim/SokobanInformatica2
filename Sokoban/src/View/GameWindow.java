/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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

/**
 * @author Peter-Pim
 */
public class GameWindow extends javax.swing.JPanel
    implements KeyListener {
    
    private GameRenderer gameRenderer;
    
    private int sizeWidth = 760;
    private int sizeHeight = 610;
    private int squareSize = 20;
    
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
    }
    
    private void draw(Graphics g) {
        for(int x = 0; x < 15; x++) {
            for(int y = 0; y < 15; y++) {
                Position currentPos = gameRenderer.getPosition(x, y);
                GameObject gameObject = currentPos.getObject();
                g.setColor(new Color(100, 100, 200));
                g.drawRect(currentPos.getPosX(), currentPos.getPosY(),
                        currentPos.getPosX() + 40, currentPos.getPosY() + 40);
                if(gameObject instanceof Player) {
                    gameObject.draw(g);
                } else if(gameObject instanceof Monster) {
                    gameObject.draw(g);
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
            .addGap(0, 150, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 115, Short.MAX_VALUE)
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

    }
}
