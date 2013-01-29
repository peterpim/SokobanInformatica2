package View;

import Model.Manager;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
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
    
    public void viewScore(int value) {
        
    }
    
    public void viewLevel(int value) {
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRestartLevel = new javax.swing.JButton();
        txtFieldScore = new javax.swing.JTextField();
        txtFieldCurrentLevel = new javax.swing.JTextField();
        btnChildmode = new javax.swing.JButton();
        btnQuitGame = new javax.swing.JButton();
        btnRestartGame = new javax.swing.JButton();
        lblScore = new javax.swing.JLabel();
        lblCurrentLevel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(150, 610));
        setPreferredSize(new java.awt.Dimension(150, 600));

        btnRestartLevel.setText("Restart Level");

        txtFieldScore.setEnabled(false);

        txtFieldCurrentLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldCurrentLevelActionPerformed(evt);
            }
        });

        btnChildmode.setText("Childmode");
        btnChildmode.setMaximumSize(new java.awt.Dimension(83, 23));
        btnChildmode.setMinimumSize(new java.awt.Dimension(83, 23));

        btnQuitGame.setText("Quit Game");

        btnRestartGame.setText("Restart Game");

        lblScore.setForeground(new java.awt.Color(204, 204, 204));
        lblScore.setText("Your score:");

        lblCurrentLevel.setForeground(new java.awt.Color(204, 204, 204));
        lblCurrentLevel.setText("Current Level:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(btnRestartLevel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, txtFieldScore)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, txtFieldCurrentLevel)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, btnQuitGame, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, btnChildmode, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, btnRestartGame, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(lblScore)
                    .add(lblCurrentLevel))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(btnRestartLevel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(btnRestartGame, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(btnQuitGame, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(btnChildmode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(30, 30, 30)
                .add(lblCurrentLevel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtFieldCurrentLevel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(30, 30, 30)
                .add(lblScore)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtFieldScore, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        btnRestartLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    Object[] opties = {"Yes", "No"};
                    int answer = JOptionPane.showOptionDialog(null,
                        "Are you sure you want to restart the game?",
                        "Restart Game", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        null, opties, opties[1]);
                    if(answer == JOptionPane.YES_OPTION) {
                        manager.gameEnd(2);
                    }
                } catch(Exception e) { e.printStackTrace(); }
            }
        });
        btnChildmode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    manager.setChildmode();
                } catch (Exception e) { e.printStackTrace(); }
            }
        });
        btnQuitGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    Object[] opties = {"Yes", "No"};
                    int answer = JOptionPane.showOptionDialog(null,
                        "Are you sure you want to quit?", "Quit game",
                        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        null, opties, opties[1]);
                    if(answer == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                } catch (Exception e) { e.printStackTrace(); }
            }
        });
        btnRestartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    Object[] opties = {"Yes", "No"};
                    int answer = JOptionPane.showOptionDialog(null,
                        "Are you sure you want to restart the game?",
                        "Restart Game", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        null, opties, opties[1]);
                    if(answer == JOptionPane.YES_OPTION) {
                        manager.gameEnd(1);
                    }
                } catch(Exception e) { e.printStackTrace(); }
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldCurrentLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldCurrentLevelActionPerformed
        // This textfield does nothing, useless method...
    }//GEN-LAST:event_txtFieldCurrentLevelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChildmode;
    private javax.swing.JButton btnQuitGame;
    private javax.swing.JButton btnRestartGame;
    private javax.swing.JButton btnRestartLevel;
    private javax.swing.JLabel lblCurrentLevel;
    private javax.swing.JLabel lblScore;
    private javax.swing.JTextField txtFieldCurrentLevel;
    private javax.swing.JTextField txtFieldScore;
    // End of variables declaration//GEN-END:variables
}
