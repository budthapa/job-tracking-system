/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budthapa.jts.view.clients;

import com.budthapa.jts.business.ClientBL;
import com.budthapa.jts.model.ClientBean;
import com.budthapa.jts.view.main.LoginPanel;
import javax.swing.JOptionPane;

/**
 *
 * @author budthapa
 */
public class EditClient extends javax.swing.JDialog {

    static int clientIdToDelete;
    static int rowIdToDelete;

    /**
     * Creates new form EditClient
     */
    public EditClient() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);

        //hide delete button from user
        if (!new LoginPanel().isUserAdmin()) {
            btnDeleteClient.setVisible(false);
        }
        //dynamic update button is added from ViewClient class
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        btnDeleteClient = new javax.swing.JButton();

        setTitle("Edit or Delete Client");

        btnDeleteClient.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDeleteClient.setForeground(java.awt.Color.red);
        btnDeleteClient.setText("Delete");
        btnDeleteClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDeleteClient, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(743, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDeleteClient, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 404, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteClientActionPerformed
        //first show the confirm dialog box
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you really want to delete this Client?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {

            //delete the selected row
            //get the user id from ClientBean where the data is set from ViewClient when double clicking the row
            boolean isClientDeleted = ClientBL.deleteClient(clientIdToDelete);
            if (isClientDeleted) {
                setVisible(false);
                //need to update the table view automatically
                //pass isClientDeleted to ViewClient class so that table gets referesed automatically
                ViewClient.table.fireTableDataChanged();
                ViewClient.table.removeRow(rowIdToDelete);
            }
        }
    }//GEN-LAST:event_btnDeleteClientActionPerformed

    public static void refreshTableAfterUpdate(ClientBean client) {
        //reload the ViewClient
        //need to update the table view automatically

        Object[] rowData = {
            client.getClientId(), client.getClientName(), client.getClientType(), client.getClientEmail(), client.getClientContactPerson(), client.getClientContactNumber(), client.getClientFaxNumber(), client.getClientAddress()
        };
        ViewClient.table.fireTableDataChanged();
        ViewClient.table.removeRow(rowIdToDelete);
        ViewClient.table.insertRow(rowIdToDelete, rowData);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteClient;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JPanel headerPanel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
