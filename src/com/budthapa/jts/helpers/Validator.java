/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.budthapa.jts.helpers;

import com.budthapa.jts.model.UserBean;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author budthapa
 */
public class Validator {

    /**
     * Email validator. Validates email all over the application
     *
     * @param email
     * @return
     */
    public static boolean emailValidator(String email) {
        String emailReg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(emailReg);
    }
    
    /**
     * Nepal standard Phone Number validator. Validates digits between 6-10.
     *
     * @param phone
     * @return
     */
    public static boolean phoneNoValidator(String phone) {
        String phoneReg = "\\d{6,10}";
        return phone.matches(phoneReg);
    }
    
    
    /**
     * Number validator
     *
     * @param number
     * @return
     */
    public static boolean numberValidator(String number) {
        String phoneReg = "^[0-9]\\d*$";
        return number.matches(phoneReg);
    }
    
    /**
     * Validates any type of name
     *
     * @param name
     * @return
     */
    public static boolean nameValidator(String name) {
        String nameReg = "^[\\p{L} .'-]+$";
        return name.matches(nameReg);
    }
    
    /**
     * validates username
     *
     * @param username
     * @return
     */
    public static boolean usernameValidator(String username) {
        String usernameReg = "[a-zA-Z0-9._-]{3,}";
        return username.matches(usernameReg);
    }

    public static boolean checkMinPasswordLength(String password) {
        return password.length()<6?true:false;
    }

    public static boolean newPasswordRetypePasswordMatches(String newPassword, String retypePassword){
        return newPassword.equals(retypePassword)?true:false;
    }
    
    public String hashPassword(String newPassword) {
        return BCrypt.hashpw(newPassword, BCrypt.gensalt());
    }

    public boolean verifyUsernamePassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
    
    public static boolean passwordEmpty(String password){
        return password.isEmpty()?true:false;
    }
}
