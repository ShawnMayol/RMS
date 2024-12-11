package pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import java.awt.Image;

public class AdminDashboard extends javax.swing.JFrame {
    public AdminDashboard() {
        initComponents();
        setLocationRelativeTo(null);
        
        // Load the image from the assets folder
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/assets/leave.png"));

        Image image = originalIcon.getImage();
        Image resizedImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH); // Resize (adjust size here)

        // Set the resized image as the button icon
        leaveBtn.setIcon(new ImageIcon(resizedImage)); // Set to your leaveBtn
        
        // Create a SimpleDateFormat to format the current time (without seconds)
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");  // Format: 12-hour clock without seconds
        String time = sdf.format(new Date());  // Get the current time
        clockLabel.setText(time);  // Set the initial time into the clockLabel

        // Timer to update the clock every minute (since we don't need seconds)
        Timer clockTimer = new Timer(60000, new ActionListener() { // Change to 60000 ms (1 minute)
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the current time
                String time = sdf.format(new Date());
                clockLabel.setText(time);  // Set the updated time into the clockLabel
            }
        });
        clockTimer.start();  // Start the clock timer
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradiente1 = new swing.PanelGradiente();
        topbarPanel = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        clockLabel = new javax.swing.JLabel();
        leaveBtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        aptBtn = new javax.swing.JButton();
        tenantsBtn = new javax.swing.JButton();
        paymentsBtn1 = new javax.swing.JButton();
        requestsBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        apartmentTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelGradiente1.setColorPrimario(new java.awt.Color(93, 126, 94));
        panelGradiente1.setColorSecundario(new java.awt.Color(30, 44, 31));
        panelGradiente1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topbarPanel.setBackground(new java.awt.Color(240, 255, 244));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(24, 39, 26));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html> <body  style='text-align:center;'> RENTAL<br>MANAGEMENT<br>SYSTEM</body> </html>");
        topbarPanel.add(jLabel1);
        jLabel1.setBounds(10, 10, 140, 70);

        clockLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        clockLabel.setForeground(new java.awt.Color(0, 0, 0));
        clockLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        clockLabel.setText("12:00 AM");
        topbarPanel.add(clockLabel);
        clockLabel.setBounds(630, 10, 120, 70);

        leaveBtn.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        leaveBtn.setForeground(new java.awt.Color(0, 0, 0));
        leaveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/leave.png"))); // NOI18N
        leaveBtn.setToolTipText("Log out");
        leaveBtn.setAlignmentY(0.0F);
        leaveBtn.setContentAreaFilled(false);
        leaveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        leaveBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        leaveBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        leaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveBtnActionPerformed(evt);
            }
        });
        topbarPanel.add(leaveBtn);
        leaveBtn.setBounds(750, 10, 60, 70);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        topbarPanel.add(jSeparator2);
        jSeparator2.setBounds(630, 20, 10, 50);

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        topbarPanel.add(jSeparator3);
        jSeparator3.setBounds(270, 20, 10, 50);

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        topbarPanel.add(jSeparator4);
        jSeparator4.setBounds(390, 20, 10, 50);

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        topbarPanel.add(jSeparator5);
        jSeparator5.setBounds(510, 20, 10, 50);

        aptBtn.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        aptBtn.setForeground(new java.awt.Color(0, 0, 0));
        aptBtn.setText("Apartments");
        aptBtn.setAlignmentY(0.0F);
        aptBtn.setContentAreaFilled(false);
        aptBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aptBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aptBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        aptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aptBtnActionPerformed(evt);
            }
        });
        topbarPanel.add(aptBtn);
        aptBtn.setBounds(160, 10, 110, 70);

        tenantsBtn.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        tenantsBtn.setForeground(new java.awt.Color(0, 0, 0));
        tenantsBtn.setText("Tenants");
        tenantsBtn.setAlignmentY(0.0F);
        tenantsBtn.setContentAreaFilled(false);
        tenantsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tenantsBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenantsBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tenantsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenantsBtnActionPerformed(evt);
            }
        });
        topbarPanel.add(tenantsBtn);
        tenantsBtn.setBounds(390, 10, 120, 70);

        paymentsBtn1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        paymentsBtn1.setForeground(new java.awt.Color(0, 0, 0));
        paymentsBtn1.setText("Payments");
        paymentsBtn1.setAlignmentY(0.0F);
        paymentsBtn1.setContentAreaFilled(false);
        paymentsBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paymentsBtn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        paymentsBtn1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        paymentsBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentsBtn1ActionPerformed(evt);
            }
        });
        topbarPanel.add(paymentsBtn1);
        paymentsBtn1.setBounds(510, 10, 120, 70);

        requestsBtn.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        requestsBtn.setForeground(new java.awt.Color(0, 0, 0));
        requestsBtn.setText("Requests");
        requestsBtn.setAlignmentY(0.0F);
        requestsBtn.setContentAreaFilled(false);
        requestsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        requestsBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        requestsBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        requestsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestsBtnActionPerformed(evt);
            }
        });
        topbarPanel.add(requestsBtn);
        requestsBtn.setBounds(270, 10, 120, 70);

        panelGradiente1.add(topbarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 810, 80));

        apartmentTable.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        apartmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Apt No.", "Name", "Address", "Price", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        apartmentTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        apartmentTable.setRowHeight(50);
        apartmentTable.setShowGrid(false);
        apartmentTable.setShowVerticalLines(true);
        apartmentTable.getTableHeader().setReorderingAllowed(false);
        apartmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                apartmentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(apartmentTable);

        panelGradiente1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 630, 410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void leaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveBtnActionPerformed
        Main m = new Main();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_leaveBtnActionPerformed

    private void requestsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requestsBtnActionPerformed

    private void aptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aptBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aptBtnActionPerformed

    private void tenantsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenantsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenantsBtnActionPerformed

    private void paymentsBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentsBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentsBtn1ActionPerformed

    private void apartmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apartmentTableMouseClicked
        int selectedRow = apartmentTable.getSelectedRow();
        if (selectedRow != -1) {
            int apartmentID = (int) apartmentTable.getValueAt(selectedRow, 0);
            String name = (String) apartmentTable.getValueAt(selectedRow, 1);
            String address = (String) apartmentTable.getValueAt(selectedRow, 2);
            double price = (double) apartmentTable.getValueAt(selectedRow, 3);
            String status = (String) apartmentTable.getValueAt(selectedRow, 4);

            //            ApartmentDetails detailsPage = new ApartmentDetails(apartmentID, name, address, price, status);
            ApartmentDetails detailsPage = new ApartmentDetails();
            detailsPage.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_apartmentTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable apartmentTable;
    private javax.swing.JButton aptBtn;
    private javax.swing.JLabel clockLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JButton leaveBtn;
    private swing.PanelGradiente panelGradiente1;
    private javax.swing.JButton paymentsBtn1;
    private javax.swing.JButton requestsBtn;
    private javax.swing.JButton tenantsBtn;
    private swing.PanelBorder topbarPanel;
    // End of variables declaration//GEN-END:variables
}