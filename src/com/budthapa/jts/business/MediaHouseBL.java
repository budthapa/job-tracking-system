package com.budthapa.jts.business;

import com.budthapa.jts.dao.MediaHouseDAO;
import com.budthapa.jts.helpers.ErrorMessages;
import com.budthapa.jts.helpers.Validator;
import com.budthapa.jts.model.MediaHouseBean;
import com.budthapa.jts.view.media.EditMediaHouse;
import com.budthapa.jts.view.media.MediaHouseFrame;
import com.budthapa.jts.view.media.NewMediaHouse;
import java.awt.Color;
import java.util.ArrayList;

public class MediaHouseBL {

    private static String msg = "Please select at least one Media type";

    private static String btnText;
    public static boolean isViewClientClassOpen;

    public static boolean areFieldsEmpty(MediaHouseBean media) {

        if (media.getMediaName().isEmpty()) {
            MediaHouseFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.NAME_EMPTY;
            return false;
        }

        //now validate name
        if (!Validator.nameValidator(media.getMediaName())) {
            System.out.println("invalid name");
            MediaHouseFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.INVALID_NAME;
            return false;
        }

        if (!media.isNewspaper() && !media.isTelevision() && !media.isRadio() && !media.isOnline() && !media.isMagazine() && !media.isOther()) {
            MediaHouseFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = "Please select at least one media type";
            return false;
        }

        //we might validate the field if user clicks other options
        if (media.getMediaEmail().isEmpty()) {
            MediaHouseFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.EMAIL_EMPTY;
            return false;
        }

        if (!Validator.emailValidator(media.getMediaEmail())) {
            MediaHouseFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.INVALID_EMAIL;
            return false;
        }

        if (media.getMediaContactPerson().isEmpty()) {
            MediaHouseFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.CONTACT_PERSON_EMPTY;
            return false;
        }

        if (!Validator.nameValidator(media.getMediaContactPerson())) {
            MediaHouseFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.INVALID_NAME;
            return false;
        }

        if (media.getMediaContactNumber().isEmpty()) {
            MediaHouseFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.CONTACT_NUMBER_EMPTY;
            return false;
        }

        if (!Validator.phoneNoValidator(media.getMediaContactNumber())) {
            System.out.println("invalid phone");
            MediaHouseFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.INVALID_PHONE_FAX;
            return false;
        }

        if (!Validator.phoneNoValidator(media.getMediaFax())) {
            System.out.println("invalid fax");
            MediaHouseFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.INVALID_PHONE_FAX;
            return false;
        }

        if (media.getMediaAddress().isEmpty()) {
            MediaHouseFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.ADDRESS_EMPTY;
            return false;
        }
        return true;
    }

    public static boolean mediaHouseDataIsSaved(MediaHouseBean media) {
        boolean isMediaAlreadyExists = checkIfMediaAlreadyExists(media.getMediaName());
        if (btnText.equals("Save")) {
            if (!isMediaAlreadyExists) {

                //referesh the table only if ViewClient class is already open
                //if we will not do this, execption will be thrown while creating new user
                //because it will try to referesh the table which is yet not created
                if (isViewClientClassOpen) {
                    NewMediaHouse.addNewMediaHouseRow(media);
                }
                return new MediaHouseDAO().insertMedia(media);
            }
            return false;
        } else {
            //update the database here
            boolean updated = new MediaHouseDAO().updateMediaHouse(media);
            if (updated) {
                EditMediaHouse.refreshTableAfterUpdate(media);
            }
            return updated;
        }
    }

    public static boolean checkIfMediaAlreadyExists(String mediaName) {
        return new MediaHouseDAO().getMediaHouseName(mediaName);
    }

    public static boolean deleteMediaHouse(int mediaIdToDelete) {
        return new MediaHouseDAO().deleteMediaHouse(mediaIdToDelete);
    }

    public static void getRecentSavedMediaHouseId(MediaHouseBean media) {
        new MediaHouseDAO().getRecentlySavedMediaHouseId(media);
    }

    public ArrayList<MediaHouseBean> getMediaHouseList() {
        return new MediaHouseDAO().getMediaHouseList();
    }

    public static void passMediaHouseObject(MediaHouseBean mhb) {
        boolean isFieldEmpty = areFieldsEmpty(mhb);
        if (!isFieldEmpty) {
            MediaHouseFrame.lblErrorMessage.setText(ErrorMessages.errorMessage);
            return;
        }

        //save media data
        boolean isMediaHouseSaved = mediaHouseDataIsSaved(mhb);
        if (isMediaHouseSaved) {
            MediaHouseFrame.lblErrorMessage.setForeground(Color.GREEN);
            MediaHouseFrame.lblErrorMessage.setText("Media House saved successfully ");

        } else {
            MediaHouseFrame.lblErrorMessage.setForeground(Color.RED);
            MediaHouseFrame.lblErrorMessage.setText("Media House already exists");
        }
    }

    public static void getButtonText(String buttonText) {
        btnText = buttonText;
    }
}
