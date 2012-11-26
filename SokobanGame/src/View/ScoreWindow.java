/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ScoreWindow.java
 *
 * Created on 11-jun-2012, 17:47:02
 */

package View;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Peter-Pim
 */
public class ScoreWindow extends javax.swing.JPanel {
    private MenuWindow menuWindow;
    
    /** Creates new form ScoreWindow */
    public ScoreWindow() {
        MainMenuListener mainMenu = new MainMenuListener();

        setBackground(Color.darkGray);
        initComponents();

        jBtnMenu.addActionListener(mainMenu);
    }

    public void setMenuWindow(MenuWindow menuWindow) {
        this.menuWindow = menuWindow;
    }

    public void editSteps(int value) {
        jTextSteps.setText(" " + value + " ");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextSteps = new javax.swing.JTextPane();
        jBtnMenu = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 50));

        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Total steps:");

        jTextSteps.setEditable(false);
        jTextSteps.setFocusable(false);
        jTextSteps.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(jTextSteps);

        jBtnMenu.setBackground(new java.awt.Color(51, 0, 0));
        jBtnMenu.setFont(new java.awt.Font("Hyborian", 1, 18));
        jBtnMenu.setForeground(new java.awt.Color(204, 204, 204));
        jBtnMenu.setText("Menu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 536, Short.MAX_VALUE)
                .addComponent(jBtnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextSteps;
    // End of variables declaration//GEN-END:variables

    class MainMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            menuWindow.checkStarted();
            menuWindow.setVisible(true);
            setVisible(false);
        }
    }
}
