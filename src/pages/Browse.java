package pages;

import utils.db_connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class Browse extends javax.swing.JFrame {
    Connection conn;

    public Browse() {
       initComponents();
       setLocationRelativeTo(null);
       conn = db_connect.connect();
       if (conn != null) {
           populateTable();
       } else {
           System.out.println("Failed to connect to the database.");
       }
    }
    
    private void populateTable() {
        try {
            String query = "SELECT apartmentID, name, address, price, status FROM apartments";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            DefaultTableModel model = (DefaultTableModel) apartmentTable.getModel();
            // Clear existing rows
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("apartmentID"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getDouble("price"),
                    rs.getString("status")
                });
            }

            // Center the column titles
            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
            headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            for (int i = 0; i < apartmentTable.getColumnCount(); i++) {
                apartmentTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
            }
            
            // Create a renderer to center the text
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            // Loop through each column and apply the renderer
            for (int i = 0; i < apartmentTable.getColumnCount(); i++) {
                apartmentTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void populateTableWithFilters(String status, double minPrice, double maxPrice) {
        try {
            // Start building the SQL query
            StringBuilder queryBuilder = new StringBuilder("SELECT apartmentID, name, address, price, status FROM apartments WHERE price >= ? AND price <= ?");

            // List to hold the parameters for the prepared statement
            List<Object> parameters = new ArrayList<>();
            parameters.add(minPrice);
            parameters.add(maxPrice);

            // Add status to the query only if it is not the default
            if (!"Select Status".equals(status)) {
                queryBuilder.append(" AND status = ?");
                parameters.add(status);
            }

            // Convert StringBuilder to String and prepare the statement
            PreparedStatement stmt = conn.prepareStatement(queryBuilder.toString());

            // Set the parameters for the prepared statement
            for (int i = 0; i < parameters.size(); i++) {
                Object param = parameters.get(i);
                if (param instanceof Double) {
                    stmt.setDouble(i + 1, (Double) param);
                } else if (param instanceof String) {
                    stmt.setString(i + 1, (String) param);
                }
            }

            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) apartmentTable.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("apartmentID"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getDouble("price"),
                    rs.getString("status")
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void searchApartments(String keyword) {
        try {
            String query = "SELECT apartmentID, name, address, price, status FROM apartments WHERE name LIKE ? OR address LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");

            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) apartmentTable.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("apartmentID"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getDouble("price"),
                    rs.getString("status")
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        apartmentTable = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        selectPrice = new javax.swing.JComboBox<>();
        selectStatus = new javax.swing.JComboBox<>();
        applyBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelGradiente1.setColorPrimario(new java.awt.Color(131, 145, 220));
        panelGradiente1.setColorSecundario(new java.awt.Color(0, 17, 71));

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
        if (apartmentTable.getColumnModel().getColumnCount() > 0) {
            apartmentTable.getColumnModel().getColumn(0).setResizable(false);
            apartmentTable.getColumnModel().getColumn(1).setResizable(false);
            apartmentTable.getColumnModel().getColumn(2).setResizable(false);
            apartmentTable.getColumnModel().getColumn(3).setResizable(false);
            apartmentTable.getColumnModel().getColumn(4).setResizable(false);
        }

        backBtn.setBackground(new java.awt.Color(36, 0, 160));
        backBtn.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 24)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(202, 226, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FILTER");

        searchBar.setToolTipText("Apartment Name...");
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        selectPrice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Price", "Php < 6000", "Php 6000 - 7000", "Php 7000 - 8000", "Php > 8000" }));

        selectStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Status", "Available", "Booked", "Maintenance" }));

        applyBtn.setText("Apply");
        applyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyBtnActionPerformed(evt);
            }
        });

        panelGradiente1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelGradiente1.setLayer(backBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelGradiente1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelGradiente1.setLayer(searchBar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelGradiente1.setLayer(searchBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelGradiente1.setLayer(selectPrice, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelGradiente1.setLayer(selectStatus, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelGradiente1.setLayer(applyBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelGradiente1Layout = new javax.swing.GroupLayout(panelGradiente1);
        panelGradiente1.setLayout(panelGradiente1Layout);
        panelGradiente1Layout.setHorizontalGroup(
            panelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradiente1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradiente1Layout.createSequentialGroup()
                        .addComponent(searchBar)
                        .addGap(0, 0, 0)
                        .addComponent(searchBtn))
                    .addComponent(selectPrice, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(applyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelGradiente1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelGradiente1Layout.setVerticalGroup(
            panelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(panelGradiente1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(panelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(applyBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        Main landing = new Main();
        landing.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String keyword = searchBar.getText();
        searchApartments(keyword);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void applyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyBtnActionPerformed
        String priceSelection = selectPrice.getSelectedItem().toString();
        String status = selectStatus.getSelectedItem().toString();

        double minPrice = 0;
        double maxPrice = Double.MAX_VALUE; // Use Java's maximum value for double to represent '> 8000'

        switch (priceSelection) {
            case "Php < 6000":
                maxPrice = 6000;
                break;
            case "Php 6000 - 7000":
                minPrice = 6000;
                maxPrice = 7000;
                break;
            case "Php 7000 - 8000":
                minPrice = 7000;
                maxPrice = 8000;
                break;
            case "Php > 8000":
                minPrice = 8000;
                break;
        }

        populateTableWithFilters(status, minPrice, maxPrice);
    }//GEN-LAST:event_applyBtnActionPerformed

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed

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
            java.util.logging.Logger.getLogger(Browse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Browse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Browse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Browse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Browse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable apartmentTable;
    private javax.swing.JButton applyBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.PanelGradiente panelGradiente1;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton searchBtn;
    private javax.swing.JComboBox<String> selectPrice;
    private javax.swing.JComboBox<String> selectStatus;
    // End of variables declaration//GEN-END:variables
}
