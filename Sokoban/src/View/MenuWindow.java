package View;

import Model.GameRenderer;
import java.awt.Color;

/**
 * @author Peter-Pim
 */
public class MenuWindow extends javax.swing.JPanel {
    private GameRenderer gameRenderer;
    
    int sizeWidth = 90;
    int sizeHeight = 610;
    int score = 0;
    
    public MenuWindow(GameRenderer gameRenderer) {
        this.gameRenderer = gameRenderer;
        setBackground(Color.DARK_GRAY);
        setSize(sizeWidth, sizeHeight);  
        setFocusable(false);
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximumSize(new java.awt.Dimension(90, 610));
        setPreferredSize(new java.awt.Dimension(90, 610));

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
}
