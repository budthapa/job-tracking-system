package com.budthapa.jts.dao;

import com.budthapa.jts.model.JobBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JobDAO extends DatabaseConnection {

    ResultSet rs;
    PreparedStatement ps;
    String comma = "','";
    private JobBean jobBean;
    private ArrayList<JobBean> job;

    public JobDAO() {
        jobBean = new JobBean();
        job = new ArrayList<>();
    }

    public boolean insertJob(JobBean job) {
        String sql = "INSERT INTO `job` (`job_name`, `assignee_name`, `black_and_white`, `color`, `client_name`, `media_house_name`, `position`, `language_nepali`, `language_english`, `due_date`, `create_date`,`size_col`, `size_cm`, `job_content`,`publication_days`, `job_completed`,`user_id`) VALUES ('"
                + job.getJobName() + comma + job.getAssigneeName() + comma + String.valueOf(job.isDesignTypeBlackAndWhite()) + comma
                + String.valueOf(job.isDesignTypeColor()) + comma + job.getClientName() + comma + job.getMediaHouseName() + comma + job.getPosition()
                + comma + String.valueOf(job.isLanguageNepali()) + comma + String.valueOf(job.isLanguageEnglish()) + comma + job.getDueDate() + comma
                + job.getCreateDate().toString() + comma + job.getSizeColumn() + comma + job.getSizeCm() + comma + job.getJobContents() + comma
                + job.getPublicationDays() + comma + String.valueOf(job.isJobCompleted()) + comma + job.getUserId() + "')";
        return this.insert(sql);
    }

    /*
     * Check if Job already exists
     */
    public boolean getJobName(String jobName) {
        try {
            String sql = "select count(job_name) from job where job_name=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, jobName);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("count(job_name)") > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }

    public ArrayList<JobBean> getJobList() {
        job = new ArrayList<>();
        rs = this.select("SELECT * FROM job");
        try {
            while (rs.next()) {
                jobBean = new JobBean(rs.getInt("job_id"), rs.getString("job_name"), rs.getString("assignee_name"), Boolean.parseBoolean(rs.getString("black_and_white")), Boolean.parseBoolean(rs.getString("color")), rs.getString("size_col"), rs.getString("size_cm"), rs.getString("due_date"), rs.getString("client_name"), rs.getString("media_house_name"), Boolean.parseBoolean(rs.getString("language_nepali")), Boolean.parseBoolean(rs.getString("language_english")), rs.getString("position"), rs.getInt("publication_days"), rs.getString("job_content"));
                jobBean.setJobCompleted(Boolean.parseBoolean(rs.getString("job_completed")));
                job.add(jobBean);
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return job;
    }

    public boolean deleteJob(int jobIdToDelete) {
        return this.delete("DELETE FROM `job` WHERE `job_id`=" + jobIdToDelete);
    }

    public boolean updateJob(JobBean job) {
        String comma="',";
        System.out.println("job name "+job.getJobName()+" id "+job.getJobId()+" contents "+job.getJobContents());
        String sql = "UPDATE `job` SET `job_name`='" + job.getJobName() + comma + "`assignee_name`='" + job.getAssigneeName()
                + comma + "`black_and_white`='" + String.valueOf(job.isDesignTypeBlackAndWhite()) + comma + "`color`='" + String.valueOf(job.isDesignTypeColor())
                + comma + "`client_name`='" + job.getClientName() + comma + " `media_house_name`='" + job.getMediaHouseName() + comma
                + " `position`='" + job.getPosition() + comma + " `language_nepali`='" + String.valueOf(job.isLanguageNepali()) + comma
                + "`language_english`='" + String.valueOf(job.isLanguageEnglish()) + comma + " `due_date`='" + job.getDueDate() + comma
                + "`size_col`='" + job.getSizeColumn() + comma + " `size_cm`='" + job.getSizeCm() + comma + " `job_content`='" + job.getJobContents() + comma
                + "`publication_days`='" + job.getPublicationDays() + "' WHERE `job_id`=" + job.getJobId();
        boolean jobupdate=this.update(sql);
        System.out.println("updated : "+jobupdate);
        return jobupdate;
    }

    public void getRecentlySavedJobId(JobBean job) {
        try {
            rs = this.select("select max(job_id) from job");
            while (rs.next()) {
                job.setJobId(rs.getInt("max(job_id)"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.disconnect();
    }

    public boolean markJobAsCompleted(JobBean job) {
        return this.update("UPDATE `job` SET `job_completed`='" + job.isJobCompleted() + "' WHERE `job_id`=" + job.getJobId());
    }

    public ArrayList<JobBean> getIncompleteJobs() {
        try {
            this.getDBConnection();
            job = new ArrayList<>();
            rs = this.select("SELECT * FROM job where job_completed=false");
            while (rs.next()) {
                jobBean = new JobBean(rs.getInt("job_id"), rs.getString("job_name"), rs.getString("assignee_name"), Boolean.parseBoolean(rs.getString("black_and_white")), Boolean.parseBoolean(rs.getString("color")), rs.getString("size_col"), rs.getString("size_cm"), rs.getString("due_date"), rs.getString("client_name"), rs.getString("media_house_name"), Boolean.parseBoolean(rs.getString("language_nepali")), Boolean.parseBoolean(rs.getString("language_english")), rs.getString("position"), rs.getInt("publication_days"), rs.getString("job_content"));
                jobBean.setJobCompleted(Boolean.parseBoolean(rs.getString("job_completed")));
                job.add(jobBean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.disconnect();
        return job;
    }

    public List<JobBean> searchJob(String search) {
        job = new ArrayList<>();
        try {
            rs = this.select("select * from job where job_name like \"%" + search + "%\" or job_content like \"%" + search + "%\"");
            while (rs.next()) {
                jobBean = new JobBean(rs.getInt("job_id"), rs.getString("job_name"), rs.getString("assignee_name"), Boolean.parseBoolean(rs.getString("black_and_white")), Boolean.parseBoolean(rs.getString("color")), rs.getString("size_col"), rs.getString("size_cm"), rs.getString("due_date"), rs.getString("client_name"), rs.getString("media_house_name"), Boolean.parseBoolean(rs.getString("language_nepali")), Boolean.parseBoolean(rs.getString("language_english")), rs.getString("position"), rs.getInt("publication_days"), rs.getString("job_content"));
                jobBean.setJobCompleted(Boolean.parseBoolean(rs.getString("job_completed")));
                job.add(jobBean);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.disconnect();
        return job;
    }
}
