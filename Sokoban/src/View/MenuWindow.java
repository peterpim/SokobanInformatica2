package View;

import Model.GameRenderer;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
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
        try {
            this.gameRenderer = gameRenderer;
            Border compound, raisedbevel, loweredbevel;

            raisedbevel = BorderFactory.createRaisedBevelBorder();
            loweredbevel = BorderFactory.createLoweredBevelBorder();
            compound = BorderFactory.createCompoundBorder(
                    raisedbevel, loweredbevel);

            this.setBorder(compound);
            setBackground(Color.DARK_GRAY);
            setSize(sizeWidth, sizeHeight);  

            initComponents();
            setFocusable(false);
        } catch(Exception e) { e.printStackTrace(); }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRestartGame = new javax.swing.JButton();
        btnQuitGame = new javax.swing.JButton();
        lblScore = new javax.swing.JLabel();
        txtFieldScore = new javax.swing.JTextField();
        btnChildmode = new javax.swing.JButton();
        lblCurrentLevel = new javax.swing.JLabel();
        txtFieldCurrentLevel = new javax.swing.JTextField();
        btnRestartLevel = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(150, 610));
        setPreferredSize(new java.awt.Dimension(150, 600));

        btnRestartGame.setText("Restart Game");

        btnQuitGame.setText("Quit Game");

        lblScore.setForeground(new java.awt.Color(204, 204, 204));
        lblScore.setText("Your score:");

        txtFieldScore.setEnabled(false);

        btnChildmode.setText("Childmode");
        btnChildmode.setMaximumSize(new java.awt.Dimension(83, 23));
        btnChildmode.setMinimumSize(new java.awt.Dimension(83, 23));

        lblCurrentLevel.setForeground(new java.awt.Color(204, 204, 204));
        lblCurrentLevel.setText("Current Level:");

        txtFieldCurrentLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldCurrentLevelActionPerformed(evt);
            }
        });

        btnRestartLevel.setText("Restart Level");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblScore)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtFieldScore, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtFieldCurrentLevel, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblCurrentLevel, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(btnRestartGame, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(btnRestartLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuitGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChildmode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnRestartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRestartLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnQuitGame, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnChildmode, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblCurrentLevel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFieldCurrentLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblScore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFieldScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        btnRestartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Object[] opties = {"Yes", "No"};
                int answer = JOptionPane.showOptionDialog(null,
                    "Are you sure you want to restart the game?",
                    "Restart Game", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, opties, opties[1]);
                if(answer == JOptionPane.YES_OPTION) {
                    gameRenderer.resetCurrentLevel();
                    gameRenderer.reset();
                }
                gameRenderer.getGameWindow().requestFocus();
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
                    gameRenderer.getGameWindow().requestFocus();
                } catch (Exception e) { e.printStackTrace(); }
            }
        });
        btnChildmode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    if(gameRenderer.isChildMode()) {
                        gameRenderer.setChildMode();
                        JOptionPane.showMessageDialog(null, "Childmode was disabled",
                            "Childmode", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        gameRenderer.setChildMode();
                        JOptionPane.showMessageDialog(null, "Childmode was enabled",
                            "Childmode", JOptionPane.INFORMATION_MESSAGE);
                    }
                    gameRenderer.getGameWindow().requestFocus();
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
                        gameRenderer.resetCurrentLevel();
                        gameRenderer.reset();
                    }
                    gameRenderer.getGameWindow().requestFocus();
                } catch (Exception e) { e.printStackTrace(); }
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldCurrentLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldCurrentLevelActionPerformed
        // TODO add your handling code here:
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
