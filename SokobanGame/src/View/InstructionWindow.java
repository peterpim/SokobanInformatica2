/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InstructionWindow.java
 *
 * Created on 18-jun-2012, 14:11:18
 */

package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Peter-Pim
 */
public class InstructionWindow extends javax.swing.JPanel {
    private MenuWindow menuWindow;

    /** Creates new form InstructionWindow */
    public InstructionWindow() {
        BackListener gotoMenu = new BackListener();

        setBackground(new Color(250, 255, 129));
        initComponents();

        jBtnBack.addActionListener(gotoMenu);
    }

    public void setMenuWindow(MenuWindow menuWindow) {
        this.menuWindow = menuWindow;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setLayout(null);

        jBtnBack.setBackground(new java.awt.Color(51, 0, 0));
        jBtnBack.setFont(new java.awt.Font("Hyborian", 1, 18));
        jBtnBack.setForeground(new java.awt.Color(204, 204, 204));
        jBtnBack.setText("Menu");
        add(jBtnBack);
        jBtnBack.setBounds(670, 600, 105, 27);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel1.setForeground(new java.awt.Color(63, 23, 23));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arrowkeyspng.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(12, 58, 153, 104);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel2.setForeground(new java.awt.Color(63, 23, 23));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/movechest.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(228, 93, 160, 102);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/teleport1.png"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(50, 260, 151, 202);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/teleport2.png"))); // NOI18N
        add(jLabel4);
        jLabel4.setBounds(240, 260, 152, 202);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel5.setForeground(new java.awt.Color(68, 11, 11));
        jLabel5.setText("1. Use the arrowkeys to move your character!");
        add(jLabel5);
        jLabel5.setBounds(12, 24, 284, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel6.setForeground(new java.awt.Color(68, 11, 11));
        jLabel6.setText("2. You can move boxes by moving against them.");
        add(jLabel6);
        jLabel6.setBounds(228, 59, 303, 17);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel7.setForeground(new java.awt.Color(68, 11, 11));
        jLabel7.setText("Remember: Only one can be moved at a time!");
        add(jLabel7);
        jLabel7.setBounds(395, 79, 284, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel8.setForeground(new java.awt.Color(68, 11, 11));
        jLabel8.setText("3. Use the teleports to transport your character to the blue-outlined field.");
        add(jLabel8);
        jLabel8.setBounds(50, 230, 450, 17);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/howtowin.png"))); // NOI18N
        add(jLabel9);
        jLabel9.setBounds(440, 400, 150, 110);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel10.setForeground(new java.awt.Color(68, 11, 11));
        jLabel10.setText("4. You can win a level by placing all of the boxes...");
        add(jLabel10);
        jLabel10.setBounds(440, 380, 305, 17);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel11.setForeground(new java.awt.Color(68, 11, 11));
        jLabel11.setText("on the red-outlined fields!");
        add(jLabel11);
        jLabel11.setBounds(600, 400, 154, 17);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel12.setForeground(new java.awt.Color(68, 11, 11));
        jLabel12.setText("5. Got stuck? Press F5 to reset a game.");
        add(jLabel12);
        jLabel12.setBounds(440, 540, 250, 17);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            menuWindow.setVisible(true);
            setVisible(false);
        }
    }
}
