package com.budthapa.jts.business;

import com.budthapa.jts.dao.ClientDAO;
import com.budthapa.jts.dao.JobDAO;
import com.budthapa.jts.dao.MediaHouseDAO;
import com.budthapa.jts.helpers.ErrorMessages;
import com.budthapa.jts.helpers.ErrorPanel;
import com.budthapa.jts.helpers.Validator;
import com.budthapa.jts.model.JobBean;
import com.budthapa.jts.view.job.EditJob;
import com.budthapa.jts.view.job.JobFrame;
import com.budthapa.jts.view.job.NewJob;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class JobBL extends ErrorPanel{
    
    
    private static String btnText;
    private final String RED_COLOR="RED";
    public static boolean isViewJobClassOpen;

    public boolean areFieldsEmpty(JobBean job) {
        System.out.println("checking empty fields");
        if (job.getJobName().isEmpty()) {
//            this.setErrorMessageAndColor(ErrorMessages.NAME_EMPTY, RED_COLOR);
            JobFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.NAME_EMPTY;
            return false;
        }

        //now validate name
        if (!Validator.nameValidator(job.getJobName())) {
            JobFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.INVALID_NAME;
            return false;
        }

        //need to validate date
        if (!job.isDesignTypeBlackAndWhite() && !job.isDesignTypeColor()) {
            JobFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.DESIGN_TYPE_EMPTY;
            return false;
        }

        if (!job.isLanguageNepali() && !job.isLanguageEnglish()) {
            JobFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.LANGUAGE_EMPTY;
            return false;
        }

        if (job.getJobContents().isEmpty()) {
            JobFrame.lblErrorMessage.setForeground(Color.RED);
            ErrorMessages.errorMessage = ErrorMessages.JOB_CONTENT_EMPTY;
            return false;
        }
        return true;
    }

    public static boolean jobIsSaved(JobBean job) {
        //we don't need to check if the job is already exists for Job because job name may be same but contents are different
        // Notice, Congratulation, Advertisement etc
        System.out.println("btn text ... "+btnText);
        if (btnText.equals("Save")) {
            int rowCountBeforeAddingNewJob = 0;
                //referesh the table only if ViewJob class is already open
            //if we will not do this, execption will be thrown while creating new user
            //because it will try to referesh the table which is yet not created
            if (isViewJobClassOpen) {
                NewJob.addNewJobRow(job);
            }
            return new JobDAO().insertJob(job);

        } else {
//            if (!isJobAlreadyExists) {
            System.out.println("updating the database");
            //update the database here
            boolean updated = new JobDAO().updateJob(job);
            if (updated) {
                EditJob.refreshTableAfterUpdate(job);
            }
            return updated;

//            }
//            return false;
        }
    }

    public static boolean checkIfJobAlreadyExists(String clientName) {
        return new JobDAO().getJobName(clientName);
    }

    public static boolean deleteJob(int clientIdToDelete) {
        return new JobDAO().deleteJob(clientIdToDelete);
    }

    public static void getRecentSavedJobId(JobBean client) {
        new JobDAO().getRecentlySavedJobId(client);
    }

    public ArrayList<JobBean> getJobList() {
        return new JobDAO().getJobList();
    }

    public void passJobObject(JobBean jb) {
        boolean isFieldEmpty = areFieldsEmpty(jb);
        if (!isFieldEmpty) {
            JobFrame.lblErrorMessage.setText(ErrorMessages.errorMessage);
            return;
        }

        //save client data
        boolean isJobSaved = jobIsSaved(jb);
        if (isJobSaved) {
            JobFrame.lblErrorMessage.setForeground(Color.GREEN);
            JobFrame.lblErrorMessage.setText("Job saved successfully ");

        } else {
            JobFrame.lblErrorMessage.setForeground(Color.RED);
            JobFrame.lblErrorMessage.setText("Job already exists");
        }
    }

    public static void getButtonText(String buttonText) {
        btnText = buttonText;
    }

    public List<String> getClientNameList() {
        return new ClientDAO().getClientNameList();
    }

    public List<String> getMediaHouseName() {
        return new MediaHouseDAO().getMediaHouseNameList();
    }

    public boolean markJobAsCompleted(JobBean job) {
        return new JobDAO().markJobAsCompleted(job);
    }

    public ArrayList<JobBean> listOfIncompleteJobs() {
        return new JobDAO().getIncompleteJobs();
    }

    public List<JobBean> getSearchResults(String search) {
        return new JobDAO().searchJob(search);
    }
}
