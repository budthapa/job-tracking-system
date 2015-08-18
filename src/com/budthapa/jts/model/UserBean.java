package com.budthapa.jts.model;

import java.util.Date;

public class UserBean {

    private int userId;
    private String username;
    private String newPassword;
    private String retypePassword;
    private String userPosition;
    private String userEmail;
    private String userContactNumber;
    private String userAddress;
    private boolean isUserActive=true;
    private Date joinDate = new Date();

    public UserBean() {
    }

    public UserBean(int userId, String username, String newPassword, String retypePassword, String userPosition, String userEmail, String userContactNumber, String userAddress) {
        this.userId = userId;
        this.username = username;
        this.newPassword = newPassword;
        this.retypePassword = retypePassword;
        this.userPosition = userPosition;
        this.userEmail = userEmail;
        this.userContactNumber = userContactNumber;
        this.userAddress = userAddress;
    }

    public void setIsUserActive(boolean isUserActive) {
        this.isUserActive = isUserActive;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public void setUserContactNumber(String userContactNumber) {
        this.userContactNumber = userContactNumber;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public String getUserContactNumber() {
        return userContactNumber;
    }

    public boolean isIsUserActive() {
        return isUserActive;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

}
