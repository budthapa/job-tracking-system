package com.budthapa.jts.dao;

import com.budthapa.jts.model.UserBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO extends DatabaseConnection{

    
    ResultSet rs;
    PreparedStatement ps;

    private UserBean userBean;
    private ArrayList<UserBean> user;

    public UserDAO() {
        super();
        userBean = new UserBean();
        user = new ArrayList<>();
    }

    public boolean insertUser(UserBean user) {
        try {
            String sql = "INSERT INTO `job_tracking_system`.`users` (`username`, `password`, `position`, `email`, `contact_number`, `address`, `isactive`, `join_date`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getNewPassword());
            ps.setString(3, user.getUserPosition());
            ps.setString(4, user.getUserEmail());
            ps.setString(5, user.getUserContactNumber());
            ps.setString(6, user.getUserAddress());
            ps.setString(7, String.valueOf(user.isIsUserActive()));
            ps.setString(8, user.getJoinDate().toString());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /*
     * Check if User already exists
     */

    public boolean getUserName(String userName) {
        try {
            this.getDBConnection();
            String sql = "select count(username) from job_tracking_system.users where username=?";
            System.out.println("con "+connection+" username "+userName);
            ps = this.connection.prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("count(username)") > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }

    public ArrayList<UserBean> getUserList() {
        user = new ArrayList<>();
        try {
            String sql = "SELECT * FROM job_tracking_system.users";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                userBean = new UserBean(rs.getInt("user_id"), rs.getString("username"), "", "", rs.getString("position"), rs.getString("email"), rs.getString("contact_number"), rs.getString("address"));
                user.add(userBean);
            }
            //disconnect the connection here
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public boolean deleteUser(int userIdToDelete) {
        try {
            String sql = "DELETE FROM `job_tracking_system`.`users` WHERE `user_id`=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, userIdToDelete);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateUser(UserBean user) {
        try {
            String sql = "UPDATE `job_tracking_system`.`users` SET `username`=?, `position`=?, `email`=?, `contact_number`=?, `address`=? WHERE `user_id`=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getUserPosition());
            ps.setString(3, user.getUserEmail());
            ps.setString(4, user.getUserContactNumber());
            ps.setString(5, user.getUserAddress());
            ps.setInt(6, user.getUserId());
            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void getRecentlySavedUserId(UserBean user) {
        try {
            String sql = "select max(user_id) from job_tracking_system.users;";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                user.setUserId(rs.getInt("max(user_id)"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> getUserNameList() {
        try {
            List<String> userNameList = new ArrayList<>();
            String sql = "SELECT username from job_tracking_system.users";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                userNameList.add(rs.getString("user_name"));
            }
            return userNameList;
        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<String> getUsernameList() {
        try {
            this.getDBConnection();
            List<String> jobNameList = new ArrayList<>();
            String sql = "SELECT username FROM job_tracking_system.users";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                jobNameList.add(rs.getString("username"));
            }
            return jobNameList;
        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getUserPassword(int userId) {
        try {
            this.getDBConnection();
            String sql = "select password from users where user_id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("password");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean checkVaildUser(UserBean user) {
        return getUserName(user.getUsername());
    }

    public int getUserId(UserBean user) {
        try {
            this.getDBConnection();
            String sql = "select user_id from users where username=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("user_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public boolean changePassword(UserBean user) {
        try {
            String sql = "UPDATE `job_tracking_system`.`users` SET `password`=? WHERE `user_id`=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getNewPassword()); System.out.println("password "+user.getNewPassword());
            ps.setInt(2, user.getUserId());
            int ok=ps.executeUpdate();
            if(ok==1){return true;}
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
