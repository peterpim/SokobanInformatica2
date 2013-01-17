/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.GameRenderer;
import Model.Position;
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
    
    private int sizeWidth = 680;
    private int sizeHeight = 600;
    private int squareSize = 40;
    
    public GameWindow(GameRenderer gameRenderer) {
        try {
            this.gameRenderer = gameRenderer;

            setBackground(Color.BLACK);
            setSize(sizeWidth, sizeHeight);

            addKeyListener(this);
            setFocusable(true);
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
            // Commented code is to be in Position itself. Position should be able to draw itself.
            /*
                    // Positie moet zichzelf tekenen.
                    g.setColor(Color.CYAN);
                    g.drawRect(currentPos.getPosX(), currentPos.getPosY(),
                        squareSize, squareSize);
                    if(gameObject instanceof Player) {
                        gameObject.draw(g);
                        gameObjects.put("player1", gameObject);
                    } else if(gameObject instanceof Monster) {
                        gameObject.draw(g);
                        gameObjects.put("monster1", gameObject);
                    } else if(gameObject instanceof Box) {
                        gameObject.draw(g);
                    } else if(gameObject instanceof Wall) {
                        gameObject.draw(g);
                    }
             */
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
    public void keyTyped(KeyEvent e) { // KeyTyped method is not used.

    }

    @Override
    public void keyPressed(KeyEvent e) { // KeyPressed method is not used.
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    // Commented code is to be in the Player object. The Player object moves itself.
    /*
        try {
            switch(e.getKeyCode()) {
                // Speler zelf laten reageren op de KeyEvent
                case KeyEvent.VK_UP:
                    gameObjects.get("player1").move(Direction.NORTH);
                    break;
                case KeyEvent.VK_LEFT:
                    gameObjects.get("player1").move(Direction.WEST);
                    break;
                case KeyEvent.VK_DOWN:
                    gameObjects.get("player1").move(Direction.SOUTH);
                    break;
                case KeyEvent.VK_RIGHT:
                    gameObjects.get("player1").move(Direction.EAST);
                    break;
                case KeyEvent.VK_F5:
                    gameRenderer.reset();
                    break;
                case KeyEvent.VK_F6:
                    gameRenderer.incrementCurrentLevel();
                    gameRenderer.reset();
                    break;
  
            }
            gameRenderer.incrementPlayerScore();
            repaint();
        } catch(Exception ex) { ex.printStackTrace(); }
    */
    }
}