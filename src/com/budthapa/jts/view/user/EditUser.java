/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budthapa.jts.view.user;

import com.budthapa.jts.business.UserBL;
import com.budthapa.jts.model.UserBean;
import com.budthapa.jts.view.main.LoginPanel;
import javax.swing.JOptionPane;

/**
 *
 * @author budthapa
 */
public class EditUser extends javax.swing.JDialog {

    static int userIdToDelete;
    static int rowIdToDelete;

    /**
     * Creates new form EditUser
     */
    public EditUser() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);

        //hide delete button from user
        if(!LoginPanel.loggedInUser.equals("admin")){
            btnDeleteUser.setVisible(false);
        }
        //dynamic update button is added from ViewUser class
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
        btnDeleteUser = new javax.swing.JButton();

        setTitle("Edit or Delete Client");

        btnDeleteUser.setText("Delete");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDeleteUser)
                .addContainerGap(784, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeleteUser)
                .addContainerGap())
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(0, 430, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        //first show the confirm dialog box
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you really want to delete this User?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {

            //delete the selected row
            //get the user id from UserBean where the data is set from ViewUser when double clicking the row
            boolean isUserDeleted = UserBL.deleteUser(userIdToDelete);
            if (isUserDeleted) {
                setVisible(false);
                //need to update the table view automatically
                //pass isUserDeleted to ViewUser class so that table gets referesed automatically
                ViewUser.table.fireTableDataChanged();
                ViewUser.table.removeRow(rowIdToDelete);
            }
        }
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    public static void refreshTableAfterUpdate(UserBean user) {
        //reload the ViewUser
        //need to update the table view automatically
        
        Object[] rowData = {
            user.getUserId(), user.getUsername(), user.getUserPosition(), user.getUserEmail(), user.getUserContactNumber(), user.getUserAddress()
        };
        ViewUser.table.fireTableDataChanged();
        ViewUser.table.removeRow(rowIdToDelete);
        ViewUser.table.insertRow(rowIdToDelete, rowData);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JPanel headerPanel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
