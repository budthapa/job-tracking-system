package com.budthapa.jts.helpers;

import com.budthapa.jts.view.clients.ClientFrame;
import java.awt.Color;

public class ErrorMessages {

    public static String errorMessage;
    public static final String NAME_EMPTY = "Name field is Empty";
    public static final String INVALID_NAME = "Please enter a valid name";
    
    public static final String EMAIL_EMPTY = "Email field is Empty";
    public static final String INVALID_EMAIL = "Please enter a valid email";
    
    public static String USER_NOT_REGISTERED="This user is not registered.";
    public static final String CONTACT_NUMBER_EMPTY = "Contact Number field is Empty";
    public static final String CONTACT_PERSON_EMPTY = "Contact Person field is Empty";
    public static final String ADDRESS_EMPTY = "Address field is Empty";
    public static final String DESIGN_TYPE_EMPTY="Please select at least one design type";
    public static final String LANGUAGE_EMPTY="Please select at least one language";
    public static final String INVALID_NUMBER = "Please enter a valid number";
    public static final String INVALID_PHONE_FAX = "Please enter a valid number having min. 6 to max. 10 digits";
    public static final String JOB_CONTENT_EMPTY="Please specify some job contents";
    
    public static String CURRENT_PASSWORD_MISMATCH="Current password mismatch";
    public static final String NEW_PASSWORD_MISMATCH = "New Password mismatch";
    public static final String MINIMUM_PASSWORD_LENGTH = "Minimum password length > 6";
    public static String INVALID_USERNAME_PASSWORD="Invalid username or password";
    public static String CURRENT_PASSWORD_EMPTY="Current Password field is Empty";
    public static final String NEW_PASSWORD_EMPTY = "New password field is Empty";
    public static final String RETYPE_PASSWORD_EMPTY = "Retype password field is Empty";
    public static String PASSWORD_CHANGE_SUCCESSFUL="Password changed successfully";
    public static String PASSWORD_CHANGE_FAILED="Password changed failed";
    public static String JOB_MARKED_AS_COMPLETED="Job Marked as completed";
    

    public static void nameEmpty() {
        ClientFrame.lblErrorMessage.setForeground(Color.RED);
        ErrorMessages.errorMessage = ErrorMessages.NAME_EMPTY;
    }

    public static void emailEmpty() {
        
            ClientFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.EMAIL_EMPTY;
    }

}
