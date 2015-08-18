package com.budthapa.jts.dao;

import com.budthapa.jts.model.ClientBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Buddhi Bal Thapa, budthapa@gmail.com
 */
public class ClientDAO extends DatabaseConnection {

    ResultSet rs;
    PreparedStatement ps;

    private ClientBean clientBean;
    private ArrayList<ClientBean> client;

    public ClientDAO() {
        clientBean = new ClientBean();
        client = new ArrayList<>();
    }

    public boolean insertClient(ClientBean client) {
        String comma = "','";
        String sql = "INSERT INTO `client` (`client_name`, `client_type`, `client_email`, `client_contact_number`, `client_fax_number`, `client_contact_person`, `client_address`, `client_join_date`) VALUES ('" + client.getClientName() + comma + client.getClientType() + comma + client.getClientEmail() + comma + client.getClientContactNumber() + comma + client.getClientFaxNumber() + comma + client.getClientContactPerson() + comma + client.getClientAddress() + comma + client.getClientJoinDate().toString() + "')";
        return this.insert(sql);
    }
    
    /*
     * Check if Client already exists
     */
    public boolean getClientName(String clientName) {
        try {
            this.getDBConnection();
            String sql = "select count(client_name) from client where client_name=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, clientName);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("count(client_name)") > 0) {
                    return true;
                }
            }
            this.disconnect();
        } catch (SQLException e) {
        }
        return false;

    }

    public ArrayList<ClientBean> getClientList() {
        client = new ArrayList<>();
        try {
            this.getDBConnection();
            String sql = "SELECT * FROM job_tracking_system.client";
            rs = this.select(sql);
            while (rs.next()) {
                clientBean = new ClientBean(rs.getInt("client_id"), rs.getString("client_name"), rs.getString("client_type"), rs.getString("client_email"), rs.getString("client_contact_person"), rs.getString("client_contact_number"), rs.getString("client_fax_number"), rs.getString("client_address"));
                client.add(clientBean);
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;
    }

    public boolean deleteClient(int clientIdToDelete) {
        String sql = "DELETE FROM `job_tracking_system`.`client` WHERE `client_id`="+clientIdToDelete;
        return this.delete(sql);
    }

    public boolean updateClient(ClientBean client) {
            String sql = "UPDATE `client` SET `client_name`='"+client.getClientName()+"', `client_type`='"+client.getClientType()+"', `client_email`='"+client.getClientEmail()+"', `client_contact_person`='"+client.getClientContactPerson()+"', `client_contact_number`='"+client.getClientContactNumber()+"', `client_fax_number`='"+client.getClientFaxNumber()+"', `client_address`='"+client.getClientAddress()+"' WHERE `client_id`="+client.getClientId();
            return this.update(sql);
    }

    public void getRecentlySavedUserId(ClientBean client) {
        try {
            this.getDBConnection();
            String sql = "select max(client_id) from job_tracking_system.client;";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                client.setClientId(rs.getInt("max(client_id)"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.disconnect();
    }

    public List<String> getClientNameList() {
        try {
            this.getDBConnection();
            List<String> clientNameList = new ArrayList<>();
            String sql = "SELECT client_name from job_tracking_system.client";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                clientNameList.add(rs.getString("client_name"));
            }
            return clientNameList;
        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.disconnect();
        return null;
    }
}
