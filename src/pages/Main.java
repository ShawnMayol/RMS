/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pages;

/**
 *
 * @author Shawn
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLabel();
        bg1 = new javax.swing.JLabel();
        jMenu1 = new javax.swing.JMenu();
        panelGradiente2 = new swing.PanelGradiente();
        jLabel2 = new javax.swing.JLabel();
        LogInBtn = new javax.swing.JButton();
        BrowseAptBtn = new javax.swing.JButton();
        bg2 = new javax.swing.JLabel();

        bg.setBackground(new java.awt.Color(0, 204, 204));
        bg.setForeground(new java.awt.Color(0, 204, 204));
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/aptbg.jpg"))); // NOI18N

        bg1.setBackground(new java.awt.Color(0, 204, 204));
        bg1.setForeground(new java.awt.Color(0, 204, 204));
        bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/aptbg.jpg"))); // NOI18N

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelGradiente2.setColorPrimario(new java.awt.Color(163, 223, 158));
        panelGradiente2.setColorSecundario(new java.awt.Color(0, 77, 47));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("RENTAL MANAGEMENT SYSTEM");
        panelGradiente2.add(jLabel2);
        jLabel2.setBounds(0, 70, 820, 43);

        LogInBtn.setBackground(new java.awt.Color(0, 34, 102));
        LogInBtn.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        LogInBtn.setForeground(new java.awt.Color(204, 255, 255));
        LogInBtn.setText("<html>\n<body  style='text-align:center;'>\nAlready have an account?\n<br>\nLog In\n</body>\n</html>");
        LogInBtn.setToolTipText("");
        LogInBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogInBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LogInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInBtnActionPerformed(evt);
            }
        });
        panelGradiente2.add(LogInBtn);
        LogInBtn.setBounds(50, 220, 310, 130);

        BrowseAptBtn.setBackground(new java.awt.Color(0, 84, 42));
        BrowseAptBtn.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        BrowseAptBtn.setForeground(new java.awt.Color(204, 255, 204));
        BrowseAptBtn.setText("<html>\n<body  style='text-align:center;'>\nNew here?\n<br>\nBrowse Apartments\n</body>\n</html>");
        BrowseAptBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BrowseAptBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BrowseAptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseAptBtnActionPerformed(evt);
            }
        });
        panelGradiente2.add(BrowseAptBtn);
        BrowseAptBtn.setBounds(460, 220, 310, 130);

        bg2.setBackground(new java.awt.Color(0, 204, 204));
        bg2.setForeground(new java.awt.Color(0, 204, 204));
        bg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/aptbg.jpg"))); // NOI18N
        panelGradiente2.add(bg2);
        bg2.setBounds(0, 0, 800, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGradiente2, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGradiente2, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInBtnActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_LogInBtnActionPerformed

    private void BrowseAptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseAptBtnActionPerformed
        Browse browse = new Browse();
        browse.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_BrowseAptBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BrowseAptBtn;
    private javax.swing.JButton LogInBtn;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg1;
    private javax.swing.JLabel bg2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private swing.PanelGradiente panelGradiente2;
    // End of variables declaration//GEN-END:variables
}
