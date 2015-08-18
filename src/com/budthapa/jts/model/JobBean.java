/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budthapa.jts.model;

import java.util.Date;

/**
 *
 * @author budthapa
 */
public class JobBean {

    private int jobId;
    private String jobName;
    private String assigneeName;
    private boolean designTypeBlackAndWhite;
    private boolean designTypeColor;
    private String sizeColumn;
    private String sizeCm;
    private String dueDate;
    private String clientName;
    private String mediaHouseName;
    private boolean languageNepali;
    private boolean languageEnglish;
    private String position;
    private int publicationDays;
    private String jobContents;
    private Date createDate = new Date();
    private boolean jobCompleted=false;
    private int userId;

    public JobBean() {
    }

    public JobBean(int jobId, String jobName, String assigneeName, boolean designTypeBlackAndWhite, boolean designTypeColor, String sizeColumn, String sizeCm, String dueDate, String clientName, String mediaHouseName, boolean languageNepali, boolean languageEnglish, String position, int publicationDays, String jobContents) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.assigneeName = assigneeName;
        this.designTypeBlackAndWhite = designTypeBlackAndWhite;
        this.designTypeColor = designTypeColor;
        this.sizeColumn = sizeColumn;
        this.sizeCm = sizeCm;
        this.dueDate = dueDate;
        this.clientName = clientName;
        this.mediaHouseName = mediaHouseName;
        this.languageNepali = languageNepali;
        this.languageEnglish = languageEnglish;
        this.position = position;
        this.publicationDays = publicationDays;
        this.jobContents = jobContents;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setJobCompleted(boolean jobCompleted) {
        this.jobCompleted = jobCompleted;
    }

    public boolean isJobCompleted() {
        return jobCompleted;
    }

    public void setJobContents(String jobContents) {
        this.jobContents = jobContents;
    }

    public String getJobContents() {
        return jobContents;
    }


    public void setSizeCm(String sizeCm) {
        this.sizeCm = sizeCm;
    }

    public void setSizeColumn(String sizeColumn) {
        this.sizeColumn = sizeColumn;
    }

    public String getSizeCm() {
        return sizeCm;
    }

    public String getSizeColumn() {
        return sizeColumn;
    }

    
    public void setDesignTypeBlackAndWhite(boolean designTypeBlackAndWhite) {
        this.designTypeBlackAndWhite = designTypeBlackAndWhite;
    }

    public void setDesignTypeColor(boolean designTypeColor) {
        this.designTypeColor = designTypeColor;
    }

    public boolean isDesignTypeBlackAndWhite() {
        return designTypeBlackAndWhite;
    }

    public boolean isDesignTypeColor() {
        return designTypeColor;
    }

    public void setLanguageEnglish(boolean languageEnglish) {
        this.languageEnglish = languageEnglish;
    }

    public void setLanguageNepali(boolean languageNepali) {
        this.languageNepali = languageNepali;
    }

    public boolean isLanguageEnglish() {
        return languageEnglish;
    }

    public boolean isLanguageNepali() {
        return languageNepali;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public String getClientName() {
        return clientName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public int getJobId() {
        return jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public String getMediaHouseName() {
        return mediaHouseName;
    }

    public String getPosition() {
        return position;
    }

    public int getPublicationDays() {
        return publicationDays;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setMediaHouseName(String mediaHouseName) {
        this.mediaHouseName = mediaHouseName;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPublicationDays(int publicationDays) {
        this.publicationDays = publicationDays;
    }

}
