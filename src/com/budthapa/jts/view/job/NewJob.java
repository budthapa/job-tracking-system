/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budthapa.jts.view.job;

import com.budthapa.jts.business.JobBL;
import com.budthapa.jts.model.JobBean;
import static com.budthapa.jts.view.job.ViewJob.jobCompleted;

/**
 *
 * @author budthapa
 */
public class NewJob extends javax.swing.JInternalFrame {

    public NewJob() {
        initComponents();
        setVisible(true);
        JobFrame frame = new JobFrame();
        frame.getFrame();
        frame.setVisible(true);
        add(frame);
        JobFrame.jobStatusPanel.setVisible(false);
        //set button text dynamically
        //set button text to 'save' while accessing from this class
        String buttonText="Save";
        frame.setButtonText(buttonText);
    }

    public static void addNewJobRow(JobBean job) {
        //reload the ViewJob
        //need to update the table view automatically
        
        //by default the id will be set to 0 when the table is updated
        //so we need to get the recent user id and set it;
        JobBL.getRecentSavedJobId(job);
        
        Object[] rowData = {
            job.getJobId(), job.getJobName(), job.getAssigneeName(), job.isDesignTypeBlackAndWhite(),
                job.isDesignTypeColor(), job.getSizeColumn(), job.getSizeCm(), job.getClientName(),
                job.getMediaHouseName(), job.isLanguageNepali(), job.isLanguageEnglish(), job.getPosition(),
                job.getPublicationDays(), job.getJobContents(), job.getDueDate(), jobCompleted
        };
        ViewJob.table.fireTableDataChanged();
        ViewJob.table.insertRow(ViewJob.table.getRowCount(), rowData);
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
        setTitle("Add New Job");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1055, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


}