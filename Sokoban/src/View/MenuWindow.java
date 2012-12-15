package View;

import Model.Sokoban;
import java.awt.Color;

/**
 * @author Peter-Pim
 */
public class MenuWindow extends javax.swing.JPanel {
    Sokoban sokoban;
    
    public MenuWindow() {
        setBackground(Color.DARK_GRAY);
        
        initComponents();
    }
    
    public void setSokoban(Sokoban sokoban) {
        this.sokoban = sokoban;
    }
    
    public Sokoban getSokoban() {
        return sokoban;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
