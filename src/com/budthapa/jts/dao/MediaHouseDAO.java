package com.budthapa.jts.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.budthapa.jts.model.MediaHouseBean;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MediaHouseDAO extends DatabaseConnection {

    PreparedStatement ps;
    ResultSet rs;

    private MediaHouseBean mediaHouseBean;
    private ArrayList<MediaHouseBean> mediaHouse;

    public MediaHouseDAO() {
        mediaHouseBean = new MediaHouseBean();
        mediaHouse = new ArrayList<>();
    }

    public boolean insertMedia(MediaHouseBean media) {
        String comma = "','";
        String sql = "INSERT INTO `media` (`media_name`, `media_email`, `media_contact_person`, `media_contact_number`, `media_fax`, `media_address`, `media_join_date`, `isNewspaper`, `isTelevision`, `isRadio`, `isOnline`, `isMagazine`, `isOthers`, `media_other`) VALUES ('"
                + media.getMediaName() + comma + media.getMediaEmail() + comma + media.getMediaContactPerson() + comma + media.getMediaContactNumber() + comma
                + media.getMediaFax() + comma + media.getMediaAddress() + comma + media.getJoinDate().toString() + comma + String.valueOf(media.isNewspaper()) + comma
                + String.valueOf(media.isTelevision()) + comma + String.valueOf(media.isRadio()) + comma + String.valueOf(media.isOnline()) + comma
                + String.valueOf(media.isMagazine()) + comma + String.valueOf(media.isOther()) + comma + media.getOtherMedia() + "')";
        return this.insert(sql);
    }

    public boolean getMediaHouseName(String name) {
        rs = this.select("select count(media_name) from media where media_name='" + name + "'");
        try {
            while (rs.next()) {
                if (rs.getInt("count(media_name)") > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.disconnect();
        return false;
    }

    public ArrayList<MediaHouseBean> getMediaHouseList() {
        mediaHouse = new ArrayList<>();
        rs = this.select("SELECT * FROM media");
        try {
            while (rs.next()) {
                mediaHouseBean = new MediaHouseBean(rs.getInt("media_id"), rs.getString("media_name"), rs.getString("media_email"), rs.getString("media_contact_person"), rs.getString("media_contact_number"), rs.getString("media_fax"), rs.getString("media_address"), rs.getBoolean("isNewspaper"), rs.getBoolean("isTelevision"), rs.getBoolean("isRadio"), rs.getBoolean("isOnline"), rs.getBoolean("isMagazine"), rs.getBoolean("isOthers"), rs.getString("media_other"));
                mediaHouse.add(mediaHouseBean);
            }
            //disconnect the connection here
        } catch (SQLException ex) {
            Logger.getLogger(MediaHouseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.disconnect();
        return mediaHouse;
    }

    public boolean deleteMediaHouse(int mediaHouseIdToDelete) {
        return this.delete("DELETE FROM `media` WHERE `media_id`=" + mediaHouseIdToDelete);
    }

    public boolean updateMediaHouse(MediaHouseBean media) {
        String comma = "',";
        String sql = "UPDATE `media` SET `media_name`='" + media.getMediaName() + comma + " `media_email`='" + media.getMediaEmail() + comma
                + " `media_contact_person`='" + media.getMediaContactPerson() + comma + " `media_contact_number`='" + media.getMediaContactNumber() + comma
                + " `media_fax`='" + media.getMediaFax() + comma + " `media_address`='" + media.getMediaAddress() + comma + " `isNewspaper`='" + String.valueOf(media.isNewspaper())
                + comma + " `isTelevision`='" + String.valueOf(media.isTelevision()) + comma + " `isRadio`='" + String.valueOf(media.isRadio()) + comma
                + " `isOnline`='" + String.valueOf(media.isOnline()) + comma + " `isMagazine`='" + String.valueOf(media.isMagazine()) + comma
                + " `isOthers`='" + String.valueOf(media.isOther()) + comma + " `media_other`='" + media.getOtherMedia() + "' WHERE `media_id`=" + media.getMediaId();
        return this.update(sql);
    }

    public void getRecentlySavedMediaHouseId(MediaHouseBean media) {
        rs = this.select("select max(media_id) from job_tracking_system.media");
        try {
            while (rs.next()) {
                media.setMediaId(rs.getInt("max(media_id)"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MediaHouseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.disconnect();
    }

    public List<String> getMediaHouseNameList() {
        List<String> clientNameList = new ArrayList<>();
        rs = this.select("SELECT media_name from job_tracking_system.media");
        try {
            while (rs.next()) {
                clientNameList.add(rs.getString("media_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.disconnect();
        return clientNameList;
    }
}
