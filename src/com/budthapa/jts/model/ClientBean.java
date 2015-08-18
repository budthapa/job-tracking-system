package com.budthapa.jts.model;

import java.util.Date;

public class ClientBean {
	private int clientId;
	private String clientName;
	private String clientType;
	private String clientEmail;
	private String clientContactPerson;
	private String clientContactNumber;
	private String clientFaxNumber;
	private String clientAddress;
	private Date clientJoinDate=new Date();
        
        public ClientBean(){}

    public ClientBean(int clientId, String clientName, String clientType, String clientEmail, String clientContactPerson, String clientContactNumber, String clientFaxNumber, String clientAddress) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientType = clientType;
        this.clientEmail = clientEmail;
        this.clientContactPerson = clientContactPerson;
        this.clientContactNumber = clientContactNumber;
        this.clientFaxNumber = clientFaxNumber;
        this.clientAddress = clientAddress;
    }
        
        	public Date getClientJoinDate() {
		return clientJoinDate;
	}
	public void setClientJoinDate(Date clientJoinDate) {
		this.clientJoinDate = clientJoinDate;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public String getClientContactNumber() {
		return clientContactNumber;
	}
	public void setClientContactNumber(String clientContactNumber) {
		this.clientContactNumber = clientContactNumber;
	}
	public String getClientFaxNumber() {
		return clientFaxNumber;
	}
	public void setClientFaxNumber(String clientFaxNumber) {
		this.clientFaxNumber = clientFaxNumber;
	}
	public String getClientContactPerson() {
		return clientContactPerson;
	}
	public void setClientContactPerson(String clientContactPerson) {
		this.clientContactPerson = clientContactPerson;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	
}
