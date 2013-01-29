/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Position;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Peter-Pim
 */
public class GameWindow extends javax.swing.JPanel {

    /**
     * Creates new form GameWindow
     */
    public GameWindow() {
        try {
            setBackground(Color.BLACK);
            setSize(680, 600);
            setFocusable(false);

            initComponents();
        } catch(Exception e) { e.printStackTrace(); }
    }

    public void paintComponent(Graphics g, Position[][] position) {
        try {
            super.paintComponent(g);
            draw(g, position);
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    private void draw(Graphics g, Position[][] position) {
        try {
            for(int x = 0; x < 17; x++) {
                for(int y = 0; y < 15; y++) {
                    position[x][y].draw(g);
                }
            }
        } catch(Exception e) { e.printStackTrace(); }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }
    // </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
