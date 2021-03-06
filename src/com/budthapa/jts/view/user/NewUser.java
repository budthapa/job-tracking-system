/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budthapa.jts.view.user;

import com.budthapa.jts.business.UserBL;
import com.budthapa.jts.model.UserBean;

/**
 *
 * @author budthapa
 */
public class NewUser extends javax.swing.JInternalFrame {

    public static int rowCountBeforeAddingNewUser;

    public NewUser() {
        initComponents();
        setVisible(true);
        UserFrame frame = new UserFrame();
        frame.getFrame();
        frame.setVisible(true);
        add(frame);

        //set button text dynamically
        //set button text to 'save' while accessing from this class
        String buttonText = "Save";
        frame.setButtonText(buttonText);
    }

    public static void addNewUserRow(UserBean client) {
        //reload the ViewUser
        //need to update the table view automatically

        //by default the id will be set to 0 when the table is updated
        //so we need to get the recent user id and set it;
        UserBL.getRecentSavedUserId(client);

        Object[] rowData = {
//            client.getUserId() + 1, client.getUserName(), client.getUserType(), client.getUserEmail(), client.getUserContactNumber(), client.getUserContactPerson(), client.getUserFaxNumber(), client.getUserAddress()
        };
        ViewUser.table.fireTableDataChanged();
        ViewUser.table.insertRow(ViewUser.table.getRowCount(), rowData);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Add New User");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
