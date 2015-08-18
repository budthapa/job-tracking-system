package com.budthapa.jts.model;

import com.budthapa.jts.helpers.ErrorMessages;
import com.budthapa.jts.helpers.Validator;
import com.budthapa.jts.view.media.MediaHouseFrame;
import java.awt.Color;
import java.util.Date;

public class MediaHouseBean {

    private int mediaId;
    private String mediaName;
    private String mediaEmail;
    private String mediaContactNumber;
    private String mediaContactPerson;
    private String mediaFax;
    private String mediaAddress;
    private boolean isNewspaper;
    private boolean isTelevision;
    private boolean isRadio;
    private boolean isOnline;
    private boolean isMagazine;
    private boolean isOther;
    private String otherMedia;
    private Date joinDate = new Date();

    private int countService;

    public MediaHouseBean(int mediaId, String mediaName, String mediaEmail, String mediaContactPerson,String mediaContactNumber, String mediaFaxNumber,
             String mediaAddress, boolean newspaper, boolean tv, boolean fmRadio, boolean online, boolean magazine, boolean isOther, String otherMedia) {
        this.mediaId = mediaId;
        this.mediaName = mediaName;
        this.mediaEmail = mediaEmail;
        this.mediaContactNumber = mediaContactNumber;
        this.mediaFax = mediaFaxNumber;
        this.mediaContactPerson = mediaContactPerson;
        this.mediaAddress = mediaAddress;
        this.isNewspaper=newspaper;
        this.isTelevision=tv;
        this.isRadio=fmRadio;
        this.isOnline=online;
        this.isMagazine=magazine;
        this.isOther=isOther;
        this.otherMedia=otherMedia;
        
    }

    public MediaHouseBean() {
    }

    public String getMediaContactNumber() {
        return mediaContactNumber;
    }

    public void setMediaContactNumber(String mediaContactNumber) {
        this.mediaContactNumber = mediaContactNumber;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public int getCountService() {
        return countService;
    }

    public void setCountService(int countService) {
        this.countService = countService;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getMediaEmail() {
        return mediaEmail;
    }

    public void setMediaEmail(String mediaEmail) {
        this.mediaEmail = mediaEmail;
    }

    public String getMediaContactPerson() {
        return mediaContactPerson;
    }

    public void setMediaContactPerson(String mediaContactPerson) {
        this.mediaContactPerson = mediaContactPerson;
    }

    public String getMediaFax() {
        return mediaFax;
    }

    public void setMediaFax(String mediaFax) {
        this.mediaFax = mediaFax;
    }

    public String getMediaAddress() {
        return mediaAddress;
    }

    public void setMediaAddress(String mediaAddress) {
        this.mediaAddress = mediaAddress;
    }

    public boolean isNewspaper() {
        return isNewspaper;
    }

    public void setNewspaper(boolean isNewspaper) {
        this.isNewspaper = isNewspaper;
    }

    public boolean isTelevision() {
        return isTelevision;
    }

    public void setTelevision(boolean isTelevision) {
        this.isTelevision = isTelevision;
    }

    public boolean isRadio() {
        return isRadio;
    }

    public void setRadio(boolean isRadio) {
        this.isRadio = isRadio;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public boolean isMagazine() {
        return isMagazine;
    }

    public void setMagazine(boolean isMagazine) {
        this.isMagazine = isMagazine;
    }

    public boolean isOther() {
        return isOther;
    }

    public void setOther(boolean isOther) {
        this.isOther = isOther;
    }

    public String getOtherMedia() {
        return otherMedia;
    }

    public void setOtherMedia(String otherMedia) {
        this.otherMedia = otherMedia;
    }

}
