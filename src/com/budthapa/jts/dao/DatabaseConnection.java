package com.budthapa.jts.dao;

import com.budthapa.jts.helpers.Property;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

    protected Connection connection;
    private final String URL;
    private final String HOST;
    private final String PORT;
    private final String DATABASE_NAME;
    private final String USERNAME;
    private final String PASSWORD;

    private final String dbUrl = "DB_URL";
    private final String dbHost = "DB_HOST";
    private final String dbPort = "DB_PORT";
    private final String dbName = "DB_NAME";
    private final String dbUser = "DB_USERNAME";
    private final String dbPass = "DB_PASSWORD";

    PreparedStatement ps;
    ResultSet rs;

    public DatabaseConnection() {
        Property prop = new Property();
        this.URL = prop.getProperties().getProperty(dbUrl);
        this.HOST = prop.getProperties().getProperty(dbHost);
        this.PORT = prop.getProperties().getProperty(dbPort);
        this.DATABASE_NAME = prop.getProperties().getProperty(dbName);
        this.USERNAME = prop.getProperties().getProperty(dbUser);
        this.PASSWORD = prop.getProperties().getProperty(dbPass);
    }

    public String getFullUrl() {
        return URL + HOST + ":" + PORT + "/" + DATABASE_NAME;
    }

    public String getUsername(){
        return this.USERNAME;
    }
    
    public String getPassword(){
        return this.PASSWORD;
    }
    
    public void getDBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(getFullUrl(), getUsername(), getPassword());
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect() {
        if (this.connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Run select query in database
     *
     * @param sql
     * @return
     */
    public ResultSet select(String sql) {
        try {
            getDBConnection();
            this.ps = this.connection.prepareStatement(sql);
            this.ps.executeQuery();
            this.rs = ps.getResultSet();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Insert data into database
     *
     * @param sql
     * @return
     */
    public boolean insert(String sql) {
        try {
            getDBConnection();
            ps = connection.prepareCall(sql);
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Update database table
     *
     * @param sql
     * @return
     */
    public boolean update(String sql) {
        try {
            getDBConnection();
            ps = connection.prepareStatement(sql);
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Delete from database
     *
     * @param sql
     * @return
     */
    public boolean delete(String sql) {
        try {
            getDBConnection();
            ps = connection.prepareStatement(sql);
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.disconnect();
        return false;
    }

}
