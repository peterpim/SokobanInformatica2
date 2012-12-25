package View;

import Model.GameRenderer;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * @author Peter-Pim
 */
public class MenuWindow extends javax.swing.JPanel {
    private GameRenderer gameRenderer;
    
    int sizeWidth = 100;
    int sizeHeight = 600;
    int score = 0;
    
    public MenuWindow(GameRenderer gameRenderer) {
        this.gameRenderer = gameRenderer;
        Border compound, raisedbevel, loweredbevel;
        raisedbevel = BorderFactory.createRaisedBevelBorder();
        loweredbevel = BorderFactory.createLoweredBevelBorder();
        compound = BorderFactory.createCompoundBorder(
                raisedbevel, loweredbevel);
        this.setBorder(compound);
        setBackground(Color.DARK_GRAY);
        setSize(sizeWidth, sizeHeight);  
        setFocusable(false);
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximumSize(new java.awt.Dimension(150, 610));
        setPreferredSize(new java.awt.Dimension(150, 600));

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
}
