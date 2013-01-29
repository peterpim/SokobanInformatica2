package View;

import Model.Manager;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * @author Peter-Pim
 */
public class MenuWindow extends javax.swing.JPanel {
    Manager manager;
    
    public MenuWindow(Manager manager) {
        this.manager = manager;
        Border compound, raisedbevel, loweredbevel;

        raisedbevel = BorderFactory.createRaisedBevelBorder();
        loweredbevel = BorderFactory.createLoweredBevelBorder();
        compound = BorderFactory.createCompoundBorder(
            raisedbevel, loweredbevel);
        
        setBorder(compound);
        setBackground(Color.DARK_GRAY);
        setSize(100, 600);
        setFocusable(false);
          
        initComponents();
    }

    public void restartGame() {
        
    }
    
    public void restartLevel() {
        
    }
    
    public void quitGame() {
        
    }
    
    public void enableChildmode() {
        
    }
    
    public void viewScore(int value) {
        
    }
    
    public void viewLevel(int value) {
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximumSize(new java.awt.Dimension(150, 610));
        setPreferredSize(new java.awt.Dimension(150, 600));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 150, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
