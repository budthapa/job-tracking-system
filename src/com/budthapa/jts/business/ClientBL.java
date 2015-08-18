package com.budthapa.jts.business;

import com.budthapa.jts.dao.ClientDAO;
import com.budthapa.jts.helpers.ErrorMessages;
import com.budthapa.jts.helpers.Validator;
import com.budthapa.jts.model.ClientBean;
import com.budthapa.jts.view.clients.ClientFrame;
import com.budthapa.jts.view.clients.EditClient;
import com.budthapa.jts.view.clients.NewClient;
import java.awt.Color;
import java.util.ArrayList;

public class ClientBL {

    private static String btnText;
    public static boolean isViewClientClassOpen;

    public static boolean checkIfFieldsAreValid(ClientBean client) {
        if (client.getClientName().isEmpty()) {
            ClientFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.NAME_EMPTY;
            return true;
        }

        //now validate name
        if (!Validator.nameValidator(client.getClientName())) {
            ClientFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.INVALID_NAME;
            return true;
        }

        if (client.getClientEmail().isEmpty()) {
            ClientFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.EMAIL_EMPTY;
            return true;
        }

        if (!Validator.emailValidator(client.getClientEmail())) {
            ClientFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.INVALID_EMAIL;
            return true;
        }

        if (client.getClientContactNumber().isEmpty()) {
            ClientFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.CONTACT_PERSON_EMPTY;
            return true;
        }

        if (!Validator.nameValidator(client.getClientContactPerson())) {
            ClientFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.INVALID_NAME;
            return true;
        }

        if (client.getClientContactNumber().isEmpty()) {
            ClientFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.CONTACT_NUMBER_EMPTY;
            return true;
        }

        if (!Validator.phoneNoValidator(client.getClientContactNumber())) {
            ClientFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.INVALID_PHONE_FAX;
            return true;
        }

        if (!Validator.phoneNoValidator(client.getClientFaxNumber())) {
            ClientFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.INVALID_PHONE_FAX;
            return true;
        }

        if (client.getClientAddress().isEmpty()) {
            ClientFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.ADDRESS_EMPTY;
            return true;
        }
        return false;
    }

    public static boolean checkIfClientAlreadyExists(String clientName) {
        return new ClientDAO().getClientName(clientName);
    }

    public static boolean deleteClient(int clientIdToDelete) {
        return new ClientDAO().deleteClient(clientIdToDelete);
    }

    public static void getRecentSavedUserId(ClientBean client) {
        new ClientDAO().getRecentlySavedUserId(client);
    }

    public ArrayList<ClientBean> getClientList() {
        return new ClientDAO().getClientList();
    }

    public static void passClientObject(ClientBean cb) {
        //if fields are empty, it will return false
        boolean isFieldEmpty = checkIfFieldsAreValid(cb);
        if (!isFieldEmpty) {
            //save client data
            boolean isClientSaved = clientDataIsSaved(cb);
            if (isClientSaved) {
                ClientFrame.lblErrorMessage.setForeground(Color.GREEN);
                ClientFrame.lblErrorMessage.setText("Client saved successfully ");
            } else {
                ClientFrame.lblErrorMessage.setForeground(Color.RED);
                ClientFrame.lblErrorMessage.setText("Client already exists");
            }
        } else {
            ClientFrame.lblErrorMessage.setText(ErrorMessages.errorMessage);
        }
    }

    public static boolean clientDataIsSaved(ClientBean client) {
        boolean isClientAlreadyExists = checkIfClientAlreadyExists(client.getClientName());
        if (btnText.equals("Save")) {
            if (!isClientAlreadyExists) {
                int rowCountBeforeAddingNewClient = 0;
                NewClient.rowCountBeforeAddingNewClient = rowCountBeforeAddingNewClient;

                //referesh the table only if ViewClient class is already open
                //if we will not do this, execption will be thrown while creating new user
                //because it will try to referesh the table which is yet not created
                if (isViewClientClassOpen) {
                    NewClient.addNewClientRow(client);
                }
                boolean ins=new ClientDAO().insertClient(client);
                return ins;
            }
            return false;
        } else {
//            if (!isClientAlreadyExists) {
            //update the database here
            boolean updated = new ClientDAO().updateClient(client);
            if (updated) {
                EditClient.refreshTableAfterUpdate(client);
            }
            return updated;

//            }
//            return false;
        }
    }

    public static void getButtonText(String buttonText) {
        btnText = buttonText;
    }
}
