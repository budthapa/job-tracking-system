/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budthapa.jts.view.user;

import com.budthapa.jts.business.UserBL;
import com.budthapa.jts.helpers.UserPositionType;
import com.budthapa.jts.model.UserBean;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;

/**
 *
 * @author budthapa
 */
public class UserFrame extends javax.swing.JInternalFrame {

    public String buttonText;
    UserBean user;
//    public static boolean viewUsersByAdmin=false;
    public static boolean userCreatedByAdmin=false;

    /**
     * Creates new form UserFrame
     */
    public UserFrame() {
        initComponents();
        //hide titlebar
        ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
        this.buttonText = "";
        userId.setVisible(false);
        
        DefaultComboBoxModel combo=new DefaultComboBoxModel();
        for(UserPositionType userPosition:UserPositionType.values()){
            combo.addElement(userPosition);
        }
        userPositionType.setModel(combo);
    }

    public JInternalFrame getFrame() {
        return this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        clientLeftPanel4 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lblSetPassword = new javax.swing.JLabel();
        lblMinimunPasswordLength = new javax.swing.JLabel();
        editPanel1 = new javax.swing.JPanel();
        userName = new javax.swing.JTextField();
        userEmail = new javax.swing.JTextField();
        userContactNumber = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        userAddress = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        userId = new javax.swing.JTextField();
        lblNewPassword = new javax.swing.JLabel();
        lblRetypePassword = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblErrorMessage = new javax.swing.JLabel();
        newPassword = new javax.swing.JPasswordField();
        retypePassword = new javax.swing.JPasswordField();
        userPositionType = new javax.swing.JComboBox();

        setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
        );

        clientLeftPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel29.setText("User Name");

        jLabel30.setText("Position");

        jLabel31.setText("Email");

        jLabel32.setText("Contact No.");

        jLabel35.setText("Address");

        lblSetPassword.setText("Set password");

        lblMinimunPasswordLength.setText("(minimum length 6 characters)");

        javax.swing.GroupLayout clientLeftPanel4Layout = new javax.swing.GroupLayout(clientLeftPanel4);
        clientLeftPanel4.setLayout(clientLeftPanel4Layout);
        clientLeftPanel4Layout.setHorizontalGroup(
            clientLeftPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientLeftPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientLeftPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel35)
                    .addComponent(lblSetPassword)
                    .addComponent(lblMinimunPasswordLength))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        clientLeftPanel4Layout.setVerticalGroup(
            clientLeftPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientLeftPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(lblSetPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMinimunPasswordLength)
                .addGap(47, 47, 47)
                .addComponent(jLabel30)
                .addGap(23, 23, 23)
                .addComponent(jLabel31)
                .addGap(26, 26, 26)
                .addComponent(jLabel32)
                .addGap(18, 18, 18)
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        editPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        userAddress.setColumns(20);
        userAddress.setRows(5);
        jScrollPane1.setViewportView(userAddress);

        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblNewPassword.setText("New password");

        lblRetypePassword.setText("Retype password");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        userPositionType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout editPanel1Layout = new javax.swing.GroupLayout(editPanel1);
        editPanel1.setLayout(editPanel1Layout);
        editPanel1Layout.setHorizontalGroup(
            editPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userPositionType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(userEmail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userContactNumber, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newPassword, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(retypePassword, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editPanel1Layout.createSequentialGroup()
                        .addGroup(editPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(editPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(editPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNewPassword)
                                    .addComponent(lblRetypePassword))))
                        .addGap(196, 196, 196))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        editPanel1Layout.setVerticalGroup(
            editPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNewPassword)
                    .addComponent(newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRetypePassword)
                    .addComponent(retypePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(editPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(userPositionType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(userEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(userContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clientLeftPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(clientLeftPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        this.buttonText = btnSave.getText();
        if (btnSave.getText().equals("Save")) {
            userCreatedByAdmin=true;
            user = new UserBean(0, userName.getText(), newPassword.getText(), retypePassword.getText(), userPositionType.getSelectedItem().toString(),userEmail.getText(), userContactNumber.getText(), userAddress.getText());
        } else {
            userCreatedByAdmin=false;
//            viewUsersByAdmin=true;
            System.out.println("p1 "+newPassword.getText()+" p2 "+retypePassword.getText());
            user = new UserBean(Integer.parseInt(userId.getText()), userName.getText(),newPassword.getText(), retypePassword.getText(),userPositionType.getSelectedItem().toString(), userEmail.getText(), userContactNumber.getText(), userAddress.getText());
        }
        UserBL.getButtonText(buttonText);
        UserBL.passUserObject(user);
    }//GEN-LAST:event_btnSaveActionPerformed

    void setButtonText(String buttonText) {
        btnSave.setText(buttonText);
    }

    void setValuesToEdit(UserBean user) {
        UserBL.getUserPassword(user.getUserId());
        EditUser.userIdToDelete = user.getUserId();
        System.out.println("user "+user.getUserId());
        userId.setText(String.valueOf(user.getUserId()));
        userName.setText(user.getUsername());    
        newPassword.setVisible(false);
        retypePassword.setVisible(false);
        lblMinimunPasswordLength.setVisible(false);
        lblNewPassword.setVisible(false);
        lblRetypePassword.setVisible(false);
        lblSetPassword.setVisible(false);
//        newPassword.setText(UserBL.getUserPassword(user.getUserId()));
//        retypePassword.setText(UserBL.getUserPassword(user.getUserId()));
        userPositionType.setSelectedItem(user.getUserPosition());System.out.println("usepos : "+user.getUserPosition());
        userEmail.setText(user.getUserEmail());
        userContactNumber.setText(user.getUserContactNumber());
        userAddress.setText(user.getUserAddress());
        this.user=user;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel clientLeftPanel4;
    private javax.swing.JPanel editPanel1;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblErrorMessage;
    private javax.swing.JLabel lblMinimunPasswordLength;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JLabel lblRetypePassword;
    private javax.swing.JLabel lblSetPassword;
    private javax.swing.JPasswordField newPassword;
    private javax.swing.JPasswordField retypePassword;
    private javax.swing.JTextArea userAddress;
    private javax.swing.JTextField userContactNumber;
    private javax.swing.JTextField userEmail;
    private javax.swing.JTextField userId;
    private javax.swing.JTextField userName;
    private javax.swing.JComboBox userPositionType;
    // End of variables declaration//GEN-END:variables

}
