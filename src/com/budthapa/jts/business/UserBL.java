package com.budthapa.jts.business;

import com.budthapa.jts.dao.UserDAO;
import com.budthapa.jts.helpers.ErrorMessages;
import com.budthapa.jts.helpers.Validator;
import com.budthapa.jts.model.UserBean;
import com.budthapa.jts.view.user.EditUser;
import com.budthapa.jts.view.user.NewUser;
import com.budthapa.jts.view.user.UserFrame;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class UserBL {
    public static boolean isViewUserClassOpen;
    private static String btnText;
    public static int userId; //this user id will be accessed while changing the password

    public static boolean areFieldsEmpty(UserBean user) {
        if (user.getUsername().isEmpty()) {
            UserFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.NAME_EMPTY;
            return false;
        }

        //now validate name
        if (!Validator.nameValidator(user.getUsername())) {

            UserFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.INVALID_NAME;
            return false;
        }

        String newPassword = user.getNewPassword();
        String retypePassword = user.getRetypePassword();
        if (UserFrame.userCreatedByAdmin) {
//        if (UserFrame.viewUsersByAdmin == false) {
            
            if (Validator.passwordEmpty(newPassword)) {
                UserFrame.lblErrorMessage.setForeground(Color.RED);
                ErrorMessages.errorMessage = ErrorMessages.NEW_PASSWORD_EMPTY;
                return false;
            }

            if (Validator.checkMinPasswordLength(newPassword)) {
                UserFrame.lblErrorMessage.setForeground(Color.RED);
                ErrorMessages.errorMessage = ErrorMessages.MINIMUM_PASSWORD_LENGTH;
                return false;
            }

            if (Validator.passwordEmpty(retypePassword)) {
                UserFrame.lblErrorMessage.setForeground(Color.RED);
                ErrorMessages.errorMessage = ErrorMessages.RETYPE_PASSWORD_EMPTY;
                return false;
            }

            if (Validator.checkMinPasswordLength(retypePassword)) {
                UserFrame.lblErrorMessage.setForeground(Color.RED);
                ErrorMessages.errorMessage = ErrorMessages.MINIMUM_PASSWORD_LENGTH;
                return false;
            }

            if (!Validator.newPasswordRetypePasswordMatches(newPassword, retypePassword)) {
                UserFrame.lblErrorMessage.setForeground(Color.RED);
                ErrorMessages.errorMessage = ErrorMessages.NEW_PASSWORD_MISMATCH;
                return false;
            }
            //hash and set this new password, this will replace the existing plain password
            user.setNewPassword(new Validator().hashPassword(newPassword));
        }

        String email = user.getUserEmail();
        if (!Validator.emailValidator(email)) {
            UserFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.INVALID_EMAIL;
            return false;
        }

        if (!Validator.phoneNoValidator(user.getUserContactNumber())) {
            UserFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.INVALID_PHONE_FAX;
            return false;
        }

        return true;
    }

    public static boolean userDataIsSaved(UserBean user) {
        boolean isUserAlreadyExists = checkIfUserAlreadyExists(user.getUsername());
        if (btnText.equals("Save")) {
            if (!isUserAlreadyExists) {
                int rowCountBeforeAddingNewUser = 0;
                NewUser.rowCountBeforeAddingNewUser = rowCountBeforeAddingNewUser;

                //referesh the table only if ViewUser class is already open
                //if we will not do this, execption will be thrown while creating new user
                //because it will try to referesh the table which is yet not created
                if (isViewUserClassOpen) {
                    NewUser.addNewUserRow(user);
                }
                return new UserDAO().insertUser(user);
            }
            return false;
        } else {
//            if (!isUserAlreadyExists) {
            System.out.println("updating the database");
            //update the database here
            boolean updated = new UserDAO().updateUser(user);
            if (updated) {
                EditUser.refreshTableAfterUpdate(user);
            }
            return updated;

//            }
//            return false;
        }
    }

    public static boolean checkIfUserAlreadyExists(String userName) {
        return new UserDAO().getUserName(userName);
    }

    public static boolean deleteUser(int userIdToDelete) {
        return new UserDAO().deleteUser(userIdToDelete);
    }

    public static void getRecentSavedUserId(UserBean user) {
        new UserDAO().getRecentlySavedUserId(user);
    }

    public static String getUserPassword(int userId) {
        return new UserDAO().getUserPassword(userId);
    }

    public static boolean isValidUser(UserBean user){
        return new UserDAO().checkVaildUser(user);
    }
    
    public static boolean checkUsernamePassword(UserBean user) {
        if (isValidUser(user)) {
            userId = new UserDAO().getUserId(user);
            return new Validator().verifyUsernamePassword(user.getNewPassword(), new UserDAO().getUserPassword(userId));
        }
        return false;
    }

    public ArrayList<UserBean> getUserList() {
        return new UserDAO().getUserList();
    }

    public static void passUserObject(UserBean user) {
        boolean isFieldEmpty = areFieldsEmpty(user);
        if (!isFieldEmpty) {
            UserFrame.lblErrorMessage.setText(ErrorMessages.errorMessage);
            return;
        }

        //save user data
        boolean isUserSaved = userDataIsSaved(user);
        if (isUserSaved) {
            UserFrame.lblErrorMessage.setForeground(Color.GREEN);
            UserFrame.lblErrorMessage.setText("User saved successfully ");

        } else {
            UserFrame.lblErrorMessage.setForeground(Color.RED);
            UserFrame.lblErrorMessage.setText("User already exists");
        }
    }

    public static void getButtonText(String buttonText) {
        btnText = buttonText;
    }

    public List<String> getUsernameList() {
        return new UserDAO().getUsernameList();
    }

    public boolean changePassword(UserBean user) {
        return new UserDAO().changePassword(user);
    }
}
